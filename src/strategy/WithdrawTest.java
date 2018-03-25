package strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.MoneyFactory;
import coinpurse.Valuable;

public class WithdrawTest {
		private WithdrawStrategy  strategy;
		private MoneyFactory factory = MoneyFactory.getInstance();
		
		@Before
		public void setUp () {
			strategy = new RecursiveWithdraw();
		}
		
		 /**
		  * Create Money object for Test
		  * @param value is value of money
		  * @return Money with value.
		  */
		private Valuable makeMoney(double value) {
				return new Money(value,"XXX");
			}
		
		/**
		 * Sum value of money in list.
		 * @param value is list of Valuable
		 * @return result of summation.
		 */
		private double sum(List<Valuable> value)  {
			if (value == null) return 0.0;
			double sum = 0;
			for(Valuable v: value) if (v != null) sum += v.getValue();
			return sum;
		}
		
		@Test
		public void testWithdrawFirst() {
			List<Valuable> list = new ArrayList<Valuable>();
			Valuable target = makeMoney(5);
			list.add(target);
			list.add(makeMoney(2));
			list.add(makeMoney(3));
			List<Valuable> list2 = strategy.withdraw(target, list);
			assertEquals(5,sum(list2),1.0E-6);
		}
		
		@Test 
		public void  testWithdrawMiddle() {
			List<Valuable> list = new ArrayList<Valuable>();
			Valuable target = makeMoney(3);
			list.add(makeMoney(4));
			list.add(makeMoney(3));
			list.add(makeMoney(2));
			List<Valuable> value = strategy.withdraw(target,list);
			assertEquals(3,sum(value),1.0E-6);
		}
		
		@Test 
		public void  testWithdrawLastitem() {
			List<Valuable> list = new ArrayList<Valuable>();
			Valuable target = makeMoney(2);
			list.add(makeMoney(5));
			list.add(makeMoney(3));
			list.add(target);
			List<Valuable> value = strategy.withdraw(target,list);
			assertEquals(2,sum(value),1.0E-6);
			
		}
		
		@Test
		public void testLargeWithdraw(){
			List<Valuable> list = new ArrayList<Valuable>();
			Valuable target = makeMoney(Double.MAX_VALUE);
			list.add(makeMoney(5));
			list.add(makeMoney(2));
			
			assertNull(strategy.withdraw(target,list));
			assertTrue(list.add(target));
			
			List<Valuable> value = strategy.withdraw(target,list);
			assertEquals(Double.MAX_VALUE,sum(value),1.0E-6);
		}
		
		@Test
		public void testSimpleWithdraw(){
			List<Valuable> list = new ArrayList<Valuable>();
			Valuable target = makeMoney(4);
			
			list.add(makeMoney(5));
			list.add(makeMoney(2));
			list.add(makeMoney(2));
			
			List<Valuable> value = strategy.withdraw(target,list);
			assertEquals(4,sum(value),1.0E-6);
		}
		
		@Test
		public void testComplexWithdraw(){
			List<Valuable> list = new ArrayList<Valuable>();
			Valuable target = makeMoney(6);
			
			list.add(makeMoney(5));
			list.add(makeMoney(2));
			list.add(makeMoney(2));
			list.add(makeMoney(2));
			
			List<Valuable> value = strategy.withdraw(target,list);
			assertEquals(6,sum(value),1.0E-6);
		}
		
		@Test 
		public void  testWithdrawAllItem() {
			List<Valuable> list = new ArrayList<Valuable>();
			Valuable target = makeMoney(11);
			
			list.add(makeMoney(5));
			list.add(makeMoney(2));
			list.add(makeMoney(2));
			list.add(makeMoney(2));
			List<Valuable> list2 = strategy.withdraw(target,list);
			for(Valuable m: list2) {
				list.remove(m);
			}
			assertEquals(0,sum(list),1.0E-6);
			
		}
		
		@Test
		public void testImpossibleWithdraw() {
			List<Valuable> money = new ArrayList<Valuable>();
			List<Valuable> money2 = new ArrayList<Valuable>();
			money.add(makeMoney(20));
			money.add(new Money(100,"Ringgit"));
			money2 = strategy.withdraw(makeMoney(500), money);
			assertNull(money2);
		}
		
		@Test
		public void testDifferentCurrencyWithdraw() {
			List<Valuable> money = new ArrayList<Valuable>();
			List<Valuable> money2 = new ArrayList<Valuable>();
			money.add(new Money(20,"Ringgit"));
			money.add(makeMoney(20));
			money2 = strategy.withdraw(makeMoney(20), money);
			assertEquals(20,sum(money2),1.0E-6);
		}
		
		
		
		
}

package coinpurse;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test the MoneyFactory with JUnit.
 * @author Charin Tantrakul
 *
 */
public class MoneyFactoryTest {

	private static final double TOL = 1.0E-6;
	
	@Test
	public void testSingleton(){
		//Factory did not set any type.So factory and factory2 should not equal Thai or Malay MoneyFactory.
		MoneyFactory factory = MoneyFactory.getInstance();
		MoneyFactory factory2 = MoneyFactory.getInstance();
		assertEquals(true,factory.equals(factory2));
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		MoneyFactory factory3 = MoneyFactory.getInstance();
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		MoneyFactory factory4 = MoneyFactory.getInstance();
		assertEquals(false,factory.equals(factory3));
		assertEquals(false,factory.equals(factory4));
		assertEquals(false,factory2.equals(factory3));
		assertEquals(false,factory3.equals(factory4));
	}
	
	/**
	 * Use setMoneyFactory to change type of MoneyFactory
	 * and test createMoney with double .
	 */
	@Test
	public void testSetMoneyFactoryAndCreateMoney() {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		 MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(100);
		assertEquals(100,m.getValue(),TOL);
		assertEquals("Baht",m.getCurrency());
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		MoneyFactory factory2 = MoneyFactory.getInstance();
		Valuable m2 = factory2.createMoney(100);
		assertEquals(100,m2.getValue(),TOL);
		assertEquals("Ringgit",m2.getCurrency());
		
	}
	
	/**
	 *  Test createMoney with double ;
	 */
	@Test
	public void testCreateMoneyWithString() {
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney("100");
		assertEquals(100,m.getValue(),TOL);
		assertEquals("Ringgit",m.getCurrency());
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		MoneyFactory factory2 = MoneyFactory.getInstance();
		Valuable m2 = factory2.createMoney("100");
		assertEquals(100,m2.getValue(),TOL);
		assertEquals("Baht",m2.getCurrency());
	}

}

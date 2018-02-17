package coinpurse;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test the MoneyFactory with JUnit.
 * @author Charin Tantrakul
 *
 */
public class MoneyFactoryTest {
	private static MoneyFactory factory ;
	private static final double TOL = 1.0E-6;
	
	/**
	 * Use setMoneyFactory to change type of MoneyFactory
	 * and test createMoney with double .
	 */
	@Test
	public void testSetMoneyFactoryAndCreateMoney() {
		factory = MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		Valuable m = factory.createMoney(100);
		assertEquals(100,m.getValue(),TOL);
		assertEquals("Ringgit",m.getCurrency());
		factory = MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		Valuable m2 = factory.createMoney(100);
		assertEquals(100,m2.getValue(),TOL);
		assertEquals("Baht",m2.getCurrency());
		
	}
	
	/**
	 *  Test createMoney with double ;
	 */
	@Test
	public void testCreateMoneyWithString() {
		Valuable m = factory.createMoney("100");
		assertEquals(100,m.getValue(),TOL);
		assertEquals("Baht",m.getCurrency());
		factory = MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		Valuable m2 = factory.createMoney("100");
		assertEquals(100,m2.getValue(),TOL);
		assertEquals("Ringgit",m2.getCurrency());
	}

}

package coinpurse;

import java.util.ResourceBundle;

/**
 * Test MoneyFactory method.
 * @author Charin Tantrakul.
 *
 */
public class MoneyFactoryDemo {
	public static void main (String[] arg) {
	
		MoneyFactory factory2 = MoneyFactory.getInstance();
		Valuable m = factory2.createMoney(100);
		//Valuable m2 = factory2.createMoney(200);
		System.out.println(m.toString());
		//System.out.println(m2.toString());
		m.toString();
		//m2.toString();
		
	}
	
}

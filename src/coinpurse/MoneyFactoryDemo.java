package coinpurse;


/**
 * Test MoneyFactory method.
 * @author Charin Tantrakul.
 *
 */
public class MoneyFactoryDemo {
	public static void main (String[] arg) {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		MoneyFactory factory1 = MoneyFactory.getInstance();
		MoneyFactory factory2 = MoneyFactory.getInstance();
		System.out.println("factory1 = factory2 :"+factory1.equals(factory2));
		
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		MoneyFactory factory3 = MoneyFactory.getInstance();
		System.out.println("factory1 = factory2(False)");
		System.out.println(factory1 == factory3);
		
		System.out.println("\nCheck ThaiMoney");
		Valuable m = factory1.createMoney( 5 );
		System.out.println("Thai money :"+m.toString());
		try{
		Valuable m2 = factory1.createMoney("2000.0");
		System.out.println("Thai money :"+m2.toString());
		}
		catch(IllegalArgumentException e){
			System.out.println("Sorry, That value can't create");
		}
		Valuable m3 = factory1.createMoney("100.0");
		Valuable m4 = factory1.createMoney("500");
		System.out.println("SerialNumber must increase :");
		System.out.println(m3.toString());
		System.out.println(m4.toString()+"\n");
		
		System.out.println("\nCheck MalayMoney");
		Valuable m5 = factory3.createMoney( 2 );
		Valuable m6 = factory3.createMoney( 0.05 );
		Valuable m7 = factory3.createMoney("2");
		System.out.println("Malasia money :"+m6.toString());
		System.out.println("SerialNumber must increase :");
		System.out.println(m5.toString());
		System.out.println(m7.toString());
	}
	
}

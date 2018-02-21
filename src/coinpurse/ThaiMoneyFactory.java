package coinpurse;

/**
 * Type of MoneyFactory that create Thailand('Baht') Coin and BankNote
 * @author Charin Tantrakul
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	private static long nextSerialNumber = 1000000;
	private final String CURRENCY = "Baht";

	/*
	 * Create Thailand money.
	 * @see coinpurse.MoneyFactory#createMoney(double)
	 */
	@Override
	public Valuable createMoney(double value) {
		if(value == 1 || value == 2 || value == 5 || value == 10) {
			return new Coin(value,CURRENCY);
		}
		else if(value == 20|| value == 50 || value == 100 || value == 500 || value == 1000) {
			return new BankNote(value, CURRENCY,nextSerialNumber++);
		} else {
			throw new IllegalArgumentException(value+" is not a valid in ThaiMoneyFactory.Try again");
			
		}
		
	}

}

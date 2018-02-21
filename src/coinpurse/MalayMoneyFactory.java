package coinpurse;

/**
 * Type of MoneyFactory that create Malaysia(Ringgit) Coin and BankNote.
 * @author Charin Tantrakul 
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	
	private static long nextSerialNumber = 1000000;
	private final String CURRENCY = "Ringgit";

	/*
	 * Create Malaysia money.
	 * @see coinpurse.MoneyFactory#createMoney(double)
	 */
	@Override
	public Valuable createMoney(double value) {
		if(value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) {
			return new Coin(value,CURRENCY);
		}
		else if(value == 2|| value == 5 || value == 10 ||value == 20|| value == 50 || value == 100) {
			return new BankNote(value, CURRENCY,nextSerialNumber++);
		} else {
			throw new IllegalArgumentException(value+" is not a valid in MalayMoneyFactory.Try again");
		}
		
	}

}

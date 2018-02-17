package coinpurse;

import java.util.ResourceBundle;

/**
 * MoneyFactory makes other class can create money with out create by 'new Coin()' or 'new BankNote()'
 * @author Charin Tantrakul
 *
 */
public abstract class MoneyFactory {
	private static MoneyFactory instance;
	private double doubleValue ;
	
	/**
	 * Get instance of  MoneyFactory.
	 * @return MoneyFactory that's singleton.
	 */
	public static MoneyFactory getInstance() {
		return instance;
	}
	
	/**
	 * Create Coin or BankNote by receive value(Double). 
	 * @param value that you want. 
	 * @return Valuable that value of Valuable = value that you put.
	 */
	public abstract Valuable createMoney(double value);
	
	
	/**
	 * Create Coin or BankNote by receive value(String).
	 * If you put string that's not a number .It will throw IllegalArgumentException.
	 * @param value is String that you want to create Money.
	 * @return Valuable that value of Valuable = value that you put.
	 */
	public Valuable createMoney(String value){
		try {
			doubleValue = Double.parseDouble(value);
		}
		catch (NumberFormatException ex){
			throw new IllegalArgumentException();
		}
		return createMoney(Double.parseDouble(value));
	}
	
	/**
	 * Set type of MoneyFactory like ThaiMoneyFactory or MalayFactory.
	 * @param mf MoneyFactory that you want.
	 * @return MoneyFactory.
	 */
	public static MoneyFactory setMoneyFactory(MoneyFactory mf) {
		return instance = mf;
	}
}

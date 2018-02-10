package coinpurse;

/**
 * Coin represents coinage (money) with fixed value and currency.
 * @author charin tantrakul
 *
 */
public class Coin extends Money {
	
	/**
     * A coin with given value and currency.
     * @param value of coin
     * @param currency of coin
     */
	public Coin(double value, String currency) {
			super(value,currency);
	}
		
	/**
	 * Get information of coin
	 */
	@Override
	public String toString(){
		return String.format("%.2f %s", this.getValue(),this.getCurrency());
	}

}

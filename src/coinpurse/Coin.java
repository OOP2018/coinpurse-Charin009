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
		if(this.getCurrency().equals("Ringgit")){
			double ringgitCoin = this.getValue() * 100;
			return String.format("%.2f Sen Coin", ringgitCoin);
		}
		return String.format("%.2f %s Coin", this.getValue(),this.getCurrency());
	}

}

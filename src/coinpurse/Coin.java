package coinpurse;

/**
 * Coin represents coinage (money) with fixed value and currency.
 * @author charin tantrakul
 *
 */
public class Coin implements Valuable {
	
	private double value;
	private String currency;
	
	 /**
     * A coin with given value and currency.
     * @param value of coin
     * @param currency of coin
     */
	public Coin(double value, String currency) {
		if(value >= 0) {
		this.value = value;
		this.currency = currency;
		}
	}
	
	/**
	 * Get value of coin
	 * @return value of coin
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Get currency of coin
	 * @return currency of coin
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Check two coins have the same value and currency or not
	 * @param arg is other coin that you want to compare
	 * @return true if two coins have same value and currency, false if it's not.
	 */
	public boolean equals(Object arg) {
		if(arg == null) return false;
		if(arg.getClass() != this.getClass()) return false;
		Coin other_coin = (Coin) arg;
		if(value == other_coin.value && currency.equalsIgnoreCase(other_coin.currency)) return true;
		return false;
	}
	
	/**
	 * Get information of coin
	 */
	@Override
	public String toString(){
		return String.format("%.2f %s", this.value,this.currency);
	}

}

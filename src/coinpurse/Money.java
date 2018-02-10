package coinpurse;
/**
 * Money represents one type of Valuable with fixed value and currency.
 * @author Charin Tantrakul
 *
 */
public class Money implements Valuable {

	protected double value;
	protected String currency;

	/**
	 * Create Money with value and currency
	 * @param value of money.
	 * @param currency of money.
	 */
	public Money(double value, String currency) {
		if (value >= 0) {
			this.value = value;
			this.currency = currency;
		}
	}
	
	/**
	 * Compare with  other Valuable which one have more value than other.
	 * If both of them have same currency sort by alphabetical 
	 * @param o is other Valuable.
	 * @return positive int if this greater than other. negative int if this less than other and 0 if equal.
	 */
	public int compareTo(Valuable o) {
		if(this.getCurrency().equals(o.getCurrency())) {
			return Double.compare(this.getValue(), o.getValue());
		}
		return this.getCurrency().compareTo(o.getCurrency()) ;
	}

	/**
	 * Check Money and other Object have the same class, value and currency or not.
	 * @param obj is other object.
	 * @return true if both of them have same class ,value ,and currency. false if it's not.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Money other = (Money) obj;
		 
		return this.getValue() == other.getValue() && this.getCurrency().equalsIgnoreCase(other.getCurrency());
		
	}

	/**
	 * Get value of coin
	 * 
	 * @return value of coin
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get currency of coin
	 * 
	 * @return currency of coin
	 */
	public String getCurrency() {
		return this.currency;
	}

}
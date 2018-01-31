package coinpurse;

/**
 * BankNote represents one type of money with fixed value and currency but have a unique serial number.
 * @author Charin Tantrakul.
 *
 */
public class BankNote implements Valuable {

	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;
	
	/**
	 * new BankNote by given value currency and serial number.
	 * @param value is value of BankNote object.
	 * @param currency is currency of BankNote object.
	 */
	public BankNote(double value, String currency) {
		if (value >= 0) {
			this.value = value;
			this.currency = currency;
			this.serialNumber = nextSerialNumber++;
		}
	}

	/**
	 * Get value of BankNote.
	 * @return value of BankNote.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get currency of BankNote.
	 * @return currency of BankNote.
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Get serial number of BankNote.
	 * @return serial number of BankNote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * Check two BankNote have the same value and currency or not.
	 * @param arg is other BankNote that you want to check.
	 * @return true if two BankNote have same value and currency, false if it's not.
	 */
	public boolean equals(Object arg) {
		if(arg == null) return false;
		if(arg.getClass() != this.getClass()) return false;
		BankNote other_note = (BankNote) arg;
		if(value == other_note.value && currency.equalsIgnoreCase(other_note.currency)) return true;
		return false;
	}
	
	/**
	 * Get information of BankNote.
	 * @return information of BankNote.
	 */
	@Override
	public String toString() {
		return String.format("%.2f-%s note " + "[" + this.serialNumber+ "]", this.value, this.currency);
	}

}

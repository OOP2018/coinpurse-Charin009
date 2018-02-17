package coinpurse;

/**
 * BankNote represents one type of money with fixed value and currency but have a unique serial number.
 * @author Charin Tantrakul.
 *
 */
public class BankNote extends Money {

	private long serialNumber;
	
	/**
	 * new BankNote by given value currency and serial number.
	 * @param value is value of BankNote object.
	 * @param currency is currency of BankNote object.
	 * @param nextSerialNumber is SerialNumber of BankNote object.
	 */
	public BankNote(double value, String currency,long nextSerialNumber) {
			super(value, currency);
			this.serialNumber = nextSerialNumber;
	}

	/**
	 * Get serial number of BankNote.
	 * @return serial number of BankNote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * Get information of BankNote.
	 * @return information of BankNote.
	 */
	@Override
	public String toString() {
		return String.format("%.2f-%s note " + "[" + this.getSerial()+ "]", this.getValue(), this.getCurrency());
	}

}

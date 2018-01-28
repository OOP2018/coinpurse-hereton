package coinpurse;

/**
 * Bank note represents bank note with fixes value, currency and it's serial
 * number.
 * 
 * @author ton
 *
 */
public class BankNote implements Valuable {
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;

	/**
	 * Get bank note and currency with start serial number = 1000000 and plus one
	 * after on.
	 * 
	 * @param value
	 *            input value.
	 * @param currency
	 *            input currency
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		System.out.println(nextSerialNumber);
		this.serialNumber = nextSerialNumber;
		nextSerialNumber += 1;
	}

	/**
	 * Get value of bank note.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Get currency of bank note.
	 */
	@Override
	public String getCurrency() {

		return this.currency;
	}

	/**
	 * Get serial number of bank note.
	 * 
	 * @return
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * Check if input Object is equal this bank note or not.
	 * 
	 * @return true if it's yes, false otherwise.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		BankNote other = (BankNote) obj;
		return this.value == other.value && this.currency.equalsIgnoreCase(other.currency);
	}

	/**
	 * Example "20-Bath note 1000000", "100-Dollar note 1000001"
	 */
	public String toString() {
		return String.format("%f-%s note [%d]", this.value, this.currency, this.serialNumber);
	}

}

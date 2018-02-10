package coinpurse;

/**
 * Bank note represents bank note with fixes value, currency and it's serial
 * number.
 * 
 * @author ton
 *
 */
public class BankNote extends Money {
	private static long nextSerialNumber = 1000000;
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
		super(value,currency);
		this.serialNumber = nextSerialNumber;
		nextSerialNumber += 1;
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
	 * Example "20-Bath note 1000000", "100-Dollar note 1000001"
	 */
	public String toString() {
		return String.format("%f-%s note [%d]", this.getValue(), this.getCurrency(), this.serialNumber);
	}

}

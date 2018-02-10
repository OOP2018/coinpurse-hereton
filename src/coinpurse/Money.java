package coinpurse;

/**
 * A money class to eliminate duplicate code from bank-note and coin class.
 * 
 * @author ton
 *
 */
public class Money implements Valuable {

	protected double value;
	protected String currency;

	/**
	 * Create a value and currency for bank-note and coin.
	 * 
	 * @param value
	 *            input value.
	 * @param currency
	 *            input currency.
	 */
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get value of bank-note and coin.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Get currency of bank-note and coin.
	 */
	@Override
	public String getCurrency() {

		return this.currency;
	}

	/**
	 * Check whether another object is equals to this object or not.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return this.getValue() == other.getValue() && this.getCurrency().equalsIgnoreCase(other.getCurrency());
	}
	
	/**
	 * Compare two objects that implement Valuable. First compare them by currency,
	 * so that "Baht" < "Dollar". If both objects have the same currency, order them
	 * by value.
	 */
	@Override
	public int compareTo(Valuable o) {
		if (!this.getCurrency().equalsIgnoreCase(o.getCurrency()))
			return this.getCurrency().compareToIgnoreCase(o.getCurrency());
		return (int) Math.signum(Double.compare(o.getValue(), this.getValue()));
	}

}
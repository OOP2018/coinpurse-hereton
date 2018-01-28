package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 */
public interface Valuable {

	/**
	 * Get the monetary value of this object, in its own currency.
	 * 
	 * @return the value of this object
	 */
	public double getValue();

	/**
	 * Get currency of this object.
	 * 
	 * @return currency of this object.
	 */
	public String getCurrency();

}

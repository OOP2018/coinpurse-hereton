package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author hereton
 */
public class Coin extends Money {

	/**
	 * Get coin and currency of input data.
	 * 
	 * @param value
	 *            input value.
	 * @param currency
	 *            input currency.
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	/**
	 * compare coins with input coin.
	 * 
	 * @return -1 if this coin is lower than input coin. 0 if both are equal. 1 if
	 *         this coin is greater than input coin.
	 */
	public int compareTo(Coin coin) {
		return (int) Math.signum(coin.value - this.value);
	}

	/**
	 * Example "0.25-Satang.","5-Baht.","50-Dollar."
	 */
	public String toString() {
		if (this.currency.equalsIgnoreCase("baht")) {
			if (this.value < 1.0)
				return this.getValue() + "-Satang.";
		}
		if (this.currency.equalsIgnoreCase("ringgit")) {
			if (this.value < 1.0)
				return this.getValue() + "-Sen.";
		}
		return this.getValue() + "-" + this.getCurrency() + ".";
	}

}

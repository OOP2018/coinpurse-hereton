package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author hereton
 */
public class Coin implements Comparable<Coin>, Valuable {
	private double value;
	private String currency;

	/**
	 * Get coin and currency of input data.
	 * 
	 * @param value
	 *            input value.
	 * @param currency
	 *            input currency.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get coin value.
	 * 
	 * @return coin value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get coin currency.
	 * 
	 * @return coin currency.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Check if input Object is equal this Coin or not.
	 * 
	 * @return true if yes. false otherwise.
	 */
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Coin other = (Coin) o;
		if (this.value == other.value && this.currency.equalsIgnoreCase(other.currency))
			return true;
		return false;
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
	 * Example "5-Bath.","50-Dollar."
	 */
	public String toString() {
		return this.value + "-" + this.currency + ".";
	}

	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<>();
		coins.add(new Coin(1, "Bath"));
		coins.add(new Coin(0.5, "Bath"));
		coins.add(new Coin(100, "Bath"));

		List<Coin> c2 = new ArrayList<>();
		c2.add(new Coin(100, "Bath"));

		for (Coin coin : coins) {
			System.out.println(coin.toString());
		}
		Collections.sort(coins);
		for (Coin coin : coins) {
			System.out.println(coin.toString());
		}
	}
}

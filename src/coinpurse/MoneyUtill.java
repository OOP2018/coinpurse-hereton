package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility that use for filterByCurrency and coins sorted.
 * @author ton
 *
 */
public class MoneyUtill {
	/**
	 * Get list of coins that contains input currency.
	 * @param coins input list of coins.
	 * @param currency that want to filter.
	 * @return coins with input currency.
	 */
	static List<Valuable> filterByCurrency(List<Valuable> values, String currency) {
		List<Valuable> sameCurrency = new ArrayList<>();
		for (Valuable value : values) {
			if (value.getCurrency().equalsIgnoreCase(currency))
				sameCurrency.add(value);
		}
		return sameCurrency;
	}

	/**
	 * Sorted from small value to bigger value.
	 * @param coins list of coins.
	 */
	static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
		toString(coins);
	}

	/*
	 * Description about the coin
	 */
	static public void toString(List<Coin> coins) {
		for (Coin coin : coins)
			System.out.println(coin.toString());
	}

}

package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// You will use Collections.sort() to sort the coins

/**
 * A purse contains money. You can insert money, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author hereton
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money;

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of value you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<>(this.capacity);
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins or bank notes, not their value.
	 * 
	 * @return the number of value in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for (Valuable value : money) {
			balance += value.getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in purse
	 * equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return money.size() >= getCapacity();
	}

	/**
	 * Insert a valuable (Coin, bank note,etc.) into the purse. The value is only
	 * inserted if the purse has space for it and have positive value. No
	 * fake values!
	 * 
	 * @param value
	 *            is a value object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		/**
		 * Compare two objects that implement Valuable. First compare them by currency,
		 * so that "Baht" < "Dollar". If both objects have the same currency, order them
		 * by value.
		 */
		Comparator<Valuable> comp = new Comparator<Valuable>() {
			@Override
			public int compare(Valuable o1, Valuable o2) {
				if (o1.getCurrency().equalsIgnoreCase("bath")) {
					if (o2.getCurrency().equalsIgnoreCase("dollar"))
						return -1;
				}
				if (o1.getCurrency().equalsIgnoreCase("dollar")) {
					if (o2.getCurrency().equalsIgnoreCase("bath"))
						return 1;
				}
				// sort big to small
				return (int) Math.signum(o2.getValue() - o1.getValue());
			}

		};
		// if the purse is already full then can't insert anything.
		if (isFull() || value.getValue() <= 0)
			return false;
		money.add(value);
		// Sorted most value come first.
		Collections.sort(money, comp);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of value withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of value objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		List<Valuable> temp = new ArrayList<>(getCapacity());
		if (amount < 0) {
			return null;
		}
		for (Valuable value : money) {
			if (value.getValue() <= amount) {
				amount -= value.getValue();
				temp.add(value);
			}
		}
		if (amount == 0) {
			for (Valuable item : temp) {
				money.remove(item);
			}
			Valuable[] withDarw = new Valuable[temp.size()];
			withDarw = temp.toArray(withDarw);
			return withDarw;
		}
		return null;
	}

	/**
	 * toString returns a string description of the purse contents. It can return
	 * whatever is a useful description.
	 */
	public String toString() {
		return String.format("%d coins with %.2f values", this.count(), this.getBalance());
	}

}

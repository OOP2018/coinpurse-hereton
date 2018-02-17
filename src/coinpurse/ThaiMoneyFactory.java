package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThaiMoneyFactory extends MoneyFactory {
	private long nextSerialNumber = 1000001;
	private final String CURRENCY = "Baht";
	private List<Double> thaiBaht = new ArrayList<>(
			Arrays.asList(0.01, 0.05, 0.10, 0.25, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 500.0, 1000.0));

	@Override
	public Valuable createMoney(double value) {
		if (!thaiBaht.contains(value)) {
			throw new IllegalArgumentException();
		}
		if (value < 20.0)
			return new Coin(value, CURRENCY);
		return new BankNote(value, CURRENCY, nextSerialNumber++);
	}

	public static void main(String[] args) {
		MoneyFactory factory = MoneyFactory.getInstace();
		Valuable m = factory.createMoney(0.25);
		Valuable n = factory.createMoney(100);
		System.out.println(m);
		System.out.println(n);
	}
}

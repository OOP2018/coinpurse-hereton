package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MalayMoneyFactory extends MoneyFactory {
	private long nextSerialNumber = 1000001;
	private final String CURRENCY = "Ringgit";
	private List<Double> malayRinggit = new ArrayList<>(
			Arrays.asList(0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0));

	@Override
	public Valuable createMoney(double value) {
		if (!malayRinggit.contains(value)) {
			System.out.println("Value must be " + malayRinggit +"\n\n");
			throw new IllegalArgumentException();
		}
		if (value < 1.0)
			return new Coin(value, CURRENCY);
		return new BankNote(value, CURRENCY, nextSerialNumber++);
	}

	public static void main(String[] args) {
		MoneyFactory factory = MoneyFactory.getInstace();
		Valuable m = factory.createMoney(1000);
		System.out.println(m);
		System.out.println(m.getCurrency());
	}

}

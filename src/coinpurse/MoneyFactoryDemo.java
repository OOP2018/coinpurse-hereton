package coinpurse;

public class MoneyFactoryDemo {
	public static void main(String[] args) {
		MoneyFactory factory1 = MoneyFactory.getInstace();
		MoneyFactory factory2 = MoneyFactory.getInstace();
		System.out.println("MoneyFactory is a singleton.");
		System.out
				.println("factory1 is the same object to factory2: " + factory1.getClass().equals(factory2.getClass()));
		Valuable b1 = factory1.createMoney(5);
		System.out.println(b1);
		System.out.println("create coin 1");
		Valuable c1 = factory2.createMoney(0.1);
		System.out.println("created coin 1 : " + c1);
		System.out.println("currency of coin 1 : " + c1.getCurrency());
		System.out.println("Create valuable with string");
		Valuable b2 = factory1.createMoney("50");
		System.out.println(b2);
		factory2.createMoney("fake banknote");

	}
}

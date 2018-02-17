package coinpurse;

/**
 * Create a factory in each local factory.
 * 
 * @author ton
 *
 */
public abstract class MoneyFactory {
	private static MoneyFactory factory;

	/**
	 * get an instance of MoneyFactory. This method returns an object of a subclass
	 * 
	 * @return local factory.
	 */
	public static MoneyFactory getInstace() {
		if (factory == null)
			// default is thai factory
			factory = new ThaiMoneyFactory();
		return factory;
	}

	public static void setMoneyFactory(MoneyFactory factory) {
		MoneyFactory.factory = factory;
	}

	/**
	 * 
	 * create new money object in the local currency.
	 * 
	 * @param value
	 *            input value
	 * @return Valuable (input value with local currency).
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * accepts money value as a String, e.g. createMoney("10"). This method is for
	 * convenience of the U.I.
	 * 
	 * @param value
	 *            input value.
	 * @return Valuable (input value with local currency).
	 */
	public Valuable createMoney(String value) {
		if (!value.matches("[0-9]+"))
			throw new IllegalArgumentException("input must be digits.");
		return createMoney(Double.parseDouble(value));
	}
	
	
	
	
}

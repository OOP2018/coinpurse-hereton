package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author your name
 */
public class Main {
	private static MoneyFactory instance = null;

	/**
	 * Read file property to set local money factory.
	 */
	public static void init() {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("purse");
			String factoryClass = bundle.getString("moneyfactory");
			instance = (MoneyFactory) Class.forName(factoryClass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(instance + " is not type MoneyFactory");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		init();
		MoneyFactory.setMoneyFactory(instance);
		Purse p = new Purse(10);
		ConsoleDialog cd = new ConsoleDialog(p);
		cd.run();
	}
}

package coinpurse;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MoneyFactoryTest {

	private MoneyFactory factory = MoneyFactory.getInstace();

	/**
	 * Sets up the test fixture. Called before every test method.
	 */
	@Before
	public void setUp() {

	}

	/** test Money factory is singleton. */
	@Test
	public void testSigleton() {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());

		factory = MoneyFactory.getInstace();
		MoneyFactory factory2 = MoneyFactory.getInstace();
		assertTrue(factory.equals(factory2));

		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		MoneyFactory malayFactory = MoneyFactory.getInstace();
		assertFalse(factory.equals(malayFactory));
	}

	@Test
	public void testMakeValueableByDouble() {
		Valuable c1 = factory.createMoney(0.1);
		assertEquals(factory.createMoney(0.1), c1);
		Valuable b1 = factory.createMoney(20);
		assertTrue(factory.createMoney(20).equals(b1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		factory.createMoney(99999);
		factory.createMoney("fakeValueable");
	}

}

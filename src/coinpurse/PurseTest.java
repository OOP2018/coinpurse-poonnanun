package coinpurse;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Purse using JUnit.
 * This is a JUnit 4 test suite.  
 * 
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4,
 * but you have to tell the IDE to add it to your project as a "Library".
 * To run these tests, right click on this file (in Project panel)
 * and choose Run As -> JUnit test
 * 
 * @author  Poonnanun Poonnopathum
 * @version 2018.02.13
 */
public class PurseTest {
    /**
     * tolerance for comparing two double values
     */
    private static final double TOL = 1.0E-6;
    private static final String CURRENCY = "Baht";

    /**
     * Sets up the test fixture.
     * Called before every test method.
     */
    @Before
    public void setUp() {
        // nothing to initialize
    }

    /**
     * Make a coin with the default currency. To save typing "new Coin(...) or new Banknote(...)"
     */
    private Valuable makeMoney(double value) {
        if (value<20) return new Coin(value, CURRENCY);
        else return new BankNote(value,CURRENCY);
    }


    /**
     * Easy test that the Purse constructor is working.
     */
    @Test
    public void testConstructor() {
        Purse purse = new Purse(3);
        assertEquals(3, purse.getCapacity());
        assertEquals(false, purse.isFull());
        assertEquals(0, purse.count());
    }
    /** Test insert of the BankNote.
     * */
    @Test
    public void testInsertBankNote() {
        Purse purse = new Purse(6);
        BankNote bank1 = (BankNote) makeMoney(150);
        BankNote bank2 = (BankNote) makeMoney(100);
        BankNote bank3 = (BankNote) makeMoney(20);
        BankNote bank4 = (BankNote) makeMoney(50);
        BankNote bank5 = (BankNote) makeMoney(20);
        BankNote bank6 = (BankNote) makeMoney(50);
        assertTrue(purse.insert(bank1));
        assertTrue(purse.insert(bank3));
        assertTrue(purse.insert(bank2));
        assertTrue(purse.insert(bank4));
        assertTrue(purse.insert(bank5));
        assertTrue(purse.insert(bank6));
        assertEquals(6, purse.count());
        assertFalse(purse.insert(makeMoney(450)));
        assertFalse(purse.insert(makeMoney(160)));
        assertEquals(390, purse.getBalance(), TOL);

    }

    /**
     * Test equals of banknote.
     */
    @Test
    public void testEqualsBankNote(){
        Purse purse = new Purse(6);
        BankNote bank1 = (BankNote) makeMoney(150);
        BankNote bank2 = (BankNote) makeMoney(100);
        BankNote bank3 = (BankNote) makeMoney(20);
        BankNote bank4 = (BankNote) makeMoney(50);
        BankNote bank5 = (BankNote) makeMoney(20);
        BankNote bank6 = (BankNote) makeMoney(50);
        assertTrue(purse.insert(bank1));
        assertTrue(purse.insert(bank3));
        assertTrue(purse.insert(bank2));
        assertTrue(purse.insert(bank4));
        assertTrue(purse.insert(bank5));
        assertTrue(purse.insert(bank6));
        assertFalse(bank4.equals(bank1));
        assertFalse(bank2.equals(bank6));
        assertTrue(bank4.equals(bank6));
    }

    /**
     * Test withdraw in banknote.
     */
    @Test
    public void testWithdrawBankNote(){
        Purse purse = new Purse(6);
        BankNote bank1 = (BankNote) makeMoney(150);
        BankNote bank2 = (BankNote) makeMoney(100);
        BankNote bank3 = (BankNote) makeMoney(20);
        BankNote bank4 = (BankNote) makeMoney(50);
        BankNote bank5 = (BankNote) makeMoney(20);
        BankNote bank6 = (BankNote) makeMoney(50);
        assertTrue(purse.insert(bank1));
        assertTrue(purse.insert(bank3));
        assertTrue(purse.insert(bank2));
        assertTrue(purse.insert(bank4));
        assertTrue(purse.insert(bank5));
        assertTrue(purse.insert(bank6));
        purse.withdraw(100);
        assertEquals(290, purse.getBalance(), TOL);
        purse.withdraw(50);
        assertEquals(240, purse.getBalance(), TOL);
    }

    /**
     * Insert some coins. Easy test.
     */
    @Test
    public void testInsert() {
        Purse purse = new Purse(6);
        Valuable coin1 = makeMoney(5);
        Valuable coin2 = makeMoney(60);
        Valuable coin3 = makeMoney(1);
        Valuable bank1 = makeMoney(55);
        Valuable bank2 = makeMoney(60);
        Valuable bank3 = makeMoney(100);
        assertTrue(purse.insert(bank1));
        assertTrue(purse.insert(bank2));
        assertTrue(purse.insert(bank3));
        assertTrue(purse.insert(coin1));
        assertTrue(purse.insert(coin3));
        assertTrue(purse.insert(coin2));
        assertEquals(6, purse.count());
        // purse is full so insert should fail
        assertFalse(purse.insert(makeMoney(1)));
    }


    /**
     * Insert should reject coin with no value.
     */
    @Test
    public void testInsertNoValue() {
        Purse purse = new Purse(3);
        Valuable fakeCoin = new Coin(0, CURRENCY);
        assertFalse(purse.insert(fakeCoin));
    }


    @Test(timeout = 1000)
    public void testIsFull() {   // borderline case (capacity 1)
        Purse purse = new Purse(1);
        assertFalse(purse.isFull());
        purse.insert(makeMoney(1));
        assertTrue(purse.isFull());
        // real test
        int capacity = 4;
        purse = new Purse(capacity);
        for (int k = 1; k <= capacity; k++) {
            assertFalse(purse.isFull());
            purse.insert(makeMoney(k));
        }
        // should be full now
        assertTrue(purse.isFull());
        assertFalse(purse.insert(makeMoney(5)));
    }

    /**
     * Should be able to insert same coin many times,
     * since spec doesn't say anything about this.
     */
    @Test(timeout = 1000)
    public void testInsertSameCoin() {
        int capacity = 5;
        double value = 10.0;
        Purse purse = new Purse(capacity);
        Valuable valuable = new Coin(value, "THB");
        assertTrue(purse.insert(valuable));
        assertTrue(purse.insert(valuable)); // should be allowed
        assertTrue(purse.insert(valuable)); // should be allowed
        assertTrue(purse.insert(valuable)); // should be allowed
        assertTrue(purse.insert(valuable)); // should be allowed
        assertEquals(purse.getBalance(), 5 * value, TOL);
    }

    /**
     * Add one coin and remove it.
     */
    @Test(timeout = 1000)
    public void testEasyWithdraw() {
        Purse purse = new Purse(10);
        double[] values = {1, 20, 0.5, 10}; // values of coins we will insert

        for (double value : values) {
            Valuable valuable;
            if (value < 20) {
                valuable = makeMoney(value);
            } else {
                valuable = makeMoney(value);
            }
            assertTrue(purse.insert(valuable));
            assertEquals(value, purse.getBalance(), TOL);
            Valuable[] result = purse.withdraw(value);
            assertTrue(result != null);
            assertEquals(1, result.length);
            assertSame(valuable, result[0]); // should be same object
            assertEquals(0, purse.getBalance(), TOL);
        }
    }


    /**
     * Add 4 coins and then withdraw in pairs, but not in same order.
     */
    @Test(timeout = 1000)
    public void testMultiWithdraw() {
        Purse purse = new Purse(10);
        Valuable[] coins = {makeMoney(5.0), makeMoney(20.0), makeMoney(1.0), makeMoney(5.0)};
        // insert them all
        for (Valuable coin : coins) assertTrue(purse.insert(coin));

        double amount1 = coins[1].getValue() + coins[3].getValue();
        double amount2 = coins[0].getValue() + coins[2].getValue();
        assertEquals(amount1 + amount2, purse.getBalance(), TOL);

        Valuable[] wd1 = purse.withdraw(amount1);
        assertEquals(amount1, sum(wd1), TOL);

        assertEquals(amount2, purse.getBalance(), TOL);
        Valuable[] wd2 = purse.withdraw(amount2);

        // should be empty now
        assertEquals(0, purse.getBalance(), TOL);
    }


    /**
     * Withdraw full amount in purse, using varying numbers of objects.
     */
    @Test(timeout = 1000)
    public void testWithdrawEverything() {
        Purse purse = new Purse(10);
        // Coins we want to insert and then withdraw.
        // Use values such that greedy will succeed, but not monotonic
        List<Valuable> coins = Arrays.asList(
                makeMoney(1.0), makeMoney(0.5), makeMoney(10.0), makeMoney(0.25), makeMoney(5.0)
        );
        // num = number of coins to insert and then withdraw
        for (int num = 1; num <= coins.size(); num++) {
            double amount = 0.0;
            List<Valuable> subList = coins.subList(0, num);
            for (Valuable c : subList) {
                purse.insert(c);
                amount += c.getValue();
            }
            // balance should be exactly what we just inserted
            assertEquals(amount, purse.getBalance(), TOL);
            // can we withdraw it all?
            Valuable[] result = purse.withdraw(amount);
            String errmsg = String.format("couldn't withdraw %.2f but purse has %s",
                    amount, Arrays.toString(subList.toArray()));
            assertNotNull(errmsg, result);
            // is the amount correct?
            assertEquals("Withdraw wrong amount", amount, sum(result), TOL);
            // should not be anything left in the purse
            assertEquals(0.0, purse.getBalance(), TOL);
        }
    }


    @Test(timeout = 1000)
    public void testImpossibleWithdraw() {
        Purse purse = new Purse(10);
        assertNull(purse.withdraw(1));
        purse.insert(makeMoney(20));
        assertNull(purse.withdraw(1));
        assertNull(purse.withdraw(19));
        assertNull(purse.withdraw(21));
        purse.insert(makeMoney(20)); // now it has 20 + 20
        assertNull(purse.withdraw(30));
    }

    /**
     * Sum the value of some coins.
     *
     * @param coins array of coins
     * @return sum of values of the coins
     */
    private double sum(Valuable[] coins) {
        if (coins == null) return 0.0;
        double sum = 0;
        for (Valuable c : coins) if (c != null) sum += c.getValue();
        return sum;
    }
}

package strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.Purse;
import coinpurse.Valuable;

public class WithdrawTest {

	private List<Valuable> money;
	private WithdrawStrategy strategy;
	private Purse purse;
	private static final String CURRENCY = "Baht";
	
	@Before
	public void setUp(){
		money= new ArrayList<>();
		
	}
	
	private Valuable makeMoney(double value) {
        if (value<20) return new Coin(value, CURRENCY);
        else return new BankNote(value,CURRENCY);
    }
	
	/**
	 * Test if greedyWithdraw work. that is withdraw all eventhough it doesn't have money in purse
	 */
	@Test
	public void testGreedyWithdraw(){
		strategy = new GreedyWithdrawStrategy();
		// amount to withdraw
		Valuable amount = new Money(100,"Baht");
		// money that have in purse
		money.add(new Coin(10,"Baht"));
		money.add(new Money(20,"Baht"));
		money.add(new Money(100,"Baht"));
		List<Valuable> test = strategy.withdraw(amount, money);
		double quan = 0;
		for(int a = 0; a<test.size() ; a++){
			quan += test.get(a).getValue();
		}
		// greedy must withdraw every amount that ask to withdraw.
		assertEquals(100,quan,100.0);
	}
	
	/**
	 * Test if can withdraw amount that more than money in purse
	 * should be nullPointerException because it haven't add anything in purse.
	 */
	@Test(expected = NullPointerException.class)
	public void testWithdrawOverBudget(){
		purse = new Purse(10);
		Valuable[] add = { makeMoney(10), makeMoney(5) };
		for(int a = 0; a<add.length; a++)	purse.insert(add[a]);
		Valuable[] test = purse.withdraw( makeMoney(20));
		double real = 0;
		for(int b = 0; b<test.length; b++)	real += test[b].getValue();
		assertEquals(0,real,0.0);
	}
	
	/**
	 * Test if can withdraw any baht if purse both Ringgit and Baht but in put baht have lower amount than the withdraw.
	 * should be nullPointerException because it haven't add anything in purse.
	 */
	@Test(expected = NullPointerException.class)
	public void testWithdrawDifferentCurrency(){
		purse = new Purse(10);
		Valuable[] add = { new Money(10, "Baht"), new Money(10, "Ringgit") };
		for(int a = 0; a<add.length; a++)	purse.insert(add[a]);
		Valuable[] test = purse.withdraw( new Money(20, "Baht"));
		double real = 0;
		for(int b = 0; b<test.length; b++)	real += test[b].getValue();
		assertEquals(0,real,0.0);
	}
	
	/**
	 * Test if program can withdraw all of the money in purse
	 * should return same amount of money 
	 */
	@Test
	public void testWithdrawAll(){
		purse = new Purse(10);
		Valuable[] add = { makeMoney(10), makeMoney(5) };
		for(int a = 0; a<add.length; a++)	purse.insert(add[a]);
		Valuable[] test = purse.withdraw( 15 );
		double real = 0;
		for(int b = 0; b<test.length; b++)	real += test[b].getValue();
		assertEquals(15,real,15.0);
	}
	
	/**
	 * Test if program can withdraw amount that lower than money in purse
	 * should return nullPointerException because it won't add anything
	 */
	@Test(expected = NullPointerException.class)
	public void testWithdrawWrongMoney(){
		purse = new Purse(10);
		Valuable[] add = { makeMoney(10), makeMoney(5) };
		for(int a = 0; a<add.length; a++)	purse.insert(add[a]);
		Valuable[] test = purse.withdraw( 2 );
		double real = 0;
		for(int b = 0; b<test.length; b++)	real += test[b].getValue();
		assertEquals(0,real,0.0);
	}
	
	/**
	 * Test if NeverWithdrawStrategy work
	 * should get 0 because this strategy won't withdraw anything.
	 */
	@Test
	public void testNeverWithdrawStrategy(){
		strategy = new NeverWithdrawStrategy();
		// amount to withdraw
		Valuable amount = new Money(100,"Baht");
		// money that have in purse
		money.add(new Coin(10,"Baht"));
		money.add(new Money(20,"Baht"));
		money.add(new Money(100,"Baht"));
		List<Valuable> test = strategy.withdraw(amount, money);
		double quan = 0;
		for(int a = 0; a<test.size() ; a++){
			quan += test.get(a).getValue();
		}
		// this mustn't withdraw any amount that ask to withdraw.
		assertEquals(0,quan,0.0);
	}
	
	/**
	 * Test if recusive withdraw work
	 * should get same amount if the amount is legal to withdraw.
	 */
	@Test
	public void testRecusiveWithdrawStrategy(){
		strategy = new RecusiveWithdrawStrategy();
		// amount to withdraw
		Valuable amount = new Money(100,"Baht");
		// money that have in purse
		money.add(new Coin(10,"Baht"));
		money.add(new Money(20,"Baht"));
		money.add(new Money(100,"Baht"));
		List<Valuable> test = strategy.withdraw(amount, money);
		double quan = 0;
		for(int a = 0; a<test.size() ; a++){
			quan += test.get(a).getValue();
		}
		// greedy must withdraw every amount that ask to withdraw.
		assertEquals(100,quan,100.0);
	}
	
	/**
	 * Test if recusive eork correctly
	 * should return null pointer exception
	 */
	@Test(expected = NullPointerException.class)
	public void testCannotWithdrawInRecusive(){
		strategy = new RecusiveWithdrawStrategy();
		// amount to withdraw
		Valuable amount = new Money(100,"Baht");
		// money that have in purse
		money.add(new Coin(10,"Baht"));
		money.add(new Money(20,"Baht"));
		money.add(new Money(20,"Baht"));
		List<Valuable> test = strategy.withdraw(amount, money);
		double quan = 0;
		for(int a = 0; a<test.size() ; a++){
			quan += test.get(a).getValue();
		}
		// greedy must withdraw every amount that ask to withdraw.
		assertEquals(0,quan,0.0);
	}
	
	/**
	 * Test case withdraw diffrent currency in recusive
	 */
	@Test(expected = NullPointerException.class)
	public void testWrongCurrencyRecusive(){
		strategy = new RecusiveWithdrawStrategy();
		// amount to withdraw
		Valuable amount = new Money(100,"Baht");
		// money that have in purse
		money.add(new Coin(10,"Baht"));
		money.add(new Money(20,"Baht"));
		money.add(new Money(20,"Baht"));
		money.add(new Money(50,"Yen"));
		
		List<Valuable> test = strategy.withdraw(amount, money);
		double quan = 0;
		for(int a = 0; a<test.size() ; a++){
			quan += test.get(a).getValue();
		}
		// greedy must withdraw every amount that ask to withdraw.
		assertEquals(0,quan,0.0);
	}
	
}

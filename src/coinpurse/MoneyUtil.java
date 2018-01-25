package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {

	public static void main(String[] args){
		List<Coin> coins = new ArrayList<>();
		coins.add(new Coin( 10.0, "Baht"));
		coins.add(new Coin( 20.0, "Baht"));
		coins.add(new Coin( 5.0, "Baht"));
		coins.add(new Coin( 1.0, "Baht"));
		coins.add(new Coin( 0.25, "Baht"));
		coins.add(new Coin( 0.50, "Baht"));
		coins.add(new Coin( 3, "Dollar"));
		coins.add(new Coin( 2, "Baht"));
		coins.add(new Coin( 10, "Dollar"));
		printCoins(coins);
		sortCoins(coins);
		printCoins(coins);
		
		List<Coin> filter = filterByCurrency(coins, "Dollar");
		System.out.println("filter "+filter);
	}
	
	/**
	 * Fucking stupid code
	 */
	public static void sortCoins(List coin){
		java.util.Collections.sort(coin);
	}
	
	/**
	 * 
	 */
	public static void printCoins(List<Coin> coin){
		System.out.println(coin);
	}
	
	/**
	 * 
	 */
	public static List<Coin> filterByCurrency(List<Coin> coin, String currency){
		List<Coin> sorted = new ArrayList<>();
		for(Coin d: coin){
			if(d.getCurrency().toLowerCase().equals(currency.toLowerCase())){
				sorted.add(d);
			}
		}
		return sorted;
	}
}

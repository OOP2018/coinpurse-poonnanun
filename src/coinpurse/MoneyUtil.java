package coinpurse;
/**
 * Class that test coin
 * @author Poonanun Poonnoapthum
 */
import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {
/**
 * initializing moneyUtil
 * @param args notuse
 */
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
	 * sort coins form lowest to highest
	 */
	public static void sortCoins(List coin){
		java.util.Collections.sort(coin);
	}
	
	/**
	 * print coins
	 */
	public static void printCoins(List<Coin> coin){
		System.out.println(coin);
	}
	
	/**
	 * filter coin by specific currency
	 * @return list of sorted coin
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

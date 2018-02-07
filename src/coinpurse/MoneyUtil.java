package coinpurse;
/**
 * Class that test coin
 * @author Poonanun Poonnoapthum
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MoneyUtil {
/**
 * initializing moneyUtil
 * @param args notuse
 */
	public static void main(String[] args){
		List<Valuable> valuables = new ArrayList<>();
		valuables.add(new BankNote( 20.0, "Baht"));
		valuables.add(new BankNote( 100.0, "Dollar"));
		valuables.add(new Coin( 10.0, "Baht"));
		valuables.add(new Coin( 20.0, "Baht"));
		valuables.add(new Coin( 5.0, "Baht"));
		valuables.add(new Coin( 1.0, "Baht"));
		valuables.add(new Coin( 0.25, "Baht"));
		valuables.add(new Coin( 0.50, "Baht"));
		valuables.add(new Coin( 3, "Dollar"));
		valuables.add(new Coin( 2, "Baht"));
		valuables.add(new Coin( 10, "Dollar"));
		printValuable(valuables);
		sortValuable(valuables);
		printValuable(valuables);
		
		List<Valuable> filter = filterByCurrency(valuables, "Dollar");
		System.out.println("filter "+filter);
	}
	
	/**
	 * sort valuables form lowest to highest
	 */
	public static void sortValuable(List value){
		Comparator<Valuable> comparator = new ValueComparator();
		java.util.Collections.sort(value, comparator);
	}
	
	/**
	 * print valuables
	 */
	public static void printValuable(List<Valuable> value){
		System.out.println(value);
	}
	
	/**
	 * filter coin by specific currency
	 * @return list of sorted coin
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> value, String currency){
		List<Valuable> sorted = new ArrayList<>();
		for(Valuable d: value){
			if(d.getCurrency().toLowerCase().equals(currency.toLowerCase())){
				sorted.add(d);
			}
		}
		return sorted;
	}
}

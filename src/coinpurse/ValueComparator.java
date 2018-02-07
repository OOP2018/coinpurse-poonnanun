package coinpurse;

import java.util.Comparator;
/**
 * ValueComparator class use for compare object
 * @author Poonnanun Poonnopathum
 */
public class ValueComparator implements Comparator<Valuable>{

	/**
	 * compare 2 Valuable object
	 * @param a valuable that use for compare b
	 * @param b valuable that use for compare a
	 * @return 1 if a is greater than b, -1 if a is lower than b and 0 if both are the same
	 */
	@Override
	public int compare(Valuable a, Valuable b) {
		if(a.getCurrency().equalsIgnoreCase(b.getCurrency())){
			if(a.getValue() < b.getValue()) return -1;
			else if(a.getValue() > b.getValue()) return 1;
			else return 0;
		}
		else{
			return a.getCurrency().compareTo(b.getCurrency());
		}
	}
}

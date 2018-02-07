package coinpurse;
/**
 * Interface for Coin and BankNote that contain getValue and getCurrency abstract method
 * @author Poonnanun Poonnopathum
 */
public interface Valuable extends Comparable<Valuable>{

	/**
	 * get value of object
	 * @return value
	 */
	public double getValue();
	/**
	 * get currency of object
	 * @return currency
	 */
	public String getCurrency();

}

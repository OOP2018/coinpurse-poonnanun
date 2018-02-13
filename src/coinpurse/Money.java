package coinpurse;

/**
 * Class that use for manage coins and banknotes.
 * Contain getValue, getCurrency, compareT0 and equals.
 * @author Poonnanun Poonnopathum
 */
public class Money implements Valuable{
	
	private double value;
	private String currency;
	
	public Money(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	/**
	 * get value of money
	 * @return value of money
	 */
	public double getValue(){
		return value;
	}
	
	/**
	 * get currency of money
	 * @return currency of money
	 */
	public String getCurrency(){
		return currency;
	}
	
	/**
	 * compare 2 money
	 * @return 1 if money a > money b
	 * @return 0 if both equal
	 * @return -1 if money b > money a
	 */
	public int compareTo(Valuable note){
		return Double.compare(this.getValue(), note.getValue());
	}
	
	/**
	 * check if equals or not
	 * @return true if equal
	 * @return false if not equal
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		return this.getCurrency().equals(((Money) obj).getCurrency()) && this.getValue() == ((Money) obj).getValue();
	}
}

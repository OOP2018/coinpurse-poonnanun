package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency
 * @author Poonnanun Poonpathum
 */
public class Coin implements Valuable{

	private double value;
	private String currency;
	
	/**
	 * Create Coin that contain vlaue and currency
	 * @param value of coin
	 * @param currency of coin
	 */
	public Coin(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * get value of coin
	 * @return value of coin
	 */
	public double getValue(){
		return this.value;
	}
	
	/**
	 * get currency of coin
	 * @return currency of coin
	 */
	public String getCurrency(){
		return this.currency;
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
		return this.currency.equals(((Coin) obj).currency) && this.value == ((Coin) obj).value;
	}
	
	/**
	 * compare 2 coin
	 * @return 1 if coin a > coin b
	 * @return 0 if both equal
	 * @return -1 if coin b > coin a
	 */
	public int compareTo(Valuable coin){
		if(this.value < coin.getValue()){
			return -1;
		}
		else if(this.value == coin.getValue()){
			return 0;
		}
		else{
			return 1;
		}
		
	}
	
	/**
	 * Get format of coin
	 * @return String for coin
	 */
	@Override
	public String toString(){
		return value+"-"+currency+" [coin] ";
	}
}

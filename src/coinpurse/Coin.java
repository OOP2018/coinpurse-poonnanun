package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency
 * @author Poonnanun Poonpathum
 */
public class Coin extends Money{

	/**
	 * Create Coin that contain vlaue and currency
	 * @param value of coin
	 * @param currency of coin
	 */
	public Coin(double value, String currency){
		super(value, currency);
	}

	/**
	 * Get format of coin
	 * @return String for coin
	 */
	@Override
	public String toString(){
		double value = this.getValue();
		String currency = this.getCurrency();
		if(this.getCurrency().equals("Ringgit")) {
			currency = "Sen";
			value *= 100;
		}
		return value+"-"+currency+" [coin] ";
	}
}

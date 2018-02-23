package coinpurse;

/**
 * Money factory in thai baht
 * @author Poonannun Poonnopthum
 */
public class ThaiMoneyFactory extends MoneyFactory{
	
	private final String THAI_CURR = "Baht";
	private static long nextSerialNumber = 1000000;
	private final double[] MONEY = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
	
	/**
	 * Create money in baht
	 * @return money in baht
	 */
	@Override
	public Valuable createMoney(double value) {
		boolean check = false;
		for(double d: MONEY){
			if(d == value) check = true;
		}
		if(!check) throw new IllegalArgumentException(String.format("No %.2f %s money", value, THAI_CURR));
		if(value >= 20) return new BankNote(value, THAI_CURR, nextSerialNumber++);
		return new Coin(value, THAI_CURR);
	}
	
	/**
	 * get currenct
	 * @return baht
	 */
	@Override
	public String getCurrency(){
		return THAI_CURR;
	}
}

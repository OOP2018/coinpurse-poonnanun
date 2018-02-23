package coinpurse;
/**
 * Money factory in malay by using Ringgit to create money
 * @author Poonnanun Poonnopathum
 */
public class MalayMoneyFactory extends MoneyFactory{

	private final String MARLAY_CURR = "Ringgit";
	private static long nextSerialNumber = 1000000;
	private final double[] MONEY = {0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100};
	
	/**
	 * Create money in malay
	 * @return money in malay
	 */
	@Override
	public Valuable createMoney(double value) {
		boolean check = false;
		for(double d: MONEY){
			if(d == value) check = true;
		}
		if(!check) throw new IllegalArgumentException(String.format("No %.2f %s money", value, MARLAY_CURR));
		if(value > 1) return new BankNote(value, MARLAY_CURR, nextSerialNumber++);
		return new Coin(value, MARLAY_CURR);
	}
	
	/**
	 * get the malay currency
	 * @return currency = Ringgit
	 */
	@Override
	public String getCurrency(){
		return MARLAY_CURR;
	}
}


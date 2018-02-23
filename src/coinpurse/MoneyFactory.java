package coinpurse;

/**
 * Create money in different country
 * @author Poonnanun Poonnopathum
 */
public abstract class MoneyFactory {

	private static MoneyFactory nowInstance;
	
	/**
	 * get the instance of this factory
	 * @return instance
	 */
	public static MoneyFactory getInstance(){
		if(nowInstance == null) nowInstance = new ThaiMoneyFactory();
		return nowInstance;
	}
	
	/**
	 * Constructor for moneyFactory
	 */
	protected MoneyFactory(){}
	
	/**
	 * create new money
	 * @param value of money
	 * @return money
	 */
	public abstract Valuable createMoney(double value);
	
	/**
	 * get currency
	 * @return currency
	 */
	public abstract String getCurrency();
	
	/**
	 * Create money by using string
	 * @param value in string
	 * @return money
	 */
	public Valuable createMoney(String value){
		double doubleValue = 0;
		try{
			doubleValue = Double.parseDouble(value);
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
			throw new IllegalArgumentException();
		}
		return createMoney(doubleValue);
	}
	
	/**
	 * Change the factory
	 * @param f is any factory
	 */
	public static void setFactory(MoneyFactory f){
		nowInstance = f;
	}

}

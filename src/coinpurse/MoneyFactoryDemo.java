package coinpurse;

/**
 * Class that test any factory if it work
 * @author Poonnanun Poonnopathum
 */
public class MoneyFactoryDemo {

	public static void main(String[] args){
		MoneyFactory factory = MoneyFactory.getInstance();
		
		Valuable v1 = factory.createMoney(5);
		System.out.println(v1.toString());
		
		Valuable v2 = factory.createMoney(50);
		System.out.println(v2.toString());
		
		Valuable v3 = factory.createMoney("1000.0");
		System.out.println(v3.toString());
		
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory malayFactory = MoneyFactory.getInstance();
		
		Valuable v4 = malayFactory.createMoney(5);
		System.out.println(v4.toString());
		
		Valuable v5 = malayFactory.createMoney("0.05");
		System.out.println(v5.toString());
		
		Valuable v6 = factory.createMoney(500);
		System.out.println(v6.toString());
	}
}

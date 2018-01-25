package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency
 * @author Poonnanun Poonpathum
 */
public class Coin implements Comparable<Coin>{

	private double value;
	private String currency;
	
	public Coin(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	
	public double getValue(){
		return this.value;
	}
	
	public String getCurrency(){
		return this.currency;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		Coin coin = (Coin) obj;
		return this.currency.equals(((Coin) obj).currency) && this.value == ((Coin) obj).value;
	}
	
	@Override
	public int compareTo(Coin coin){
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
	
	@Override
	public String toString(){
		return value+"-"+currency;
	}
}

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
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		Coin other = (Coin) obj;
		if (!currency.equalsIgnoreCase(other.currency)){
			return false;
		}
			
		if (value != value){
			return false;
		}
		return true;
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

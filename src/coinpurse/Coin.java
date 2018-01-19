package coinpurse;

public class Coin {

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
	public boolean equals(Object arg){
		return false;
	}
	
	public int compareTo(Coin coin){
		return 0;
	}
	
	@Override
	public String toString(){
		return null;
	}
}

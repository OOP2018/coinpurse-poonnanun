package strategy;

import java.util.List;

public class Withdraw {

	private double value;
	
	public Withdraw(double value){
		this.value = value;
	}
	
	public Withdraw(){
		this.value = 0;
	}
	
	public double getValue(){
		return value;
	}
	
	public double max(List<Double> list){
		if(list.size()<1) throw new IllegalArgumentException("Must have atleast 1 element");
		if(list.size() == 1) return list.get(0);
		double first = list.get(0);
		return Math.max(first, max( list.subList(1, list.size())));
	}
}

package strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class RecusiveWithdrawStrategy implements WithdrawStrategy{

	private List<Valuable> temp;
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuable) {
		temp = new ArrayList<>();
		if(recursive(0,valuable,amount.getValue(),amount.getCurrency())){
			return temp;
		}
		System.out.println("Fail to withdraw : "+amount.getValue());
		return null;
	}
	
	public boolean recursive(int start, List<Valuable> valuable, double target,String currency){
		// Base Case
		if(start >= valuable.size()) return (target == 0);
		
		// Check that target-next value equals to zero
		if(recursive(start+1, valuable, target-valuable.get(start).getValue(), currency) && valuable.get(start).getCurrency().equals(currency)){
			temp.add(valuable.get(start));
			valuable.remove(start);
			return true;
		}
		
		// Move to next loop
		if(recursive(start+1, valuable, target, currency)){
			return true;
		}
		return false;
		
	}
	
}

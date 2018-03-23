package strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class RecusiveWithdrawStrategy implements WithdrawStrategy{

	private List<Valuable> temp = new ArrayList<>();
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuable) {
		if(recursive(0,valuable,amount.getValue())){
			return temp;
		}
		System.out.println("Fail to withdraw : "+amount.getValue());
		return null;
	}
	
	public boolean recursive(int start, List<Valuable> valuable, double target){
		// Base Case
		if(start >= valuable.size()) return (target == 0);
		
		// Check that target-next value equals to zero
		if(recursive(start+1, valuable, target-valuable.get(start).getValue())){
			temp.add(valuable.get(start));
			valuable.remove(start);
			return true;
		}
		
		// Move to next loop
		if(recursive(start+1, valuable, target)){
			return true;
		}
		return false;
		
	}
	
}

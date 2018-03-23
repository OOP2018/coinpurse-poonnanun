package strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class GreedyWithdrawStrategy implements WithdrawStrategy{
	
	private Comparator<Valuable> comparator = new ValueComparator();
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		
		 double amountLeft = amount.getValue();
		 java.util.Collections.sort(money, comparator);
		 List<Valuable> temp = new ArrayList<>();
         for(int a = money.size()-1; a >= 0 ; a--){
        	if(amount.getCurrency().equals(money.get(a).getCurrency())){
        		if(amountLeft == 0)	break;
        		if(amountLeft - money.get(a).getValue() >= 0){
         		amountLeft -= money.get(a).getValue();
         		temp.add(money.get(a));
         		money.remove(a);
        		}
         	}
         }
        double total = 0;
     	for(Valuable d : temp){
     		total += d.getValue();
     	}
         if(total == amountLeft) return temp;
         if(total < amountLeft){
        	 Valuable addition = makeMoney(amountLeft-total, amount.getCurrency());
        	 temp.add(addition);
        	 return temp;
         }
         List<Valuable> nullValue = new ArrayList<>();
         return nullValue;
	}
	
	private Valuable makeMoney(double value, String currency) {
    	if(value >= 20){
    		return new BankNote(value, currency);
    	}else{
    		return new Coin(value, currency);
    	}
    }

	
}

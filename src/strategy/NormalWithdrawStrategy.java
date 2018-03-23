package strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class NormalWithdrawStrategy implements WithdrawStrategy{

	private Comparator<Valuable> comparator = new ValueComparator();
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		double total = 0;
    	for(Valuable d : money){
    		total += d.getValue();
    	}
		if(amount.getValue() < 0 || amount.getValue() > total){
         	System.out.println("Can't withdraw exactly = "+amount);
         	return null;
         }
         List<Valuable> temp = new ArrayList<>();
         java.util.Collections.sort(money, comparator);
         double amountLeft = amount.getValue();
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
         if( amountLeft > 0 ){
     		money.addAll(temp);
     		System.out.println("Fail to withdraw : "+amount.getValue());
     		return null;
     	}
         return temp;
	}
	
	
	

}

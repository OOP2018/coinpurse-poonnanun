package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import strategy.NormalWithdrawStrategy;
import strategy.RecusiveWithdrawStrategy;
import strategy.WithdrawStrategy;

/**
 *  A money purse contains money.
 *  You can insert money, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Poonnanun Poonnopathum
 */
public class Purse extends java.util.Observable {
    /** Collection of objects in the purse. */
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
	private Comparator<Valuable> comparator = new ValueComparator();
	private List<Valuable> money = new ArrayList<>();
    private int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of money you can put in purse.
     */
    public Purse(int capacity){
    	this.capacity = capacity;
    }

    /**
     * Count and return the number of money in the purse.
     * This is the number of money, not their value.
     * @return the number of money in the purse
     */
    public int count() { 
    	return money.size(); 
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double total = 0;
    	for(Valuable d : money){
    		total += d.getValue();
    	}
		return total; 
    }
    /**
     * Return the capacity of the money purse.
     * @return the capacity
     */

    public int getCapacity() { 
		return capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        if(count()<this.capacity){
        	return false;
        }
        return true;
    }

    /** 
     * Insert a money into the purse.
     * The money is only inserted if the purse has space for it
     * and the money has positive value.  No worthless money!
     * @param money is a money object to insert into purse
     * @return true if money inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
    	if(value.getValue() <= 0){
    		return false;
    	}
        if(isFull()){
        	return false;
        }
        money.add(value);
        return true;
    }
    
    public Valuable[] withdraw( Valuable amount){
    	 WithdrawStrategy strategy = new NormalWithdrawStrategy();
    	 List<Valuable> withdrawAmount = strategy.withdraw(amount, money);
    	 if(withdrawAmount == null) {
    		 return null;
    	 }
    	 Valuable[] returnAmount = new Valuable[withdrawAmount.size()];
    	 for(int a = 0; a<returnAmount.length; a++){
    		 returnAmount[a] = withdrawAmount.get(a);
    	 }
         return returnAmount;
    }
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of money withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of money objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
        return withdraw( new Money(amount,"Baht"));
	   
	}
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     * @return String of description of the purse contents
     */
    public String toString() {
        String answer = "In your purse got{ ";
        for(Valuable a : money){
        	answer += a.getValue();
        	answer += ", ";
        }
        answer += "}";
    	return answer;
    }

}

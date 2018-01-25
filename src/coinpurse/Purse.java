package coinpurse;

import java.util.ArrayList;
import java.util.List;

//TODO import List, ArrayList, and Collections
// You will use Collections.sort() to sort the coins

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author your name
 */
public class Purse {
    /** Collection of objects in the purse. */
    //TODO declare a List of Coins named "money".
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
	private List<Coin> money = new ArrayList<>();
    private int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse(int capacity){
    	this.capacity = capacity;
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
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
    	for(Coin d : money){
    		total += d.getValue();
    	}
		return total; 
    }
    /**
     * Return the capacity of the coin purse.
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
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
    	if(coin.getValue() == 0){
    		return false;
    	}
        if(isFull()){
        	return false;
        }
        money.add(coin);
        return true;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw( double amount ) {
   
        if(amount < 0 || amount > getBalance()){
        	System.out.println("Can't withdraw exactly = "+amount);
        	return null;
        }
        List<Coin> temp = new ArrayList<>();
        java.util.Collections.sort(money);
        double amountLeft = amount;
       
        for(int a = money.size()-1; a >= 0 ; a--){
        	if(amountLeft == 0){
        		break;
        	}
        	if(amountLeft - money.get(a).getValue() >= 0){
        		amountLeft -= money.get(a).getValue();
        		temp.add(money.get(a));
        		money.remove(a);
        	}
        }
        Coin[] withdrawAmount = new Coin[temp.size()];
    	withdrawAmount = temp.toArray(withdrawAmount);
        if ( withdrawAmount == null){	
    		System.out.println("Fail to withdraw : "+amount);
    		return null;
    	}
        if( amountLeft > 0 ){
    		money.addAll(temp);
    		System.out.println("Fail to withdraw : "+amount);
    		return null;
    	}
        return withdrawAmount;
	   
	}
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
        String answer = "In your purse got{ ";
        for(Coin a : money){
        	answer += a.getValue();
        	answer += ", ";
        }
        answer += "}";
    	return answer;
    }

}

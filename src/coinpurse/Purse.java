package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author your name
 */
public class Purse {
    /** Collection of objects in the purse. */
	private List<Coin> money;
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	 money = new ArrayList<Coin>();
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
		double total = 0 ;
		for(Coin c : money) total += c.getValue();
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
        if(money.size() == capacity) return true;
        return false;
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
        // if the purse is already full then can't insert anything.
        if(isFull()){
        	return false;
        }
        else {
        	if(coin.getValue() <= 0)return false;
        	money.add(coin);
        	return true;
        }
        
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
    	List<Coin> money2 = new ArrayList<>();
    	Collections.sort(money);
		Collections.reverse(money);
		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
    	// Your code might use some other variable for the remaining amount to withdraw.
		if ( amount >= 0 ) {	
			
			for(Coin c : money){
				if(amount >= c.getValue()){
				amount -= c.getValue();
				money2.add(c);
				}
			}
			
			if(amount == 0){
				for(Coin c: money2){
					money.remove(c);
				}
				Coin[] withdraw_coin = new Coin[money2.size()];
				money2.toArray(withdraw_coin);
				return withdraw_coin;
			}			
		}
        return null; 
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return this.count()+" coins with value "+this.getBalance();
    }

}
//TODO When you finish, there should not be any TODO comments, including this one!

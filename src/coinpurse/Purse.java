package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 *  A purse contains valuable objects.
 *  You can insert coins or BankNotes, withdraw money, check the balance,
 *  and check if the purse is full.
 *  @author Charin Tantrakul
 */
public class Purse {
    /** Collection of objects in the purse. */
	private List<Valuable> moneyList;
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     * Define new comparator.
     */
    private Comparator<Valuable> comp = new ValueComparator();
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	 moneyList = new ArrayList<Valuable>();
    }

    /**
     * Count and return the number of valuable objects in the purse.
     * This is the number of valuable objects, not their value.
     * @return the number of valuable objects in the purse.
     */
    public int count() { 
    	return moneyList.size();
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of all items in the purse.
     */
    public double getBalance() {
		double total = 0 ;
		for(Valuable m : moneyList) total += m.getValue();
    	return total; 
	}

    
    /**
     * Return the capacity of the purse.
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
        if(moneyList.size() == capacity) return true;
        return false;
    }

    /** 
     * Insert a valuable object into the purse.
     * The valuable object is only inserted if the purse has space for it
     * and the valuable object has positive value.  No worthless valuable objects!
     * @param money is a Valuable object (Coin or BankNote) to insert into purse
     * @return true if valuable object inserted, false if can't insert
     */
    public boolean insert( Valuable money ) {
        // if the purse is already full then can't insert anything.
        if(isFull()){
        	return false;
        }
        else {
        	if(money.getValue() <= 0)return false;
        	moneyList.add(money);
        	return true;
        }
        
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of valuable objects withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
    	List<Valuable> moneyList2 = new ArrayList<>();
    	Collections.sort(moneyList, comp);
		Collections.reverse(moneyList);
		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a valuable object.
    	// Your code might use some other variable for the remaining amount to withdraw.
		if ( amount >= 0 ) {	
			
			for(Valuable m : moneyList){
				if(amount >= m.getValue()){
				amount -= m.getValue();
				moneyList2.add(m);
				}
			}
			
			if(amount == 0){
				for(Valuable m: moneyList2){
					moneyList.remove(m);
				}
				Valuable [] withdraw_money = new Valuable[moneyList2.size()];
				moneyList2.toArray(withdraw_money);
				return withdraw_money;
			}			
		}
        return null; 
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return "Balance in this purse : "+this.getBalance();
    }

}


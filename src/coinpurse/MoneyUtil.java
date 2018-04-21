package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Some Money(Valuable objects) utility methods for practice using Lists and Comparator.
 * @author Charin Tantrakul
 *
 */
public class MoneyUtil {
	
	/**
	 * Check Valuable objects in List and add E (any object that extends valuable object) that has same currency that you want in new List<E>.
	 * @param moneyList is List of Valuable.
	 * @param currency of valuable that you want .
	 * @return newMoneyList or new List of valuable.
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> moneyList ,String currency) {
		List<E> newMoneyList = new ArrayList<>();
		for(E m: moneyList){
			if(m.getCurrency().equals(currency)) {
				newMoneyList.add(m);
			}
		}
		return newMoneyList;
	}
	
	/**
	 * Print information of any object that extends valuable object.
	 * @param moneyList is List of any object that extends valuable object.
	 */
	public static void printCoin(List<? extends Valuable> moneyList){
		for(Valuable m : moneyList){
			System.out.println(m.toString());
		}
	}
	
	/**
	 * Sort valuable objects by value.
	 * @param money is List of any object that extends valuable object.
	 */
	public static void sortMoney(List<? extends Valuable> moneyList) {
		java.util.Collections.sort(moneyList);
	}
	
	/**
	 * Return the most value or the last order depend on object's compareTo method.
	 * @param arg is one or more Comparable object.
	 * @return max is the most value or the last order.
	 */
	public static <E extends Comparable<? super E>> E max(E ... arg) {
		E max = arg[0];
		int length = arg.length;
		
		for(int i = 1; i < length; i++) {
			if(arg[i].compareTo(max) > 0) {
				max = arg[i];
			}
		}
		return max;
	}
	
	public static void main(String[] arg) {
		Double max = MoneyUtil.max(1.0,2.0,3.0);
		System.out.println(max);
//		Money m1 = new BankNote(100, "Baht",10000);
//		Money m2 = new BankNote(500, "Baht",10001);
//		Money m3 = new Coin(20, "Baht");
//		Money max2 = MoneyUtil.max( m1, m2, m3 ); 
//		System.out.println(max2);
//		List<BankNote> list = new ArrayList<BankNote>();
//		list.add( new BankNote(10.0, "USD",1000) );
//		list.add( new BankNote(500.0, "Baht",1001) );
//		MoneyUtil.sortMoney( list );
//		MoneyUtil.printCoin(list);
//		List<Coin> coins = Arrays.asList( new Coin(5,"Baht"),
//				 new Coin(0.1,"Ringgit"), new Coin(5,"Cent"), new Coin(10,"Baht") );
//		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
//		MoneyUtil.printCoin(result);
		
	}

}


package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Some Money(Valuable objects) utility methods for practice using Lists and Comparator.
 * @author Charin Tantrakul
 *
 */
public class MoneyUtil {
	
	/**
	 * Check Valuable objects in List and add valuable object (Coin or BankNote) that has same currency that you want in new List<Valuable>.
	 * @param moneyList is List of Valuable.
	 * @param currency of valuable that you want .
	 * @return newMoneyList or new List of valuable.
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> moneyList ,String currency) {
		List<Valuable> newMoneyList = new ArrayList<>();
		for(Valuable m: moneyList){
			if(m.getCurrency().equals(currency)) {
				newMoneyList.add(m);
			}
		}
		return newMoneyList;
	}
	
	/**
	 * Print information of valuable object.
	 * @param money is List of valuable object.
	 */
	public static void printCoin(List<Valuable> money){
		for(Valuable m : money){
			System.out.println(m.toString());
		}
	}
	
	/**
	 * Sort valuable objects by value.
	 * @param money is List of valuable object.
	 */
	public static void sortCoins(List<Valuable> money) {
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(money,comp);
	}
	
	/**
	 * Test other method and BankNote objects.
	 * @param arg not used
	 */
	public static void main(String[] arg){
		List<Valuable> money = new ArrayList<Valuable>();
		money.add(new Coin(1 , "Baht"));
		money.add(new Coin(10.50 , "Baht"));
		money.add(new Coin(57 , "Baht"));
		money.add(new Coin(2 , "Baht"));
		money.add(new Coin(40 , "Peru"));
		money.add(new BankNote(20,"Baht"));
		money.add(new BankNote(30,"Baht"));
		money.add(new BankNote(100,"Baht"));
		money.add(new BankNote(500,"Meso"));
		money = filterByCurrency(money, "Baht");
		printCoin(money);
//		printCoin(money);
//		sortCoins(money);
//		printCoin(money);
	}
}

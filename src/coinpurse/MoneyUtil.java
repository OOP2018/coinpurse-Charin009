package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * @author Charin Tantrakul
 *
 */
public class MoneyUtil {
	
	/**
	 * Check coin in List and add coin that has same currency that you want in new List<Coin>.
	 * @param coins is List of coin.
	 * @param currency of coin that you want .
	 * @return newCoins or new List of coin.
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins ,String currency) {
		List<Coin> newCoins = new ArrayList<>();
		for(Coin c: coins){
			if(c.getCurrency().equals(currency)) {
				newCoins.add(c);
			}
		}
		return newCoins;
	}
	
	/**
	 * Print information of coin.
	 * @param coins is List of coin.
	 */
	public static void printCoin(List<Coin> coins){
		for(Coin c : coins){
			System.out.println(c.toString());
		}
	}
	
	/**
	 * Sort coin by value.
	 * @param coins is List of coin.
	 */
	public static void sortCoins(List<Coin> coins) {
		java.util.Collections.sort(coins);
	}
	
	/**
	 * Test other method.
	 * @param arg not used
	 */
	public static void main(String[] arg){
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(1 , "Baht"));
		coins.add(new Coin(10.50 , "Baht"));
		coins.add(new Coin(57 , "Baht"));
		coins.add(new Coin(2 , "Baht"));
		coins.add(new Coin(40 , "Peru"));
		coins = filterByCurrency(coins, "Baht");
		printCoin(coins);
//		sortCoins(coins);
//		java.util.Collections.reverse(coins);
//		printCoin(coins);
//		
	}
}

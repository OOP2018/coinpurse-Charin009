package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {

	public static List<Coin> filterByCurrency(List<Coin> coins ,String currency) {
		List<Coin> newCoins = new ArrayList<>();
		for(Coin c: coins){
			if(c.getCurrency().equals(currency)) {
				newCoins.add(c);
			}
		}
		return newCoins;
	}
	

	public static void printCoin(List<Coin> coins){
		for(Coin c : coins){
			System.out.println(c.toString());
		}
	}
	
	public static void sortCoins(List<Coin> coins) {
		java.util.Collections.sort(coins);
	}
	
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

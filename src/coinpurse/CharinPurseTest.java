package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * My own test class to test new version of Purse ,MoneyUtil ,and BankNoteobject
 * @author Charin Tantrakul.
 *
 */
public class CharinPurseTest {

		public static void main (String[] arg) {
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
			money = MoneyUtil.filterByCurrency(money, "Baht");
			MoneyUtil.printCoin(money);
			Purse testPurse = new Purse(money.size());
			for(Valuable m: money){
				testPurse.insert(m);
			}
			testPurse.withdraw(140.50);
			System.out.println(testPurse.toString());
			
			System.out.println(testPurse.getBalance( ) );
			 System.out.println(testPurse.count( ) );
			 System.out.println(testPurse.isFull( ) );
			 System.out.println(testPurse.insert(new Coin(5, "Baht")));
			 System.out.println(testPurse.insert(new BankNote(10, "Baht")) );
			 System.out.println(testPurse.insert(new Coin(0, "Baht")) );
			 System.out.println(testPurse.insert(new Coin(1, "Baht")) );
			 System.out.println(testPurse.insert(new Coin(5, "Baht"))) ;
			 System.out.println(testPurse.count( )) ;
			 System.out.println(testPurse.isFull( )) ;
			 System.out.println(testPurse.getBalance( ) );
			 System.out.println(testPurse.toString() );
			 System.out.println(testPurse.withdraw(12) );
			 System.out.println(testPurse.withdraw(11));
			 System.out.println(testPurse.isFull( )) ;
			 System.out.println(testPurse.getBalance( ) );
		}
}

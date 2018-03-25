package strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.MoneyUtil;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

/**
 * GreedyWithdraw 
 * Find list of Valuable that purse use to find which Money in purse should remove by Greedy Algorithm.
 * @author Charin Tantrkul.
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> money2 = new ArrayList<Valuable>();
		List<Valuable> money3 = MoneyUtil.filterByCurrency(money, amount.getCurrency());
		double doubleAmount = amount.getValue();
		Collections.sort(money3);
		Collections.reverse(money3);
		
		if (amount.getValue() >= 0) {
			for (Valuable values : money3) {
				if (doubleAmount >= values.getValue()) {
					doubleAmount -= values.getValue();
					money2.add(values);
				}
			}

			if (doubleAmount == 0) {
				return money2;
			}
		}
		return null;
	}

}

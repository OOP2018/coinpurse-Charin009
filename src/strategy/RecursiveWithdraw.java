package strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.MoneyUtil;
import coinpurse.Valuable;

/**
 * RcursiveWithdraw 
 * Find list of Valuable that purse use to find which Money in purse should remove by Recursion.
 * @author Charin Tantrkul.
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> money3 = MoneyUtil.filterByCurrency(money, amount.getCurrency());
		double amountDouble = amount.getValue();
		return helper(amountDouble,money3);
		
	}
	
	/**
	 * Helper that find list of Valuable that purse should to remove.
	 * @param amount value of money that user want to withdraw.
	 * @param money list of money in purse.
	 * @return list of valuable.
	 */
	public List<Valuable> helper(double amount, List<Valuable> money) {
		if(amount < 0)return null;
		if(money.isEmpty() && amount != 0) return null;
		if(amount == 0) return new ArrayList<>();
		
	
		List<Valuable> leftSide = helper(amount - money.get(0).getValue() ,money.subList(1, money.size()));
		List<Valuable> rightSide = helper(amount,money.subList(1, money.size()));
		
		if(leftSide != null) {
			leftSide.add(money.get(0));
			return leftSide;
		}
		return rightSide;
	}

}

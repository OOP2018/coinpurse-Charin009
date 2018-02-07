package coinpurse;

import java.util.Comparator;

/**
 * Class that compare Valuable object.
 * 
 * @author Charin Tantrakul.
 *
 */
public class ValueComparator implements Comparator<Valuable> {

	/**
	 * Compare two objects that implement Valuable. Order them by value.
	 */
	public int compare(Valuable a, Valuable b) {
		if (a == null || b == null)
			return 1;
		if (a.getCurrency().equalsIgnoreCase(b.getCurrency())) {
			if (a.getValue() == b.getValue())
				return 0;
			if (b.getValue() > a.getValue() )
				return -1;
			if(b.getValue() < a.getValue() )
				return 1;
		}
		return a.getCurrency().compareTo(b.getCurrency());
	}
}

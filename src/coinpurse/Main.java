package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author charin tantrakul
 */
public class Main {
	private static MoneyFactory factory = null;
	private static String currency;
	
	public static void init(){
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryClass = bundle.getString("moneyfactory");
		try {
			factory = (MoneyFactory) Class.forName(factoryClass).newInstance();
			if(factoryClass.equalsIgnoreCase("coinpurse.ThaiMoneyFactory")) {
				currency = "Baht";
			} else {
				currency = "Ringgit";
			}
		} catch (ClassCastException e) {
			System.out.println(factoryClass + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (factory == null) {
			System.exit(0);
		} else {
			MoneyFactory.setMoneyFactory(factory);
		}
	}

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	Main.init();
    	Purse purse = new Purse(10);
    	ConsoleDialog ui = new ConsoleDialog(purse,currency);
    	ui.run();
    	

    }
}


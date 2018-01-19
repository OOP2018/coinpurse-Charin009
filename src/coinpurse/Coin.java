package coinpurse;

public class Coin implements Comparable<Coin> {
	
	private double value;
	private String currency;
	 
	public Coin(double value, String currency) {
		if(value >= 0) {
		this.value = value;
		this.currency = currency;
		}
	}
	
	public double getValue() {
		return this.value;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
	public boolean equals(Object arg) {
		if(arg == null) return false;
		if(arg.getClass() != this.getClass()) return false;
		Coin other_coin = (Coin) arg;
		if(value == other_coin.value && currency.equalsIgnoreCase(other_coin.currency)) return true;
		return false;
	}
	
	

	@Override
	public int compareTo(Coin coin) {
		if (this.value == coin.value) return 0;
		if(this.value > coin.value) return 1;
		if(this.value < coin.value) return -1;
		return 0;
	}
	
	@Override
	public String toString(){
		return String.format("%.2f %s", this.value,this.currency);
	}

}

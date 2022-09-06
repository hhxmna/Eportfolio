package gui;

public class Stock extends Investment {
	public Stock(){
		super();
	}
	
	public Stock(String symbol, String name, int quantity, 
			double price, double bookValue) {
		super(symbol, name, quantity, price, 
				bookValue);
	}

	public double calAndGetBookValue(int quantity, double price){
		return price * quantity + 9.99;
	}
	
	public double calAndGetGain(){
		return this.calAndGetBookValue(quantity, price) - this.getBookValue();
	}
	
	public double calulatePayment(int shares, double price){
		double payment = shares * price - 9.99;
		this.setBookValue(this.getBookValue() * shares / quantity);
		this.setQuantity(quantity - shares);
		return payment;
	}
}

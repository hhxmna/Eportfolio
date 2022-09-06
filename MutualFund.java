package gui;

public class MutualFund extends Investment{
	public MutualFund(){
		super();
	}
	
	public MutualFund(String symbol, String name, int quantity, double price, double bookValue) {
		super(symbol, name, quantity, price, bookValue);
	}

	public double calAndGetBookValue(int quantity, double price){
		return price * quantity;
	}
	
	public double calAndGetGain(){
		return (this.calAndGetBookValue(quantity, price) + 45) - this.getBookValue();
	}
	
	public double calulatePayment(int shares, double price){		
		double payment = shares * price - 45.0;
		this.setBookValue(this.getBookValue() * shares / quantity);
		this.setQuantity(quantity - shares);
		return payment;
	}
}

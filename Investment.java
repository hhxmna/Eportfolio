package gui;

import javax.swing.JTextArea;

public class Investment {
	protected String symbol;
	protected String name;
	protected int quantity;
	protected double price;
	protected double bookValue;
	
	public Investment(){
		super();
	}
	
	public Investment(String symbol, String name, int quantity, double price,
			double bookValue) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.bookValue = bookValue;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getBookValue() {
		return bookValue;
	}

	public void setBookValue(double bookValue) {
		this.bookValue = bookValue;
	}
	
	
	public void display(JTextArea textArea){
		textArea.append("\nSymbol: " + symbol);
		textArea.append(" Name: " + name);
		textArea.append(" Price: "+ price);
		textArea.append(" Quantity: " + quantity);
		textArea.append(" BookValue: "+ bookValue+"\n");
	}
}

package com.oos.booksrus;

import java.util.ArrayList;

public class Cart {
	
	private ArrayList<Product> items;
	private final double SHIPPING = 3.99;

	public Cart() {
		items = new ArrayList<Product>();
	}

	public ArrayList<Product> getProducts() {
		return items;
	}

	public Product getProduct(int i) {
		return items.get(i);
	}

	public void addProduct(Product p) {
		items.add(p);
	}

	public void removeProduct(Product p) {
		items.remove(p);
	}
	
	public int totalProducts() {
		return this.items.size();
	}
	
	public double getTotal() {
		double total = 0;
		for (Product p: this.items) {
			total += p.getPrice();
		}
		
		return total;
	}
	
	public double finalCost() {
		return this.getTotal() + SHIPPING;
	}

}

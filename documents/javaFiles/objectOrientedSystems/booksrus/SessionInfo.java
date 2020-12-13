package com.oos.booksrus;

import java.util.ArrayList;

import com.oos.booksrus.db.User;
import com.oos.booksrus.db.Employee;

/*
 * Another singleton class, to maintain session information.
 */
public class SessionInfo {
	private static SessionInfo sInstance;
	private boolean loggedIn;
	private Cart cart;
	private User user;
	private Employee employee;

	public static SessionInfo getInstance() {
		if (sInstance == null) {
			sInstance = new SessionInfo();
		}
		return sInstance;
	}

	private SessionInfo() {
		this.loggedIn = false;
		this.cart = new Cart();
	}

	public void login(User user) {
		this.user = user;
		this.loggedIn = true;
	}
	
	public void loginEmployee(Employee employee) {
		this.employee = employee;
		this.loggedIn = true;
	}

	public void logout() {
		this.user = null;
		this.loggedIn = false;
	}
	
	public User getUser() {
		return this.user;
	}

	public Employee getEmployee(){
		
		return this.employee;
	}
	
	public boolean isLoggedIn() {
		return this.loggedIn;
	}

	public void addProduct(Product p) {
		cart.addProduct(p);
	}

	public void removeProduct(Product p) {
		cart.removeProduct(p);
	}

	public String[] getCartProducts() {
		ArrayList<String> products = new ArrayList<String>();
		String[] temp = new String[this.cart.getProducts().size()];

		for (Product p : this.cart.getProducts()) {
			products.add(p.getTitle());
		}

		return (String[]) products.toArray(temp);
	}

	public double getTotal() {
		return this.cart.getTotal();
	}
	
	public double getFinalCost() {
		return this.cart.finalCost();
	}
}

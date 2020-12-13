package com.oos.booksrus.db;

public class Order {
	private String name;
	private String[] books;
	private String date;
	private int key;
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int i) {
		this.key = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String[] getBook() {
		return books;
	}

	public void setBook(String booksString) {
		books = booksString.split("SeparateTheBooks");
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}
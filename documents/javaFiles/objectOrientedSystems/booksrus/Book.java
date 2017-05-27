package com.oos.booksrus;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Book extends Product implements Serializable {
	private static final long serialVersionUID = 6380947550599935448L;

	private List<String> authors;
	private String isbn;
	private String genre;
	private String imgsrc;
	private String description;

	public Book(String title) {
		this.setTitle(title);
		this.setIsbn("");
		this.setAuthors(new LinkedList<String>());
		this.setGenre("");
		this.setImgsrc("");
		this.setDescription("");
	}

	public Book(String title, String isbn) {
		this.setTitle(title);
		this.setIsbn(isbn);
		this.setAuthors(new LinkedList<String>());
		this.setGenre("");
		this.setImgsrc("");
		this.setDescription("");
	}

	public void updateAuthors(String author) {
		this.authors.add(author);
	}

	public String[] getAuthors() {
		String[] auth = new String[4];
		return (String[]) authors.toArray(auth);
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String toString() {
		return getTitle();
	}

	public void setImgsrc(String src) {
		this.imgsrc = src;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgsrc() {
		return this.imgsrc;
	}

	public String getDescription() {
		return this.description;
	}
}

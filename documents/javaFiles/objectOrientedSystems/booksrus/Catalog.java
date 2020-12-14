package com.oos.booksrus;

import java.io.Serializable;
import java.util.LinkedList;

public class Catalog implements Serializable {
	private static final long serialVersionUID = -6143216310584608008L;

	private LinkedList<Book> catalog;
	private LinkedList<String> catalogIndex;

	public Catalog() {
		this.catalog = new LinkedList<Book>();
		this.catalogIndex = new LinkedList<String>();

		Book twilight = new Book("Twilight", "9780316015844");
		twilight.updateAuthors("Author: Stephenie Meyer");
		twilight.setDescription("Overview: Isabella Swan's move to Forks, a small, perpetually rainy town in Washington, could have been the most boring move she ever made. But once she meets the mysterious and alluring Edward Cullen, Isabella's life takes a thrilling and terrifying turn. Up until now, Edward has managed to keep his vampire identity a secret in the small community he lives in, but now nobody is safe, especially Isabella, the person Edward holds most dear. The lovers find themselves balanced precariously on the point of a knife-between desire and danger.Deeply romantic and extraordinarily suspenseful, Twilight captures the struggle between defying our instincts and satisfying our desires. This is a love story with bite.");
		twilight.setGenre("Genre: Teen fiction");
		twilight.setPrice(8.15);
		twilight.setImgsrc("");

		Book newMoon = new Book("New Moon", "9780316024969");
		newMoon.updateAuthors("Author: Stephenie Meyer");
		newMoon.setDescription("Overview: For Bella Swan, there is one thing more important than life itself: Edward Cullen. But being in love with a vampire is more dangerous than Bella ever could have imagined. Edward has already rescued Bella from the clutches of an evil vampire, but now, as their daring relationship threatens all that is near and dear to them, they realize their troubles may just be beginning...");
		newMoon.setGenre("Genre: Teen fiction");
		newMoon.setPrice(8.15);
		newMoon.setImgsrc("");

		Book eclipse = new Book("Eclipse", "9780316160209");
		eclipse.updateAuthors("Author: Stephenie Meyer");
		eclipse.setDescription("Overview: As Seattle is ravaged by a string of mysterious killings and a malicious vampire continues her quest for revenge, Bella once again finds herself surrounded by danger. In the midst of it all, she is forced to choose between her love for Edward and her friendship with Jacob �- knowing that her decision has the potential to ignite the ageless struggle between vampire and werewolf. With her graduation quickly approaching, Bella has one more decision to make: life or death. But which is which?");
		eclipse.setGenre("Genre: Teen fiction");
		eclipse.setPrice(13.79);
		eclipse.setImgsrc("");

		Book breakingDawn = new Book("Breaking Dawn", "9780316067935");
		breakingDawn.updateAuthors("Author: Stephenie Meyer");
		breakingDawn
				.setDescription("Overview: When you loved the one who was killing you, it left you no options. How could you run, how could you fight, when doing so would hurt that beloved one? If your life was all you had to give, how could you not give it? If it was someone you truly loved?");
		breakingDawn.setGenre("Genre: Teen fiction");
		breakingDawn.setPrice(12.45);
		breakingDawn.setImgsrc("");

		Book hungerGames = new Book("The Hunger Games", "9780439023528");
		hungerGames.updateAuthors("Author: Suzanne Collins");
		hungerGames
				.setDescription("Overview: In the ruins of a place once known as North America lies the nation of Panem, a shining Capitol surrounded by twelve outlying districts. The Capitol is harsh and cruel and keeps the districts in line by forcing them all to send one boy and one girl between the ages of twelve and eighteen to participate in the annual Hunger Games, a fight to the death on live TV. Sixteen-year-old Katniss Everdeen, who lives alone with her mother and younger sister, regards it as a death sentence when she is forced to represent her district in the Games. But Katniss has been close to dead before-and survival.");
		hungerGames.setGenre("Genre: Teen fiction");
		hungerGames.setPrice(6.21);
		hungerGames.setImgsrc("");

		Book catchingFire = new Book("Catching Fire", "9780545586177");
		catchingFire.updateAuthors("Author: Suzanne Collins");
		catchingFire
				.setDescription("Overview: Against all odds, Katniss Everdeen has won the annual Hunger Games with fellow district tribute Peeta Mellark. But it was a victory won by defiance of the Capitol and their harsh rules. Katniss and Peeta should be happy. After all, they have just won for themselves and their families a life of safety and plenty. But there are rumors of rebellion among the subjects, and Katniss and Peeta, to their horror, are the faces of that rebellion. The Capitol is angry. The Capitol wants revenge.");
		catchingFire.setGenre("Genre: Teen fiction");
		catchingFire.setPrice(8.32);
		catchingFire.setImgsrc("");

		Book mockingJay = new Book("Mockingjay", "9780545663267");
		mockingJay.updateAuthors("Author: Suzanne Collins");
		mockingJay
				.setDescription("Overview: \"My name is Katniss Everdeen. Why am I not dead? I should be dead.\" Katniss Everdeen, girl on fire, has survived, even though her home has been destroyed. There are rebels. There are new leaders. A revolution is unfolding. District 13 has come out of the shadows and is plotting to overthrow the Capitol. Though she's long been a part of the revolution, Katniss hasn't known it. Now it seems that everyone has had a hand in the carefully laid plans but her.");
		mockingJay.setGenre("Genre: Teen fiction");
		mockingJay.setPrice(8.34);
		mockingJay.setImgsrc("");

		catalog.add(twilight);
		catalogIndex.add(twilight.getTitle());
		catalog.add(newMoon);
		catalogIndex.add(newMoon.getTitle());
		catalog.add(eclipse);
		catalogIndex.add(eclipse.getTitle());
		catalog.add(breakingDawn);
		catalogIndex.add(breakingDawn.getTitle());
		catalog.add(hungerGames);
		catalogIndex.add(hungerGames.getTitle());
		catalog.add(catchingFire);
		catalogIndex.add(catchingFire.getTitle());
		catalog.add(mockingJay);
		catalogIndex.add(mockingJay.getTitle());

	}

	public String[] getProductStrings() {
		String[] list = new String[this.catalog.size()];
		for (int i = 0; i < this.catalog.size(); i++) {
			list[i] = this.catalog.get(i).toString();
		}

		return list;
	}

	/**
	 * @return the number of products in this catalog.
	 */
	public int size() {
		return this.catalog.size();
	}

	public void addBook(Book p) {
		this.catalog.add(p);
	}

	public Book getProductByTitle(String title) {

		Book r = null;

		int index = catalogIndex.indexOf(title);
		r = (Book) catalog.get(index);

		return r;
	}

	public Book getBookByIndex(int in) {
		int s = this.size();
		Book r = null;
		if ((in > s) || (in < 0)) {

		} else {
			r = (Book) catalog.get(in);

		}

		return r;
	}

}
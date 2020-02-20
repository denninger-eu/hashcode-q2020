package q2020.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
	private final int id;
	private final int bookCount;
	private final int signupDays;
	private final int shipDays;

	public int[] books;

	public List<Book> booksSorted = new ArrayList<Book>();

	public Library(int id, int bookCount, int signupDays, int shipDays) {
		this.id = id;
		this.bookCount = bookCount;
		this.signupDays = signupDays;
		this.shipDays = shipDays;
	}

	public int getBookCount() {
		return bookCount;
	}

	public int[] getBooks() {
		return books;
	}

	public List<Book> getBooksSorted() {
		return booksSorted;
	}

	public void setBooks(int[] books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public int getSignupDays() {
		return signupDays;
	}

	public int getShipDays() {
		return shipDays;
	}

	@Override
	public String toString() {
		return "Library [bookCount=" + bookCount + ", signupDays=" + signupDays + ", shipDays=" + shipDays + ", books="
				+ Arrays.toString(books) + "]";
	}

}

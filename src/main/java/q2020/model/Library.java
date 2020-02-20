package q2020.model;

import java.util.Arrays;

public class Library {
	private final int id;
	private final int bookCount;
	private final int signupDays;
	private final int numberOfBooksToShipPerDay;

	public int[] books;

	public Library(int id, int bookCount, int signupDays, int numberOfBooksToShipPerDay) {
		this.id = id;
		this.bookCount = bookCount;
		this.signupDays = signupDays;
		this.numberOfBooksToShipPerDay = numberOfBooksToShipPerDay;
	}

	public int getBookCount() {
		return bookCount;
	}

	public int[] getBooks() {
		return books;
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

	public int getNumberOfBooksToShipPerDay() {
		return numberOfBooksToShipPerDay;
	}

	@Override
	public String toString() {
		return "Library [bookCount=" + bookCount + ", signupDays=" + signupDays + ", shipDays=" + numberOfBooksToShipPerDay + ", books="
				+ Arrays.toString(books) + "]";
	}



}

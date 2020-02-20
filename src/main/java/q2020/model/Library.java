package q2020.model;

import java.util.Arrays;

public class Library {

	private final int bookCount;
	private final int signupDays;
	private final int shipDays;

	public int[] books;

	public Library(int bookCount, int signupDays, int shipDays) {
		this.bookCount = bookCount;
		this.signupDays = signupDays;
		this.shipDays = shipDays;
	}

	public int getBookCount() {
		return bookCount;
	}

	@Override
	public String toString() {
		return "Library [bookCount=" + bookCount + ", signupDays=" + signupDays + ", shipDays=" + shipDays + ", books="
				+ Arrays.toString(books) + "]";
	}

}

package q2020;

import java.util.Comparator;

import q2020.model.Book;

public class Comparer {

	public static class BookByScore implements Comparator<Book> {

		@Override
		public int compare(Book o1, Book o2) {
			return Integer.compare(o1.getScore(), o2.getScore());
		}

	}
}

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

	public static class BookByScoreDesc implements Comparator<Book> {

		@Override
		public int compare(Book o1, Book o2) {
			return Integer.compare(o2.getScore(), o1.getScore());
		}

	}

	public static class LibraryWithPotentialDesc implements Comparator<LibraryWithPotential> {

		@Override
		public int compare(LibraryWithPotential o1, LibraryWithPotential o2) {
			return Long.compare(o1.getScore(), o2.getScore());
		}

	}
}

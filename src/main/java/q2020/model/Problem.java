package q2020.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {
	private final String name;
	private final int bookCount;
	private final int libraryCount;
	private final int days;

	private final Map<Integer, Book> books = new HashMap<>();

	private int[] bookScore;

	private Library[] libraries;

	private final Map<Integer, List<Library>> libraryByBook = new HashMap<>();

	public Problem(String name, int bookCount, int libraryCount, int days) {
		this.name = name;
		this.bookCount = bookCount;
		this.libraryCount = libraryCount;
		this.days = days;
	}

	public String getName() {
		return name;
	}

	public Map<Integer, Book> getBooks() {
		return books;
	}

	public static Problem parseHeader(String header, String name) {
		int[] head = parseLine(header, new int[3]);

		return new Problem(name, head[0], head[1], head[2]);
	}

	public static Problem parse(BufferedReader bf, String name2) {

		try {
			Problem problem = parseHeader(bf.readLine(), name2);

			problem.bookScore = parseLine(bf.readLine(), new int[problem.bookCount]);

			int[] bookScore2 = problem.bookScore;
			for (int id = 0; id < bookScore2.length; id++) {
				problem.books.put(id, new Book(id, bookScore2[id]));
			}

			problem.libraries = new Library[problem.libraryCount];
			for (int library = 0; library < problem.libraryCount; library++) {

				int[] libraryHeader = parseLine(bf.readLine(), new int[3]);
				Library lib = new Library(library, libraryHeader[0], libraryHeader[1], libraryHeader[2]);
				lib.books = parseLine(bf.readLine(), new int[lib.getBookCount()]);

				problem.libraryByBook.computeIfAbsent(library, (__) -> new ArrayList<>()).add(lib);
				problem.libraries[library] = lib;
			}

			return problem;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static int[] parseLine(String line, int[] target) {
		String[] parts = line.split(" ");
		for (int index = 0; index < target.length; index++) {
			target[index] = Integer.parseInt(parts[index]);
		}
		return target;
	}

	@Override
	public String toString() {
		return "Problem [bookCount=" + bookCount + ", libraryCount=" + libraryCount + ", days=" + days + ", bookScore="
				+ Arrays.toString(bookScore) + ", libraries=" + Arrays.toString(libraries) + "]";
	}

	public int getBookCount() {
		return bookCount;
	}

	public int[] getBookScore() {
		return bookScore;
	}

	public void setBookScore(int[] bookScore) {
		this.bookScore = bookScore;
	}

	public Library[] getLibraries() {
		return libraries;
	}

	public void setLibraries(Library[] libraries) {
		this.libraries = libraries;
	}

	public int getLibraryCount() {
		return libraryCount;
	}

	public int getDays() {
		return days;
	}

}

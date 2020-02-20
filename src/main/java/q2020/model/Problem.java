package q2020.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem {

	private final int bookCount;
	private final int libraryCount;
	private final int days;

	private int[] bookScore;

	private Library[] libraries;

	public Problem(int bookCount, int libraryCount, int days) {
		this.bookCount = bookCount;
		this.libraryCount = libraryCount;
		this.days = days;
	}

	public static Problem parseHeader(String header) {
		int[] head = parseLine(header, new int[3]);

		return new Problem(head[0], head[1], head[2]);
	}

	public static Problem parse(BufferedReader bf) {

		try {
			Problem problem = parseHeader(bf.readLine());

			problem.bookScore = parseLine(bf.readLine(), new int[problem.bookCount]);
			problem.libraries = new Library[problem.libraryCount];
			for (int library = 0; library < problem.libraryCount; library++) {

				int[] libraryHeader = parseLine(bf.readLine(), new int[3]);
				Library lib = new Library(libraryHeader[0], libraryHeader[1], libraryHeader[2]);
				lib.books = parseLine(bf.readLine(), new int[lib.getBookCount()]);

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

}

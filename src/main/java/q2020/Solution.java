package q2020;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import q2020.model.Library;
import q2020.model.Problem;

public class Solution {

	private final List<UsedLibrary> libraries = new ArrayList<>();
	private final Problem problem;

	private final Map<Integer, UsedLibrary> byId = new HashMap<>();

	private int signup;

	private final Set<Integer> isUsed = new HashSet<>();

	public static class UsedLibrary {
		private final int libraryId;

		private final List<Integer> books = new ArrayList<>();

		private int signup;

		public UsedLibrary(int libraryId, int signup) {
			this.libraryId = libraryId;
			this.signup = signup;
		}

		public void setSignup(int signup) {
			this.signup = signup;
		}

		public int getSignup() {
			return signup;
		}

	}

	public boolean addBook(int id, int book) {
		if (isUsed.contains(book)) {
			return false;
		}
		isUsed.add(book);
		UsedLibrary lib = byId.get(id);
		if (lib != null) {
			lib.books.add(book);
		}
		return true;
	}

	public UsedLibrary addLibrary(int id) {
		UsedLibrary library = new UsedLibrary(id, signup);
		libraries.add(library);

		byId.put(id, library);
		return library;
	}

	public UsedLibrary addLibrary(Library library) {
		if (signup + library.getSignupDays() > problem.getDays()) {
			return null;
		}
		signup += library.getSignupDays();
		return addLibrary(library.getId());
	}

	public Solution(Problem problem) {
		this.problem = problem;
		// TODO Auto-generated constructor stub
	}

	public void write(Writer writer) throws IOException {

		int libCount = 0;
		for (UsedLibrary l : libraries) {
			if (l.books.size() != 0) {
				libCount++;
			}
		}

		writer.write("" + libCount);
		writer.write("\n");
		for (UsedLibrary lib : libraries) {
			if (lib.books.size() != 0) {
				writer.write("" + lib.libraryId);
				writer.write(" ");
				writer.write("" + lib.books.size());
				writer.write("\n");
				for (int book : lib.books) {
					writer.write("" + book);
					writer.write(" ");
				}
				writer.write("\n");
			}
		}
	}

	public boolean isUsed(int book) {
		return isUsed.contains(book);
	}

}

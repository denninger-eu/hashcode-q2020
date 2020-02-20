package q2020;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import q2020.model.Problem;

public class Solution {

	private final List<UsedLibrary> libraries = new ArrayList<>();
	private final Problem problem;

	private final Map<Integer, UsedLibrary> byId = new HashMap<>();

	public static class UsedLibrary {
		private final int libraryId;

		private final List<Integer> books = new ArrayList<>();

		public UsedLibrary(int libraryId) {
			this.libraryId = libraryId;
		}

	}

	public void addBook(int id, int book) {
		UsedLibrary lib = byId.get(id);
		if (lib != null) {
			lib.books.add(book);
		}
	}

	public void addLibrary(int id) {
		UsedLibrary library = new UsedLibrary(id);
		libraries.add(library);

		byId.put(id, library);

	}

	public Solution(Problem problem) {
		this.problem = problem;
		// TODO Auto-generated constructor stub
	}

	public void write(Writer writer) throws IOException {
		writer.write("" + libraries.size());
		writer.write("\n");
		for (UsedLibrary lib : libraries) {
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

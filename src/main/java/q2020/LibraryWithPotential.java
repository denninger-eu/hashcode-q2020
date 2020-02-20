package q2020;

import q2020.model.Library;

public class LibraryWithPotential implements Comparable<LibraryWithPotential> {
	private final Library library;
	private final long score;

	public LibraryWithPotential(Library library, long score) {
		this.library = library;
		this.score = score;
	}

	public Library getLibrary() {
		return library;
	}

	public long getScore() {
		return score;
	}

	@Override
	public int compareTo(LibraryWithPotential o) {
		return Long.compare(score, o.score);
	}
}

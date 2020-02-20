package q2020.model;

public class Book {
	private final int id;
	private final int score;

	public Book(int id, int score) {
		this.id = id;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}
}

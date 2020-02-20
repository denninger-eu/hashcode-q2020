package q2020;

import java.util.ArrayList;
import java.util.List;

import q2020.model.Book;
import q2020.model.Library;
import q2020.model.Problem;

public class Algorithm {

	private final Problem problem;
	private final Solution solution;

	public Algorithm(Problem problem, Solution solution) {
		this.problem = problem;
		this.solution = solution;
	}

	public long libraryPotential(Library library) {
		List<Book> b = new ArrayList<>();
		for (int book : library.getBooks()) {
			b.add(problem.getBooks().get(book));
		}
		b.sort(new Comparer.BookByScoreDesc());
		long score = 0L;
		int shipCycles = (library.getBookCount() / library.getShipDays()) - library.getSignupDays();
		for (int cycle = 0; cycle < shipCycles * library.getShipDays(); cycle++) {
			score += b.get(cycle).getScore();
		}
		return score;
	}

}

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
			if (!solution.isUsed(book)) {
				b.add(problem.getBooks().get(book));
			}
		}
		b.sort(new Comparer.BookByScoreDesc());
		long score = 0L;

		int days = problem.getDays() - library.getSignupDays() - solution.getSignup();
		int index = 0;
		for (int cycle = 0; cycle < days; cycle++) {
			for (int bookOfDay = 0; bookOfDay < library.getShipDays(); bookOfDay++) {
				if (b.size() <= index) {
					return score;
				}
				score += b.get(index).getScore();
				index++;
			}
		}
		return score;
	}

}

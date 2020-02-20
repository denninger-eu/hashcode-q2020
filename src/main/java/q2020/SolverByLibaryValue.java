package q2020;

import java.util.List;
import java.util.stream.Collectors;

import q2020.model.Book;
import q2020.model.Problem;

public class SolverByLibaryValue implements Solver {
	private final Problem problem;

	private final Solution solution;

	public SolverByLibaryValue(Problem problem) {
		this.problem = problem;
		this.solution = new Solution(problem);
	}

	public Solution solve() {
		List<Book> byScore = problem.getBooks().values().stream().sorted(new Comparer.BookByScore())
				.collect(Collectors.toList());

		for (Book book : byScore) {

		}

		return solution;

	}

}

package q2020;

import q2020.model.Library;
import q2020.model.Problem;

public class SolverFirstLibrary {

	private final Problem problem;

	private final Solution solution;

	public SolverFirstLibrary(Problem problem) {
		this.problem = problem;
		solution = new Solution(problem);
	}

	public Solution solve() {

		Library first = problem.getLibraries()[0];
		solution.addLibrary(first.getId());
		for (int book : first.getBooks()) {
			solution.addBook(first.getId(), book);
		}

		return solution;

	}
}

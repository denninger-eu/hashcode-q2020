package q2020;

import q2020.model.Library;
import q2020.model.Problem;

public class SolverGetAllLibraries {

	private final Problem problem;

	private final Solution solution;

	public SolverGetAllLibraries(Problem problem) {
		this.problem = problem;
		solution = new Solution(problem);
	}

	Solution solve_GetAllLibraries() {

		for (Library lib : problem.getLibraries()) {
			solution.addLibrary(lib.getId());
			for (int book : lib.getBooks()) {
				solution.addBook(lib.getId(), book);
			}
		}
		return solution;

	}
}

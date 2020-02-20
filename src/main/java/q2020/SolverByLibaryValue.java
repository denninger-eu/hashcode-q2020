package q2020;

import java.util.ArrayList;
import java.util.List;

import q2020.Solution.UsedLibrary;
import q2020.model.Library;
import q2020.model.Problem;

public class SolverByLibaryValue implements Solver {
	private final Problem problem;

	private final Solution solution;

	private final Algorithm algorithm;

	public SolverByLibaryValue(Problem problem) {
		this.problem = problem;
		this.solution = new Solution(problem);
		this.algorithm = new Algorithm(problem, solution);
	}

	@Override
	public Solution solve() {

		Library[] libraries = problem.getLibraries();

		List<LibraryWithPotential> withPotential = new ArrayList<LibraryWithPotential>();
		for (Library lib : libraries) {
			long potential = algorithm.libraryPotential(lib);
			withPotential.add(new LibraryWithPotential(lib, potential));
		}
		withPotential.sort(new Comparer.LibraryWithPotentialDesc());

		for (LibraryWithPotential library : withPotential) {

			addLibrary(library.getLibrary());
		}

		return solution;

	}

	private void addLibrary(Library library) {
		UsedLibrary used = solution.addLibrary(library);
		if (used != null) {
			int days = problem.getDays() - used.getSignup();
			int sendableBooks = days * library.getShipDays();
			int bookIndex = 0;
			for (int c = 0; c < sendableBooks; c++) {
				if (library.getBooks().length <= bookIndex) {
					return;
				}
				boolean added = solution.addBook(library.getId(), library.getBooks()[bookIndex]);
				if (!added) {
					c--;
				}
				bookIndex++;
			}
		}
	}

}

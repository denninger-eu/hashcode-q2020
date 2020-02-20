package q2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	Set<Integer> usedLibrary = new HashSet<Integer>();

	private List<LibraryWithPotential> getWithPotential() {
		Library[] libraries = problem.getLibraries();

		List<LibraryWithPotential> withPotential = new ArrayList<LibraryWithPotential>();
		for (Library lib : libraries) {
			if (!usedLibrary.contains(lib.getId())) {
				long potential = algorithm.libraryPotential(lib);
				withPotential.add(new LibraryWithPotential(lib, potential));
			}
		}
		withPotential.sort(new Comparer.LibraryWithPotentialDesc());
		return withPotential;
	}

	@Override
	public Solution solve() {

		boolean found = true;
		List<LibraryWithPotential> withPotential = new ArrayList<LibraryWithPotential>();
		do {
			withPotential = getWithPotential();
			
			
			int unt = 3;
			for (int i = 0; i < unt; i++) {
				if (withPotential.size() <= i) {
					return solution;
				}
				LibraryWithPotential library = withPotential.get(i);

				addLibrary(library.getLibrary());
				usedLibrary.add(library.getLibrary().getId());
			}
		} while (!withPotential.isEmpty());
		return solution;

	}

	private void addLibrary(Library library) {
		UsedLibrary used = solution.addLibrary(library);
		if (used != null) {
			int days = problem.getDays() - used.getSignup();
			int sendableBooks = days * library.getNumberOfBooksToShipPerDay();
			int bookIndex = 0;
			for (int c = 0; c < sendableBooks; c++) {
				if (library.getBooks().length <= bookIndex) {
					return;
				}
				boolean added = solution.addBook(library.getId(), library.getBooksSorted().get(bookIndex).getId());
				if (!added) {
					c--;
				}
				bookIndex++;
			}
			if (used.getBooks().isEmpty()) {
				solution.unuse(library);

			}
		}
	}

}

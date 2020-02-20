package q2020;

import java.util.ArrayList;
import java.util.List;

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

//		for (LibraryWithPotential library : withPotential) {
//
//			solution.addLibrary(library.getLibrary());
//		}

		return solution;

	}

	private void addLibrary(Library library) {

	}

}

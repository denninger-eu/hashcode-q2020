package q2020;

import q2020.model.Library;
import q2020.model.Problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SolverChrisHandsOFF implements Solver{

	private final Problem problem;

	private final Solution solution;

	public SolverChrisHandsOFF(Problem problem) {
		this.problem = problem;
		solution = new Solution(problem);
	}

	public Solution solve() {

		List<Library> libs = Arrays.stream(problem.getLibraries()).sorted(new Comparator<Library>() {
			@Override public int compare(Library o1, Library o2) {
				if (o1.getSignupDays() < o2.getSignupDays() ) {
					return 1;
				} else {
					return 0;
				}
			}
		}).collect(Collectors.toList());

		List<Library> sortedByNumberOfBooks = Arrays.stream(problem.getLibraries()).sorted(new Comparator<Library>() {
			@Override public int compare(Library o1, Library o2) {
				if (o1.getBooks().length > o2.getBooks().length) {
					return 1;
				} else {
					return 0;
				}
			}
		}).collect(Collectors.toList());

		List<Library> sortedByNumberOfBooksToShipPerDay = Arrays.stream(problem.getLibraries()).sorted(new Comparator<Library>() {
			@Override public int compare(Library o1, Library o2) {
				if (o1.getNumberOfBooksToShipPerDay() > o2.getNumberOfBooksToShipPerDay()) {
					return 1;
				} else {
					return 0;
				}
			}
		}).collect(Collectors.toList());

		for (Library lib : sortedByNumberOfBooksToShipPerDay) {
			solution.addLibrary(lib.getId());
			for (int book : lib.getBooks()) {
				solution.addBook(lib.getId(), book);
			}
		}
		return solution;

	}
}

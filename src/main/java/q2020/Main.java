package q2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import q2020.model.Problem;

public class Main {
	public static void main(String[] args) throws IOException {

		Problem problem = parse("b_read_on");

		SolverFirstLibrary solverFirstLibrary = new SolverFirstLibrary(problem);
		Solution solve = solverFirstLibrary.solve();

		BufferedWriter writer = Files.newBufferedWriter(Paths.get("out", problem.getName() + ".txt"));
		solve.write(writer);
		writer.flush();
		writer.close();
		// System.out.println(problem);
	}

	static Problem parse(String name) {
		Path path = Paths.get("src", "main", "resources", name + ".txt");

		try (BufferedReader reader = Files.newBufferedReader(path)) {
			return Problem.parse(reader, name);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}

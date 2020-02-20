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

		Problem problemA = parse("a_example");
		Problem problem = parse("b_read_on");
		Problem problemC = parse("c_incunabula");
		Problem problemD = parse ("d_tough_choices");
		Problem problemE = parse("e_so_many_books");
		Problem problemF = parse("f_libraries_of_the_world");

		SolverFirstLibrary solverFirstLibraryA = new SolverFirstLibrary(problemA);
		Solution solveA = solverFirstLibraryA.solve_GetAllLibraries();

		BufferedWriter writerA = Files.newBufferedWriter(Paths.get("out", problemA.getName() + ".txt"));
		solveA.write(writerA);
		writerA.flush();
		writerA.close();



		SolverFirstLibrary solverFirstLibrary = new SolverFirstLibrary(problem);
		Solution solve = solverFirstLibrary.solve_GetAllLibraries();

		BufferedWriter writer = Files.newBufferedWriter(Paths.get("out", problem.getName() + ".txt"));
		solve.write(writer);
		writer.flush();
		writer.close();




		SolverFirstLibrary solverFirstLibraryC = new SolverFirstLibrary(problemC);
		Solution solveC = solverFirstLibraryC.solve_GetAllLibraries();

		BufferedWriter writerC = Files.newBufferedWriter(Paths.get("out", problemC.getName() + ".txt"));
		solveC.write(writerC);
		writerC.flush();
		writerC.close();




		SolverFirstLibrary solverFirstLibraryD = new SolverFirstLibrary(problemD);
		Solution solveD = solverFirstLibraryD.solve_GetAllLibraries();

		BufferedWriter writerD = Files.newBufferedWriter(Paths.get("out", problemD.getName() + ".txt"));
		solveD.write(writerD);
		writerD.flush();
		writerD.close();




		SolverFirstLibrary solverFirstLibraryE = new SolverFirstLibrary(problemE);
		Solution solveE = solverFirstLibraryE.solve_GetAllLibraries();

		BufferedWriter writerE = Files.newBufferedWriter(Paths.get("out", problemE.getName() + ".txt"));
		solveE.write(writerE);
		writerE.flush();
		writerE.close();



		SolverFirstLibrary solverFirstLibraryF = new SolverFirstLibrary(problemF);
		Solution solveF = solverFirstLibraryF.solve_GetAllLibraries();

		BufferedWriter writerF = Files.newBufferedWriter(Paths.get("out", problemF.getName() + ".txt"));
		solveF.write(writerF);
		writerF.flush();
		writerF.close();




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

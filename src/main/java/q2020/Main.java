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

		SolverGetAllLibraries solverGetAllLibrariesA = new SolverGetAllLibraries(problemA);
		Solution solveA = solverGetAllLibrariesA.solve_GetAllLibraries();

		BufferedWriter writerA = Files.newBufferedWriter(Paths.get("out", problemA.getName() + ".txt"));
		solveA.write(writerA);
		writerA.flush();
		writerA.close();


		SolverGetAllLibraries solverGetAllLibraries = new SolverGetAllLibraries(problem);
		Solution solve = solverGetAllLibraries.solve_GetAllLibraries();

		BufferedWriter writer = Files.newBufferedWriter(Paths.get("out", problem.getName() + ".txt"));
		solve.write(writer);
		writer.flush();
		writer.close();




		SolverGetAllLibraries solverGetAllLibrariesC = new SolverGetAllLibraries(problemC);
		Solution solveC = solverGetAllLibrariesC.solve_GetAllLibraries();

		BufferedWriter writerC = Files.newBufferedWriter(Paths.get("out", problemC.getName() + ".txt"));
		solveC.write(writerC);
		writerC.flush();
		writerC.close();




		SolverGetAllLibraries solverGetAllLibrariesD = new SolverGetAllLibraries(problemD);
		Solution solveD = solverGetAllLibrariesD.solve_GetAllLibraries();

		BufferedWriter writerD = Files.newBufferedWriter(Paths.get("out", problemD.getName() + ".txt"));
		solveD.write(writerD);
		writerD.flush();
		writerD.close();




		SolverGetAllLibraries solverGetAllLibrariesE = new SolverGetAllLibraries(problemE);
		Solution solveE = solverGetAllLibrariesE.solve_GetAllLibraries();

		BufferedWriter writerE = Files.newBufferedWriter(Paths.get("out", problemE.getName() + ".txt"));
		solveE.write(writerE);
		writerE.flush();
		writerE.close();



		SolverGetAllLibraries solverGetAllLibrariesF = new SolverGetAllLibraries(problemF);
		Solution solveF = solverGetAllLibrariesF.solve_GetAllLibraries();

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

package q2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import q2020.model.Problem;

public class Main {
	public static void main(String[] args) {

		Problem problem = parse("a_example");

		System.out.println(problem);
	}

	static Problem parse(String name) {
		Path path = Paths.get("src", "main", "resources", name + ".txt");

		try (BufferedReader reader = Files.newBufferedReader(path)) {
			return Problem.parse(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}

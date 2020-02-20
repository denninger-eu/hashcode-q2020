package q2020.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class Problem {
	private final int slideCount;

	public Map<String, Integer> getTagIds() {
		return tagIds;
	}

	public static Problem parseHeader(String header) {
		int[] head = parseLine(header, new int[1]);
		return new Problem(head[0]);
	}

	public static Problem parse(BufferedReader bf) {

		try {
			Problem problem = parseHeader(bf.readLine());

			// int[] temp = new int[6];
			// String line;
			// int id = 0;
			//
			// List<String> tag = new ArrayList<>();
			//
			// while ((line = bf.readLine()) != null) {
			//
			// String[] parts = line.split(" ");
			//
			// boolean hori = "H".equals(parts[0]);
			//
			// List<Integer> tags = new ArrayList<Integer>();
			// for (int index = 2; index < parts.length; index++) {
			//
			// Integer tagId = problem.tagIds.get(parts[index]);
			// if (tagId == null) {
			// tagId = problem.tagIds.size();
			// problem.tagIds.put(parts[index], tagId);
			// }
			// if (tagId >= 0) {
			// tag.add(parts[index]);
			// }
			//
			// tags.add(tagId);
			// }
			//
			// Collections.sort(tags);
			//
			// problem.slides.add(new Slide(id, hori, tags.size(),
			// tags.stream().mapToInt(Integer::intValue).toArray()));
			// id++;
			// }
			//

			return problem;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static int[] parseLine(String line, int[] target) {
		String[] parts = line.split(" ");
		for (int index = 0; index < target.length; index++) {
			target[index] = Integer.parseInt(parts[index]);
		}
		return target;
	}

}

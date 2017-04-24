package hihocode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P1137_md {

	public static void main(String[] args) {
		List<String> data = new ArrayList<>();
		String path = "P1137_data.txt";

		Random random = new Random();

		for (int i = 0; i < 1000; i++) {
			int N, X, Y, B;
			N = 100;//random.nextInt(100) % (100) + 1;
			X = N + 1;
			Y = N + 1;
			while (X + Y < 1 || X + Y > N) {
				X = random.nextInt(100) % (100 + 1);
				Y = random.nextInt(100) % (100 + 1);
			}

			B = random.nextInt(1000) % (1000) + 1;
			data.add(String.format("%d %d %d %d", N, X, Y, B));

			int x = -1, y = -1;
			while (x < X || y < Y) {
				x = random.nextInt(100) % (100 + 1);
				y = N - x;
			}

			for (int j = 0; j < N; j++) {
				char g = random.nextInt(2) == 0 ? 'M' : 'F';
				int v = random.nextInt(10000) % (10000 - 1 + 1) + 1;
				int s = random.nextInt(10) % (10 + 1);

				data.add(String.format("%c %d %d", g, v, s));

			}

		}
		writeFile(path, data);
	}

	public static void writeFile(String path, List<String> data) {
		java.io.File outFile = new java.io.File(path);
		java.io.PrintWriter output = null;
		try {
			output = new java.io.PrintWriter(outFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (String line : data) {
			output.println(line);
		}
		output.close();
	}

}

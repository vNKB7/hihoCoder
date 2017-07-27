package 编程练习赛19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 大礼堂地毯 {
	static char[][] b;
	static char[][] map;
	static int N, M, H, W;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			N = in.nextInt();
			M = in.nextInt();
			int K = in.nextInt();
			in.nextLine();

			b = new char[N][M];
			for (int i = 0; i < N; i++) {
				String line = in.nextLine().trim();
				for (int j = 0; j < line.length(); j++) {
					b[i][j] = line.charAt(j);
				}
			}

			HashMap<Character, Set<Character>> cons = new HashMap<>();
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < M; j++) {
					if (!cons.containsKey(b[i][j - 1])) {
						cons.put(b[i][j - 1], new HashSet<Character>());
					}
					cons.get(b[i][j - 1]).add(b[i][j]);
				}
				
				if (!cons.containsKey(b[i][M - 1])) {
					cons.put(b[i][M - 1], new HashSet<Character>());
				}
				cons.get(b[i][M - 1]).add(b[i][0]);
			}

			for (int k = 0; k < K; k++) {
				H = in.nextInt();
				W = in.nextInt();
				in.nextLine();

				map = new char[H][W];

				boolean a = true;
				for (int i = 0; i < H; i++) {
					String line = in.nextLine().trim();
					for (int j = 0; j < W; j++) {
						map[i][j] = line.charAt(j);
						if (j != 0) {
							if (!cons.containsKey(map[i][j - 1])
									|| !cons.get(map[i][j - 1]).contains(
											map[i][j])) {
								a = false;
							}
						}
					}
				}

				if (!a) {
					System.out.println("NO");
				} else {

					boolean flag = false;

					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (b[i][j] == map[0][0] && ifCover(i, j)) {
								flag = true;
								break;
							}
						}
						if (flag) {
							break;
						}
					}

					if (flag) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				}
			}
		}
	}

	public static boolean ifCover(int x, int y) {
		int Y = y;
		for (int i = 0; i < H; i++) {
			y = Y;
			for (int j = 0; j < W; j++) {
				if (map[i][j] != b[x][y]) {
					return false;
				}
				y = (y + 1) % M;
			}
			x = (x + 1) % N;
		}

		return true;
	}

}

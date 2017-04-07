package hihocode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1094 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int M = in.nextInt();
			in.nextLine();
			char[][] map = new char[N][M];
			for (int i = 0; i < N; i++) {
				String str = in.nextLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			char[][] surround = new char[3][3];
			for (int i = 0; i < 3; i++) {
				String str = in.nextLine();
				for (int j = 0; j < 3; j++) {
					surround[i][j] = str.charAt(j);
				}
			}

			List<char[][]> ss = get_list(surround);
			// for(char[][] s : ss){
			// for(int i = 0; i < 3; i++){
			// for(int j = 0; j < 3; j++){
			// System.out.print(s[i][j]+" ");
			// }
			// System.out.println();
			// }
			// System.out.println("-----------------");
			// }

			// 原题是说"output them from north to south, west to east"。
			// 我对这句话的理解好像有问题。之前前两个循环是交换位置的，然后WA。之后写成现在的样子，通过了.
			for (int i = 0; i < N - 2; i++) {
				for (int j = 0; j < M - 2; j++) {
					for (int k = 0; k < 4; k++) {
						if (compare(map, i, j, ss.get(k))) {
							System.out.println((i + 2) + " " + (j + 2));
							break;
						}
					}
				}
			}
		}
	}

	public static void test() {
		char[][] surround = { { '1', '2', '3' }, { '4', '5', '6' },
				{ '7', '8', '9' } };
		List<char[][]> ss = get_list(surround);
		for (char[][] s : ss) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(s[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("-----------------");
		}

		System.out.println(1);
	}

	public static List<char[][]> get_list(char[][] surround) {
		List<char[][]> list = new ArrayList<char[][]>();
		list.add(new char[3][3]);
		list.add(new char[3][3]);
		list.add(new char[3][3]);
		list.add(new char[3][3]);
		/*
		 * 平面直角坐标系中，点A(x,y)绕点R(rx, ry)逆时针旋转a，得到点A'(x', y') x' = (x - rx)*cos(a)
		 * - (y - ry)*sin(a) + rx y' = (x - rx)*sin(a) + (y - ry)*cos(a) + ry
		 * 
		 * 此处rx = 0, ry = 0
		 */
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				list.get(0)[i][j] = surround[i][j];
				list.get(1)[3 - j - 1][i] = surround[i][j];
				list.get(2)[3 - i - 1][3 - j - 1] = surround[i][j];
				list.get(3)[j][3 - i - 1] = surround[i][j];
			}
		}

		return list;
	}

	public static boolean compare(char[][] map, int x, int y, char[][] surround) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[x + i][y + j] != surround[i][j])
					return false;
			}
		}
		return true;
	}
}
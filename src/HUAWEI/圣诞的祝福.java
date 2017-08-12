package HUAWEI;

import java.util.Scanner;

public class 圣诞的祝福 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int M = in.nextInt();
			int N = in.nextInt();

			int[][] matrix = new int[M][N];

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = in.nextInt();
				}
			}

			int[] result = new int[N];

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					result[j] = matrix[i][j]
							+ Math.max((j > 0 ? result[j - 1] : 0), result[j]);
				}
			}

			System.out.println(result[N-1]);
		}

	}
}

package hihocode;

import java.util.Scanner;

/*
 * #1272 : 买零食
 * 二维背包问题
 */

public class P1272 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int Q = in.nextInt();
			for (int q = 0; q < Q; q++) {
				int N = in.nextInt();
				int[] A = new int[N];
				int[] B = new int[N];
				for (int n = 0; n < N; n++) {
					A[n] = (int) (in.nextDouble() * 2);
					B[n] = in.nextInt();
				}

				int[][] s = new int[61][4];
				for (int i = 0; i < 61; i++) {
					for (int j = 0; j < 4; j++) {
						s[i][j] = -1;
					}
				}
				s[0][0] = 0;

				for (int i = 0; i < N; i++) {
					for (int j = 60; j >= A[i]; j--) {
						for (int k = 3; k >= 1; k--) {
							int tmp = s[j - A[i]][k - 1];
							if (tmp >= 0) {
								s[j][k] = Math.max(s[j][k], tmp + B[i]);
							}
						}
					}
				}

				int max_value = 0;
				for (int i = 10; i < 61; i += 10) {
					for (int j = 0; j < 4; j++) {
						if (max_value < s[i][j]) {
							max_value = s[i][j];
						}
					}
				}
				System.out.println(max_value);
			}
		}
	}
}

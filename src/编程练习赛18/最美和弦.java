package 编程练习赛18;

import java.util.Scanner;

public class 最美和弦 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int K = in.nextInt();
			int[] melody = new int[3 * N];

			for (int i = 0; i < 3 * N; i++) {
				melody[i] = in.nextInt();
			}

			int[][][] DP = new int[N][N][K + 1];

			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					int min = Integer.MAX_VALUE;

					for (int k = -200; k <= 200; k++) {
						int cur1 = 0;
						int cur2 = 0;
						for (int l = i; l <= j; l++) {
							cur1 += Math.abs(melody[3 * l] - k)
									+ Math.abs(melody[3 * l + 1] - (k + 4))
									+ Math.abs(melody[3 * l + 2] - (k + 7));
							cur2 += Math.abs(melody[3 * l] - k)
									+ Math.abs(melody[3 * l + 1] - (k + 3))
									+ Math.abs(melody[3 * l + 2] - (k + 7));
						}

						int cur = Math.min(cur1, cur2);

						if (cur < min) {
							min = cur;
						} else {
							break;
						}
					}
					DP[i][j][0] = min;
				}
			}

			for (int i = 1; i < K + 1; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = j; k < N; k++) {
						int min = Integer.MAX_VALUE;
						for (int l = j; l < k; l++) {
							for (int m = 0; m < i; m++) {
								min = Math.min(min, DP[j][l][m]
										+ DP[l + 1][k][i - m - 1]);
							}
						}
						if (k - j + 1 <= i) {
							DP[j][k][i] = Integer.MAX_VALUE;
						} else {
							DP[j][k][i] = min;
						}
					}
				}
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < K + 1; i++) {
				min = Math.min(min, DP[0][N - 1][i]);
			}

			System.out.println(min);
		}
	}

}

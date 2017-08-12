package WAP;

import java.util.Scanner;

public class TeamBuilding {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		System.out.println(solve(line));
	}

	public static long solve(String s) {
		char[] array = s.toCharArray();
		int n = array.length;
		int[][] DP = new int[n][n];
		int[] memR = new int[26];
		for (int i = 0; i < 26; i++) {
			memR[i] = -1;
		}

		for (int j = n - 1; j >= 2; j--) {

			int[] memL = new int[26];
			for (int i = 0; i < 26; i++) {
				memL[i] = -1;
			}
			for (int i = 0; i < j - 1; i++) {
				if (i == 1 && j == 3) {
					int x = 0;
				}
				if (array[i] == array[j]) {
					DP[i][j] = 1
							+ 2
							* ((i - 1 >= 0 && j + 1 < n) ? DP[i - 1][j + 1] : 0)
							+ (memL[array[j] - 'a'] != -1 ? DP[memL[array[j] - 'a']][j]
									: 0)
							+ (memR[array[i] - 'a'] != -1 ? DP[i][memR[array[i] - 'a']]
									: 0);
				} else {
					DP[i][j] = (memL[array[j] - 'a'] != -1 ? DP[memL[array[j] - 'a']][j]
							: 0)
							+ (memR[array[i] - 'a'] != -1 ? DP[i][memR[array[i] - 'a']]
									: 0);

					if (i - 1 >= 0 && j + 1 < n) {
						DP[i][j] += DP[i - 1][j + 1];
					}

				}
				memL[array[i] - 'a'] = i;
			}
			memR[array[j] - 'a'] = j;
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (i == 0 || i == n - 1) {
				count = (count + 1) % 1000000007;
				System.out.println(1);
			} else {
				count = (count + DP[i - 1][i + 1] + 1) % 1000000007;
//				System.out.println(DP[i - 1][i + 1] + 1);
			}
		}
		return count;
	}
}
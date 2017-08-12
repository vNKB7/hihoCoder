package wangyi;

import java.util.Scanner;

public class 小易喜欢的数列 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int k = in.nextInt();

			int[][] DP = new int[n][k + 1];
			for (int i = 1; i <= k; i++) {
				DP[0][i] = 1;
			}

			for (int i = 1; i < n; i++) {
				int sum = 0;
				for (int j = 1; j <= k; j++) {
					sum = (sum + DP[i - 1][j]) % 1000000007;
				}

				for (int j = 1; j <= k; j++) {
					DP[i][j] = sum;
					for (int l = j * 2; l <= k; l += j) {
						DP[i][j] = (DP[i][j] - DP[i - 1][l]) % 1000000007;
					}
				}
			}
			
			int count = 0;
			for(int i = 1; i <= k; i++){
				count = (count + DP[n-1][i]) % 1000000007;
			}
			System.out.println(count);
		}
	}

}

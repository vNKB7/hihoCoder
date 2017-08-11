package LintCode.DP;

public class Guess_Number_Game_II {

	public static void main(String[] args) {
		System.out.println(new Guess_Number_Game_II().getMoneyAmount(10));

	}

	public int getMoneyAmount(int n) {
		// Write your code here
		if (n < 2)
			return 0;

		int[][] DP = new int[n + 1][n + 1];

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++) {
				int a = j;
				int b = j + i - 1;
				DP[a][b] = Integer.MAX_VALUE;
				for (int k = a; k <= b; k++) {
					int cur = Math.max((k > a ? DP[a][k - 1] : 0) , (k < b ? DP[k + 1][b] : 0))+ k;
					if (cur < DP[a][b]) {
						DP[a][b] = cur;
					}
				}
			}
		}

		return DP[1][n];
	}
}

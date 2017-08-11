package LintCode.DP;

public class 房屋染色II {

	public static void main(String[] args) {
		int[][] costs = new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
		System.out.println(new 房屋染色II().minCostII(costs));
	}

	public int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0) {
			return 0;
		}

		int n = costs.length;
		int k = costs[0].length;

		int[][] DP = new int[n + 1][k];
		for (int i = 1; i <= n; i++) {
			int min_c = Integer.MAX_VALUE;
			int min_i = -1;
			int submin_c = Integer.MAX_VALUE;
			int submin_i = -1;

			for (int j = 0; j < k; j++) {
				if (DP[i - 1][j] > submin_c) {
					continue;
				} else if (DP[i - 1][j] < min_c) {
					submin_c = min_c;
					submin_i = min_i;
					min_c = DP[i - 1][j];
					min_i = j;
				} else if (DP[i - 1][j] >= min_c && DP[i - 1][j] < submin_c) {
					submin_c = DP[i - 1][j];
					submin_i = j;
				}
			}

			for (int j = 0; j < k; j++) {
				if (min_i != j) {
					DP[i][j] = min_c + costs[i - 1][j];
				} else {
					DP[i][j] = submin_c + costs[i - 1][j];
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			min = Math.min(min, DP[n][i]);
		}

		return min;
	}

}

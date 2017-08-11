package LintCode.DP;

public class 房屋染色 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minCost(int[][] costs) {
		// Write your code here
		if (costs == null || costs.length == 0) {
			return 0;
		}

		int[][] minCost = new int[costs.length][3];
		minCost[0][0] = costs[0][0];
		minCost[0][1] = costs[0][1];
		minCost[0][2] = costs[0][2];

		for (int i = 1; i < costs.length; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					minCost[i][0] = Integer.MAX_VALUE;
					if (j != k) {
						minCost[i][j] = Math.min(minCost[i][j],
								minCost[i - 1][k] + costs[i][j]);
					}
				}
			}
		}

		return Math
				.min(minCost[minCost.length - 1][0], Math.min(
						minCost[minCost.length - 1][1],
						minCost[minCost.length - 1][2]));
	}

}

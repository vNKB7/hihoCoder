package LintCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最小调整代价 {

	public static void main(String[] args) {
		System.out.println(new 最小调整代价().MinAdjustmentCost(new ArrayList<Integer>(Arrays.asList(1, 4, 2, 3)), 1));
	}

	public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
		// write your code here
		if (A == null || A.size() == 0) {
			return 0;
		}

		int[][] DP = new int[A.size() + 1][101];
		for (int i = 1; i <= A.size(); i++) {
			for (int j = 1; j <= 100; j++) {
				int minCost = Integer.MAX_VALUE;
				for (int k = Math.max(1, j - target); k <= Math.min(100, j
						+ target); k++) {
					minCost = Math.min(DP[i - 1][k] + Math.abs(j - A.get(i-1)), minCost);
				}
				DP[i][j] = minCost;
			}
		}

		int minCost = Integer.MAX_VALUE;
		for (int i = 1; i <= 100; i++) {
			minCost = Math.min(minCost, DP[DP.length - 1][i]);
		}
		
		return minCost;
	}
}

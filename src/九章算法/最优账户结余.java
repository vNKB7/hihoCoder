package 九章算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 最优账户结余 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 标准答案
	public int minTransfersTrue(int[][] transactions) {
		Map<Integer, Integer> debt = new HashMap<>();
		for (int[] t : transactions) {
			debt.put(t[0], debt.getOrDefault(t[0], 0) - t[2]);
			debt.put(t[1], debt.getOrDefault(t[1], 0) + t[2]);
		}

		int[] account = new int[debt.size()];
		int len = 0;

		for (int v : debt.values()) {
			if (v != 0) {
				account[len++] = v;
			}
		}

		if (len == 0)
			return 0;

		int[] dp = new int[1 << len];
		Arrays.fill(dp, Integer.MAX_VALUE / 2);
		for (int i = 1; i < dp.length; i++) {
			int sum = 0, count = 0;
			for (int j = 0; j < len; j++) {
				if ((1 << j & i) != 0) {
					sum += account[j];
					count++;
				}
			}

			if (sum == 0) {
				dp[i] = count - 1;
				for (int j = 1; j < i; j++) {
					if (((i & j) == j) && dp[j] + dp[i - j] < dp[i]) {
						dp[i] = dp[j] + dp[i - j];
					}
				}
			}
		}

		return dp[dp.length - 1];
	}

	public int minTransfers(int[][] transactions) {
		if (transactions == null || transactions.length == 0) {
			return -1;
		}

		Map<Integer, Integer> debt = new HashMap<>();
		for (int i = 0; i < transactions.length; i++) {
			debt.put(transactions[i][0],
					debt.getOrDefault(transactions[i][0], 0)
							- transactions[i][2]);
			debt.put(transactions[i][1],
					debt.getOrDefault(transactions[i][1], 0)
							+ transactions[i][2]);
		}

		int[] account = new int[debt.size()];
		int len = 0;

		for (int v : debt.values()) {
			account[len++] = v;
		}

		if (len == 0) {
			return 0;
		}

		int[] DP = new int[1 << len];
		Arrays.fill(DP, Integer.MAX_VALUE / 2);

		for (int i = 1; i < DP.length; i++) {
			int sum = 0;
			int count = 0;

			for (int j = 0; j < len; j++) {
				if (((1 << j) & i) != 0) {
					sum += account[j];
					count++;
				}
			}

			if (sum == 0) {
				DP[i] = count - 1;
				for (int j = 1; j < i; j++) {
					if (((j & i) == j) && DP[j] + DP[i - j] < DP[i]) {
						DP[i] = DP[j] + DP[i - j];
					}
				}
			}
		}

		return DP[DP.length - 1];
	}

}

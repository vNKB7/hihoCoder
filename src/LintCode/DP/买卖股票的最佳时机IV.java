package LintCode.DP;

public class 买卖股票的最佳时机IV {

	public static void main(String[] args) {
		System.out.println(new 买卖股票的最佳时机IV().maxProfit(100, new int[] { 1, 2,
				5, 1, 2, 4 ,1}));
	}

	// /*
	// * out of memory
	// */
	// public int maxProfit(int K, int[] prices) {
	// // write your code here
	// int[][][] DP = new int[prices.length+1][K+1][2];
	// for(int i = 0; i < K+1; i++){
	// DP[0][i][0] = Integer.MIN_VALUE/2;
	// DP[0][i][1] = Integer.MIN_VALUE/2;
	// }
	// DP[0][0][0] = 0;
	// DP[0][0][1] = 0;
	//
	// for(int i = 1; i <= prices.length; i++){
	// for(int j = 1; j <= K; j++){
	// DP[i][j][0] = Math.max(DP[i-1][j][0], DP[i-1][j-1][1] - prices[i-1]);
	// DP[i][j][1] = Math.max(DP[i-1][j][0] + prices[i-1], DP[i-1][j][1]);
	// }
	// }
	//
	// int max = 0;
	// for(int i = 1; i <= K; i++){
	// max = Math.max(max,
	// Math.max(DP[prices.length][i][0],DP[prices.length][i][1]));
	// }
	//
	// return max;
	// }

	// /*
	// * out of memory
	// */
	// public int maxProfit(int K, int[] prices) {
	// // write your code here
	// int[][][] DP = new int[2][K+1][2];
	// for(int i = 0; i < K+1; i++){
	// DP[0][i][0] = Integer.MIN_VALUE/2;
	// DP[0][i][1] = Integer.MIN_VALUE/2;
	// }
	// DP[0][0][0] = 0;
	// DP[0][0][1] = 0;
	//
	// int index = 1;
	// for(int i = 1; i <= prices.length; i++){
	// for(int j = 1; j <= K; j++){
	// DP[index][j][0] = Math.max(DP[1-index][j][0], DP[1-index][j-1][1] -
	// prices[i-1]);
	// DP[index][j][1] = Math.max(DP[1-index][j][0] + prices[i-1],
	// DP[1-index][j][1]);
	// }
	// index = 1 - index;
	// }
	//
	// int max = 0;
	// for(int i = 1; i <= K; i++){
	// max = Math.max(max,
	// Math.max(DP[prices.length%2][i][0],DP[prices.length%2][i][1]));
	// }
	//
	// return max;
	// }

	public int maxProfit(int K, int[] prices) {
		// write your code here
		if (K >= prices.length / 2) {
			int sum = 0;
			int start = 0;
			while (start < prices.length) {
				int i = start + 1;
				while (i < prices.length && prices[i] >= prices[i - 1]) {
					i++;
				}
				sum += prices[i-1] - prices[start];
				start = i;
			}
			return sum;
		} else {
			int[][][] DP = new int[2][K + 1][2];
			for (int i = 0; i < K + 1; i++) {
				DP[0][i][0] = Integer.MIN_VALUE / 2;
				DP[0][i][1] = Integer.MIN_VALUE / 2;
			}
			DP[0][0][0] = 0;
			DP[0][0][1] = 0;

			int index = 1;
			for (int i = 1; i <= prices.length; i++) {
				for (int j = 1; j <= K; j++) {
					DP[index][j][0] = Math.max(DP[1 - index][j][0],
							DP[1 - index][j - 1][1] - prices[i - 1]);
					DP[index][j][1] = Math.max(DP[1 - index][j][0]
							+ prices[i - 1], DP[1 - index][j][1]);
				}
				index = 1 - index;
			}

			int max = 0;
			for (int i = 1; i <= K; i++) {
				max = Math.max(max, Math.max(DP[prices.length % 2][i][0],
						DP[prices.length % 2][i][1]));
			}

			return max;
		}
	}

}

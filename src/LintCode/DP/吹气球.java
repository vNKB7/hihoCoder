package LintCode.DP;

public class 吹气球 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new 吹气球().maxCoins(new int[]{4,1,5,10}));
	}

	public int maxCoins(int[] nums) {
		// Write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[][] DP = new int[nums.length][nums.length];

		for (int i = 0; i < nums.length; i++) {
			DP[i][i] = (i > 0 ? nums[i - 1] : 1) * nums[i]
					* (i < nums.length - 1 ? nums[i + 1] : 1);
		}

		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				DP[j][i] = 0;
				for (int k = j; k <= i; k++) {
					DP[j][i] = Math.max(DP[j][i], (k > 0 ? DP[j][k - 1] : 0)
							+ (k < nums.length - 1 ? DP[k + 1][i] : 0)
							+ (j > 0 ? nums[j - 1] : 1) * nums[k]
							* (i < nums.length - 1 ? nums[i + 1] : 1));
				}
			}
		}

		return DP[0][nums.length-1];
	}
}

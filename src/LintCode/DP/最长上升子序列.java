package LintCode.DP;

public class 最长上升子序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestIncreasingSubsequence(int[] nums) {
		// write your code here

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int max = 0;

		int[] DP = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			DP[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					DP[i] = Math.max(DP[i], DP[j] + 1);
				}
			}
			max = Math.max(max, DP[i]);
		}

		return max;

	}

}

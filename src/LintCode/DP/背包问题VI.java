package LintCode.DP;

import java.util.Arrays;

public class 背包问题VI {

	public static void main(String[] args) {
		System.out.println(new 背包问题VI()
				.backPackVI(new int[] { 1, 2, 4, 8 }, 20));
	}

	// new int[] { 1, 2, 4, 8 }, 20
	// 51296

	
	// public int backPackVI_1(int[] nums, int target) { //wrong
	// // Write your code here
	// int[] DP = new int[target + 1];
	// DP[0] = 1;
	//
	// for (int i = 0; i < nums.length; i++) {
	// for (int j = nums[i]; j <= target; j++) {
	// DP[j] = DP[j] + DP[j - nums[i]];
	// }
	// }
	//
	// return DP[target];
	// }

//	public int backPackVI1(int[] nums, int target) {
//		// Write your code here
//		int[][] DP = new int[target + 1][nums.length + 1];
//
//		for (int i = 1; i <= target; i++) {
//			for (int j = 1; j <= nums.length; j++) {
//				if (nums[j - 1] == i) {
//					DP[i][j] = 1;
//				} else if (nums[j - 1] < i) {
//					for (int k = 0; k < nums.length; k++) {
//						DP[i][j] += DP[i - nums[j - 1]][k];
//					}
//				}
//			}
//		}
//
//		int count = 0;
//		for (int i = 1; i <= nums.length; i++) {
//			count += DP[target][i];
//		}
//
//		return count;
//	}
	
	public int backPackVI(int[] nums, int target) {
		// Write your code here
		int[] DP = new int[target + 1];
		DP[0] = 1;
		
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(nums[j] <= i){
					DP[i] += DP[i-nums[j]];
				}
			}
		}
		
		return DP[target];
	
	}
}

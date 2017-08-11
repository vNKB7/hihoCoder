package LintCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Largest_Divisible_Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		// Write your code here
		List<Integer> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		Arrays.sort(nums);
		int[][] count = new int[nums.length][2];

		for (int i = 0; i < nums.length; i++) {
			count[i][0] = 1;
			count[i][1] = -1;

			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					if (count[j][0] + 1 > count[i][0]) {
						count[i][0] = count[j][0] + 1;
						count[i][1] = j;
					}
				}
			}
		}

		int max = 0;
		int index = -1;

		for (int i = 0; i < count.length; i++) {
			if (count[i][0] > max) {
				max = count[i][0];
				index = i;
			}
		}

		while (index != -1) {
			result.add(nums[index]);
			index = count[index][1];
		}

		return result;
	}
}
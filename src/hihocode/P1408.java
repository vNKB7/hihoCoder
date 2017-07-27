package hihocode;

import java.util.Arrays;
import java.util.Scanner;

public class P1408 {
	static int[] mark = new int[4];
	static String result = "";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int[] nums = new int[4];
			for (int i = 0; i < 4; i++) {
				nums[i] = in.nextInt();
			}

			Arrays.sort(nums);
			if (helper(nums, 0, new int[4]))
				System.out.println(result);
			else{
				System.out.println("NOT POSSIBLE");
			}

		}
	}

	public static boolean helper(int[] nums, int depth, int[] chosen) {
		if (depth == 4) {
			int h = chosen[0] * 10 + chosen[1];
			int m = chosen[2] * 10 + chosen[3];
			if (h < 24 && m < 60) {
				result = String.format("%02d:%02d", h, m);
				return true;
			}
		}
		for (int i = 3; i >= 0; i--) {
			if (mark[i] != 1) {
				mark[i] = 1;
				chosen[depth] = nums[i];
				boolean flag = helper(nums, depth + 1, chosen);
				if (flag) {
					return true;
				}
				mark[i] = 0;
			}
		}

		return false;
	}
}

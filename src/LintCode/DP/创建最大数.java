package LintCode.DP;

import java.util.Arrays;

/*
 * 错的
 * 
 */
public class 创建最大数 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new 创建最大数().maxNumber(new int[] { 5,
				0, 2, 1, 0, 1, 0, 3, 9, 1, 2, 8, 0, 9, 8, 1, 4, 7, 3 },
				new int[] { 7, 6, 7, 1, 0, 1, 0, 5, 6, 0, 5, 0 }, 31)));
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		// Write your code here
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		for (int n : nums1) {
			sb1.append(n);
		}

		for (int n : nums2) {
			sb2.append(n);
		}

		int min = Math.max(0, k - nums2.length);
		int max = Math.min(nums1.length, k);
		String maxStr = new String();

		for (int i = min; i <= max; i++) {
			String result = merge(maxArray(sb1, i), maxArray(sb2, k - i));
			maxStr = maxStr.compareTo(result) > 0 ? maxStr : result;
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = maxStr.charAt(i) - '0';
		}

		return result;
	}

	public StringBuilder maxArray(StringBuilder sb, int k) {
		StringBuilder res = new StringBuilder();
		int remain = sb.length() - k;

		for (int i = 0; i < sb.length(); i++) {
			while (remain > 0 && res.length() > 0
					&& res.charAt(res.length() - 1) < sb.charAt(i)) {
				res.deleteCharAt(res.length() - 1);
				remain--;
			}
			res.append(sb.charAt(i));
		}
		return res;
	}

	public String merge(StringBuilder sb1, StringBuilder sb2) {
		StringBuilder res = new StringBuilder();
		int i = 0;
		int j = 0;
		while (i < sb1.length() && j < sb2.length()) {
			if (sb1.substring(i).compareTo(sb1.substring(j)) > 0) {
				res.append(sb2.charAt(i));
				i++;
			} else{
				res.append(sb1.charAt(j));
				j++;
			}
		}

		if (i != sb1.length()) {
			res.append(sb1.substring(i));
		}
		if (j != sb2.length()) {
			res.append(sb2.substring(j));
		}

		return res.toString();
	}

}

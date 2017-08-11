package LintCode.DP;

public class 交叉字符串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isInterleave(String s1, String s2, String s3) {
		// write your code here
		if (s1 == null || s2 == null || s3 == null) {
			return false;
		}

		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		if (s1.length() == 0) {
			return s2.equals(s3);
		}

		if (s2.length() == 0) {
			return s1.equals(s3);
		}

		boolean[][] DP = new boolean[s1.length() + 1][s2.length() + 1];
		DP[0][0] = true;

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				DP[i][j] = (i == 0 && j == 0)
						|| (i > 0 && DP[i - 1][j] && s1.charAt(i - 1) == s3
								.charAt(i + j - 1))
						|| (j > 0 && DP[i][j - 1] && s2.charAt(j - 1) == s3
								.charAt(i + j - 1));
			}
		}

		return DP[s1.length()][s2.length()];
	}
}

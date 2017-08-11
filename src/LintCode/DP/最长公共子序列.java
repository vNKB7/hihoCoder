package LintCode.DP;

public class 最长公共子序列 {

	public static void main(String[] args) {
		System.out.println(new 最长公共子序列().longestCommonSubsequence("asdfg", "aefhy"));
	}

	public int longestCommonSubsequence(String A, String B) {
		// write your code here
		
		if (A == null || A.length() == 0 || B == null || B.length() == 0) {
			return 0;
		}
		
		int[][] DP = new int[A.length()+1][B.length()+1];
		for(int i = 1; i <= A.length(); i++){
			for(int j = 1; j <= B.length(); j++){
				if(A.charAt(i-1) == B.charAt(j-1)){
					DP[i][j] = DP[i-1][j-1]+1;
				}else{
					DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j]);
				}
			}
		}
		
		return DP[A.length()][B.length()];
	}

}

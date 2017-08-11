package LintCode.DP;

import java.util.Arrays;

public class 分割回文串II {

	public static void main(String[] args) {
		System.out.println(new 分割回文串II().minCut("abbaaba"));
	}

//	/*
//	 * TLE
//	 */
//	public int minCut(String s) {
//		// write your code here
//		if (s == null || s.length() == 0) {
//			return 0;
//		}
//
//		int[][] DP = new int[s.length()][s.length()];
//
//		for (int i = 0; i < s.length(); i++) {
//			DP[i][i] = 1;
//			for (int j = i - 1; j >= 0; j--) {
//				DP[j][i] = Integer.MAX_VALUE / 2;
//				if (s.charAt(i) == s.charAt(j)) {
//					if (j + 1 > i - 1) {
//						DP[j][i] = 1;
//					} else {
//						if (DP[j + 1][i - 1] == 1) {
//							DP[j][i] = 1;
//						}
//					}
//				}
//
//				for (int k = j; k < i; k++) {
//					DP[j][i] = Math.min(DP[j][k] + DP[k + 1][i], DP[j][i]);
//				}
//			}
//		}
//
//		return DP[0][s.length() - 1] - 1;
//	}

	
	public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		boolean[][] pal = new boolean[s.length()][s.length()];
		for(int i = 0; i < s.length(); i++){
			for(int j = i; j >= 0; j--){
				if(s.charAt(i) == s.charAt(j)){
					if(j+1 > i-1){
						pal[j][i] = true;
					}else{
						pal[j][i] = pal[j+1][i-1];
					}
				}
			}
		}
		
		
		int[] DP = new int[s.length()];
		Arrays.fill(DP, Integer.MAX_VALUE/2);
		
		for(int i = 0; i < s.length(); i++){
			if(pal[0][i]){
				DP[i] = 1;
				continue;
			}
			
			for(int j = 0; j < i; j++){
				if(pal[j+1][i]){
					DP[i] = Math.min(DP[i], DP[j]+1);
				}
			}
		}
		
		return DP[s.length()-1]-1;
	}
}

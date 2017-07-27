package 编程练习赛19;

import java.util.Scanner;

public class 自信心 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = in.nextInt();
			
			for(int t = 0; t < T; t++){
				int N = in.nextInt();
				
				int[][]A = new int[N][5];
				
				for(int i = 0; i < N; i++){
					for(int j = 0; j < 5; j++){
						A[i][j] = in.nextInt();
					}
				}
				
				
			}
		}
	}

}

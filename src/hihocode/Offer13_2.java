package hihocode;

import java.util.Scanner;

/*
 * [Offer收割]编程练习赛13
 * 题目2 : 最大子矩阵
 */

public class Offer13_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int M = in.nextInt();
			int K = in.nextInt();
			in.nextLine();
			long[][] matrix = new long[N][M];
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j++){
					matrix[i][j] = in.nextInt();
				}
				in.nextLine();
			}
			
			long[][] sum = new long[N+1][M];
			for(int i = 0; i < N; i++){
				long[] temp = new long[M+1];
				for(int j = 0; j < M; j++){
					temp[j+1] = temp[j] + matrix[i][j];
					sum[i+1][j] = sum[i][j] + temp[j+1];
				}
			}
			long[][] sum_t = new long[N][M];
			for(int i = 0; i < N; i++){
				sum_t[i] = sum[i+1];
			}
			sum = sum_t;
			
			int[][][] store = new int[2][M][N];
			int index = 1;
			
			int max_area = 0;
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j ++){
					for(int k = i; k < N; k++){
						int start = Math.max(store[index][j][k], k > 1 ? store[1-index][j][k-1] : 0);
						boolean flag = false;
						for(int l = start; l < M; l++){
							long tmp = getSum(i,j,k,l,sum);
							int area = (k - i + 1) * (l - j + 1);
							if(tmp <= K){
								if(area > max_area)
									max_area = area;
							}else{
								store[index][j][k] = l;
								flag = true;
								break;
							}
						}
						if(!flag){
							store[index][j][k] = M;
						}
					}
					index = 1 - index;
				}
			}
			System.out.println(max_area);
			
		}
	}
	
	public static long getSum(int r1, int c1, int r2, int c2, long[][] sum){
        return sum[r2][c2] - (c1 > 0 ? sum[r2][c1-1] : 0) - (r1 > 0 ? sum[r1-1][c2] : 0) + ((r1 > 0 && c1 > 0) ? sum[r1-1][c1-1] : 0);

	}
	
}

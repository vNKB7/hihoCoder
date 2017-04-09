package hihocode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Offer13_3 {

	public static void main(String[] args) {
		List[][] map = new ArrayList[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				map[i][j] = nextStep(i+1, j+1);
			}
		}
		
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int R = in.nextInt();
			int C = in.nextInt();
			in.nextLine();
			
			int[][][] chess = new int[2][8][8];
			int index = 1;
			chess[index][R-1][C-1] = 1;
			
			for(int i = 0; i < N; i++){
				for(int j = 0; j < 8; j ++){
					for(int k = 0; k < 8; k++){
						if(chess[index][j][k] > 0){
							List<int[]> next = map[j][k];
							for(int l = 0; l < next.size(); l++){
								chess[1-index][next.get(l)[0]-1][next.get(l)[1]-1] += chess[index][j][k];
								chess[1-index][next.get(l)[0]-1][next.get(l)[1]-1] %= 1000000007;
							}
						}
					}
				}
				index = 1-index;
				chess[1-index] = new int[8][8];
			}
			
			int sum = 0;
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					sum += chess[index][i][j];
					sum %= 1000000007;
				}
			}
			System.out.println(sum);
		}
	}
	
	
	public static List<int[]> nextStep(int r, int c){
		List<int[]> result = new ArrayList<int[]>();
		int[][] move = new int[][]{{2, 1}, {2, -1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}};
		for(int i = 0; i < move.length; i++){
			if(r + move[i][0] <= 8 && r + move[i][0] > 0 && c + move[i][1] <= 8 && c + move[i][1] > 0){
				result.add(new int[]{r + move[i][0], c + move[i][1]});
			}
		}
		return result;
	}
}

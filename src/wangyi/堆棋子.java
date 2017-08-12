package wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 堆棋子 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] x = new int[n];
			int[] y = new int[n];
			Set<Integer> xPos = new HashSet<>();
			Set<Integer> yPos = new HashSet<>();
			
			for(int i = 0; i < n; i++){
				x[i] = in.nextInt();
				xPos.add(x[i]);
			}
			
			for(int i = 0; i < n; i++){
				y[i] = in.nextInt();
				yPos.add(y[i]);
			}
			
			List<int[]> candidate = new ArrayList<>();
			for(int i : xPos){
				for(int j : yPos){
					int[] can = new int[2];
					can[0] = i;
					can[1] = j;
					candidate.add(can);
				}
			}
			
			int[][] dis = new int[candidate.size()][n];
			for(int i = 0; i < candidate.size(); i++){
				for(int j = 0; j < n; j++){
					int[] can_pos = candidate.get(i);
					int distance = Math.abs(can_pos[0] - x[j]) + Math.abs(can_pos[1] - y[j]);
					dis[i][j] = distance;
				}
			}
			
			for(int i = 0; i < candidate.size(); i++){
				Arrays.sort(dis[i]);
				for(int j = 1; j < n; j++){
					dis[i][j] = dis[i][j-1] + dis[i][j];
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < candidate.size(); i++){
				min = Math.min(min, dis[i][0]);
			}
			System.out.print(min);
			
			if(n > 0){
				for(int i = 1; i < n; i++){
					min = Integer.MAX_VALUE;
					for(int j = 0; j < candidate.size(); j++){
						min = Math.min(min, dis[j][i]);
					}
					System.out.print(" " + min);
				}
			}
			
		}
	}
}

package hihocode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * #1175 : 拓扑排序·二
 */

public class P1175 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int M = in.nextInt();
			int K = in.nextInt();
			in.nextLine();

//			Map<Integer, List> map = new HashMap<>();
			List[] map = new List[N];
			int[][] count = new int[N][2];
			
			for(int i = 0; i < N; i++){
				map[i] = null;
			}
			
			int[] list = new int[K];
			for (int i = 0; i < K; i++) {
				list[i] = in.nextInt();
			}
			in.nextLine();

			for (int i = 0; i < M; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				in.nextLine();

				if (map[u-1] == null) {
					map[u-1] = new ArrayList<Integer>();
				}
				map[u-1].add(v);
				count[v - 1][0]++;
			}
			
			List<Integer> queue = new LinkedList<>();

			for(int i = 0; i < N; i++){
				if(count[i][0] == 0){
					queue.add(i+1);
				}
			}
			
			for (int i : list) {
				count[i - 1][1] = 1;
			}

			while (queue.size() > 0) {
				int u = queue.get(0);
				queue.remove(0);

				if (map[u-1] != null) {
					List<Integer> v_set = map[u-1];
					for (int v : v_set) {
						count[v - 1][0]--;
						count[v - 1][1] = (count[v - 1][1] + count[u - 1][1]) % 142857;

						if (count[v - 1][0] == 0) {
							queue.add(v);
						}
					}
				}
			}

			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum = (sum + count[i][1]) % 142857;
			}

			System.out.println(sum);
		}
	}
}

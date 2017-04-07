package hihocode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * 1121 : 二分图一•二分图判定
 */

public class P1121 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			int M = in.nextInt();
			in.nextLine();

			int[] color = new int[N];
			Map<Integer, Set<Integer>> map = new HashMap<>();
			List<Integer> queue = new ArrayList<>();

			for (int m = 0; m < M; m++) {
				int u = in.nextInt();
				int v = in.nextInt();
				in.nextLine();
				if (!map.containsKey(u)) {
					map.put(u, new HashSet<Integer>());
				}
				map.get(u).add(v);
				if (!map.containsKey(v)) {
					map.put(v, new HashSet<Integer>());
				}
				map.get(v).add(u);

			}

			boolean wrong = false;
			int count = 0;
			while (!wrong && count < N) {
				if (queue.size() == 0) {
					for (int i = 0; i < N; i++) {
						if (color[i] == 0) {
							if (map.containsKey(i + 1)) {
								color[i] = 1;
								count += 1;
								queue.add(i + 1);
								break;
							}else{
								color[i] = 2;
								count += 1;
							}
						}
					}
				}

				Set<Integer> new_queue = new HashSet<Integer>();
				while (queue.size() > 0) {
					int u1 = queue.get(queue.size() - 1);
					queue.remove(queue.size() - 1);
					/*
					 * 第一次WA是错在这里。有孤立点存在使得map.get(u1)异常
					 */
					for (int v1 : map.get(u1)) {
						if (color[v1 - 1] == 0) {
							color[v1 - 1] = -color[u1 - 1];
							count++;
							new_queue.add(v1);
						} else if (color[v1 - 1] == color[u1 - 1]) {
							wrong = true;
							break;
						}
					}
				}
				queue = new ArrayList<Integer>(new_queue);
			}
			if (wrong) {
				System.out.println("Wrong");
			} else {
				System.out.println("Correct");
			}

		}
	}
}

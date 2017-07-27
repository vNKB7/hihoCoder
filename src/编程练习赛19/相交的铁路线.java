package 编程练习赛19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 相交的铁路线 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = in.nextInt();
			for (int t = 0; t < T; t++) {
				int N = in.nextInt();
				int M = in.nextInt();

				List<List<Integer>> path = new ArrayList<>(N+1);
				for (int i = 0; i < N+1; i++) {
					path.add(new ArrayList<Integer>());
				}

				for (int i = 0; i < N - 1; i++) {
					int src = in.nextInt();
					int dest = in.nextInt();
					path.get(src).add(dest);
					path.get(dest).add(src);
				}

				for (int m = 0; m < M; m++) {
					int x1 = in.nextInt();
					int y1 = in.nextInt();
					int x2 = in.nextInt();
					int y2 = in.nextInt();
					
					Set<Integer> s = new HashSet<>();
					s.add(x1);
					Set<Integer> set1 = DFS(path, x1, y1, s);
					s = new HashSet<>();
					s.add(x2);
					Set<Integer> set2 = DFS(path, x2, y2, s);
					set1.retainAll(set2);

					if (set1.size() > 0)
						System.out.println("YES");
					else
						System.out.println("NO");
				}
			}
		}
		in.close();
	}

	public static Set<Integer> DFS(List<List<Integer>> path, int src, int dest,
			Set<Integer> visited) {
		if (src == dest) {
			return new HashSet<Integer>(visited);
		}

		List<Integer> nexts = path.get(src);
		for (int next : nexts) {
			if(visited.contains(next))
				continue;
			visited.add(next);
			if (next == dest) {
				return visited;
			} else {
				Set<Integer> rt = DFS(path, next, dest, visited);
				if (rt != null) {
					return visited;
				}
			}
			visited.remove(next);
		}
		return null;
	}
}

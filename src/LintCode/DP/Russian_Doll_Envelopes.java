package LintCode.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Russian_Doll_Envelopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = { { 15, 8 }, { 2, 20 }, { 2, 14 }, { 4, 17 },
				{ 8, 19 }, { 8, 9 }, { 5, 7 }, { 11, 19 }, { 8, 11 },
				{ 13, 11 }, { 2, 13 }, { 11, 19 }, { 8, 11 }, { 13, 11 },
				{ 2, 13 }, { 11, 19 }, { 16, 1 }, { 18, 13 }, { 14, 17 },
				{ 18, 19 } };
		System.out.println(new Russian_Doll_Envelopes().maxEnvelopes(array));
	}
	/*
	 * out of memory
	 */
	public int maxEnvelopes(int[][] envelopes) {
		// Write your code here
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}

		HashMap<String, Integer> index = new HashMap<>();
		
//		HashMap<Integer, Set<Integer>> adj = new HashMap<>();
		List<int[]> newEnvelopes = new ArrayList<>();

		for (int i = 0; i < envelopes.length; i++) {
			if (!index.containsKey(envelopes[i][0] + "-" + envelopes[i][1])) {
				index.put(envelopes[i][0] + "-" + envelopes[i][1], index.size());
				newEnvelopes.add(new int[] { envelopes[i][0], envelopes[i][1] });
			} else {
				continue;
			}
		}

		boolean[][] adj = new boolean[newEnvelopes.size()][newEnvelopes.size()];
		int[] indegree = new int[index.size()];

		for (int i = 0; i < newEnvelopes.size(); i++) {
			for (int j = i + 1; j < newEnvelopes.size(); j++) {
				int res = compare(newEnvelopes.get(i), newEnvelopes.get(j));
				if (res == 0 || res == -1) {
					continue;
				} else if (res == 1) {
					int i_index = index.get(newEnvelopes.get(i)[0] + "-"
							+ newEnvelopes.get(i)[1]);
					int j_index = index.get(newEnvelopes.get(j)[0] + "-"
							+ newEnvelopes.get(j)[1]);
					indegree[i_index]++;
					adj[j_index][i_index] = true;
				} else if (res == 2) {
					int i_index = index.get(newEnvelopes.get(i)[0] + "-"
							+ newEnvelopes.get(i)[1]);
					int j_index = index.get(newEnvelopes.get(j)[0] + "-"
							+ newEnvelopes.get(j)[1]);
					indegree[j_index]++;
					adj[i_index][j_index] = true;
				}
			}
		}

		List<Integer> outer = new ArrayList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				outer.add(i);
			}
		}

		int max = 0;
		while (outer.size() > 0) {
			List<Integer> next_outer = new ArrayList<>();
			for (int out : outer) {
				for(int i = 0; i < adj.length; i++){
					if(adj[out][i]){
						indegree[i]--;
						if (indegree[i] == 0) {
							next_outer.add(i);
						}
					}
				}
			}
			outer = next_outer;
			max++;
		}

		return max;
	}

	public int compare(int[] o1, int[] o2) {
		if (o1[0] == o2[0] && o1[1] == o2[1]) {
			return 0; // equals
		} else if (o1[0] > o2[0] && o1[1] > o2[1]) {
			return 1; // o1 > o2
		} else if (o1[0] < o2[0] && o1[1] < o2[1]) {
			return 2; // o1 < o2;
		} else {
			return -1; // cannt compare
		}
	}

}

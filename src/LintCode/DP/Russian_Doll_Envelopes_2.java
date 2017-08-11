package LintCode.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Russian_Doll_Envelopes_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = { { 5, 4 }, { 6, 4 }, { 2, 3 }, { 6, 7 } };
		System.out.println(new Russian_Doll_Envelopes_2().maxEnvelopes(array));
	}

	public int maxEnvelopes(int[][] envelopes) {
		List<int[]> newEnvelopes = new ArrayList<>();
		for (int i = 0; i < envelopes.length; i++) {
			newEnvelopes.add(envelopes[i]);
		}

		Collections.sort(newEnvelopes, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] != o2[0] ? (o1[0] - o2[0]) : (o2[1] - o1[1]);
			}
		});

		List<Integer> DP = new ArrayList<>();
		for (int i = 0; i < newEnvelopes.size(); i++) {
			int left = 0;
			int right = DP.size();
			int t = newEnvelopes.get(i)[1];
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (DP.get(mid) < t) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}

			if (right >= DP.size()) {
				DP.add(t);
			} else {
				DP.set(right, t);
			}
		}

		return DP.size();
	}

}

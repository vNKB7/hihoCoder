package hihocode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class P1509 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			BitSet[] bs = new BitSet[N];
			int highest = 0;
			for (int i = 0; i < N; i++) {
				long a = in.nextLong();
				bs[i] = new BitSet(60);
				for (int j = 0; j < 60; j++) {
					long b = a & 1L;
					if (b != 0) {
						bs[i].set(j);
						if (j > highest)
							highest = j;
					}
					a = a >> 1;
				}
			}
			long counts = 1L;
			for (int i = 0; i < 59 - highest; i++) {
				counts *= 2;
			}

			List<int[]> queue = new ArrayList<>();
			queue.add(new int[] { 0, N - 1 });

			for (int i = highest; i >= 0; i--) {
				List<int[]> new_queue = new ArrayList<>();
				int state = 0;
				for (int j = 0; j < queue.size(); j++) {
					int[] pair = queue.get(j);
					int flip = 0;
					int split_point = 0;
					boolean cur = bs[pair[0]].get(i);
					if (pair[0] == pair[1]) {
						continue;
					}
					for (int k = pair[0] + 1; k <= pair[1]; k++) {
						if (cur != bs[k].get(i)) {
							cur = !cur;
							flip++;
							if (flip == 1) {
								split_point = k - 1;
							}
							if (flip > 1)
								break;
						}
					}

					if (flip == 0) {
						new_queue.add(new int[] { pair[0], pair[1]});
					} else if (flip == 1) {
						new_queue.add(new int[] { pair[0], split_point });
						new_queue.add(new int[] { split_point+1, pair[1] });
						int s = bs[pair[0]].get(i) ? 1 : -1;
						if (state == 0) {
							state = s;
						} else if (state != s) {
							counts = 0;
							break;
						}
					} else {
						counts = 0;
						break;
					}
				}
				if (state == 0) {
					counts *= 2;
				}
				queue = new_queue;
			}
			System.out.println(counts);
		}
	}
}

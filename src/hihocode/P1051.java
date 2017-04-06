package hihocode;

import java.util.Scanner;

public class P1051 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int total = in.nextInt();

			for (int i = 0; i < total; i++) {
				int N = in.nextInt();
				int M = in.nextInt();
				int[] a = new int[N + 2];
				for (int j = 1; j < N + 1; j++) {
					a[j] = in.nextInt();
				}
				if (M >= N) {
					System.out.println(100);
					continue;
				}
				int max = 0;
				for (int j = 1; j < N - M + 2; j++) {
					if (a[j + M] - a[j - 1] - 1 > max) {
						max = a[j + M] - a[j - 1] - 1;
					}
				}
				System.out.println(max);
			}

		}
	}
}

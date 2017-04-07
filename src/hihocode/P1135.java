package hihocode;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 1135 : Magic Box
 */

public class P1135 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int[] differ = { in.nextInt(), in.nextInt(), in.nextInt() };
			Arrays.sort(differ);
			// int x = in.nextInt();
			// int y = in.nextInt();
			// int z = in.nextInt();
			in.nextLine();
			String str = in.nextLine();
			int max_length = 0;
			int cr = 0, cy = 0, cb = 0;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				switch (c) {
				case 'R':
					cr += 1;
					break;
				case 'Y':
					cy += 1;
					break;
				case 'B':
					cb += 1;
					break;
				}
				if (max_length < cr + cy + cb) {
					max_length = cr + cy + cb;
				}
				if (vanish(cr, cy, cb, differ)) {
					cr = cy = cb = 0;
				}
			}
			System.out.println(max_length);
		}
	}

	public static boolean vanish(int cr, int cy, int cb, int[] differ) {
		int[] list = { cr > cy ? cr - cy : cy - cr,
				cy > cb ? cy - cb : cb - cy, cb > cr ? cb - cr : cr - cb };
		Arrays.sort(list);
		if (list[0] == differ[0] && list[1] == differ[1]
				&& list[2] == differ[2]) {
			return true;
		} else {
			return false;
		}

	}
}

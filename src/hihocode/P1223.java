package hihocode;

import java.util.Scanner;

public class P1223 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			in.nextLine();
			int[] op = new int[N];
			int[] C = new int[N];
			for (int i = 0; i < N; i++) {
				String str = in.nextLine().trim();
				String[] piece = str.split(" ");
				if (piece[1].length() == 1) {
					if (piece[1].charAt(0) == '=') {
						op[i] = 0;
					} else if (piece[1].charAt(0) == '<') {
						op[i] = 1;
					} else if (piece[1].charAt(0) == '>') {
						op[i] = 2;
					}
				} else if (piece[1].charAt(0) == '<') {
					op[i] = 3;
				} else {
					op[i] = 4;
				}
				C[i] = Integer.parseInt(piece[2]) * 2;
			}

			int max_cnt = 0;
			for (int i = -1; i <= 2001; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					switch (op[j]) {
					case 0:
						if (i == C[j])
							cnt++;
						break;
					case 1:
						if (i < C[j])
							cnt++;
						break;
					case 2:
						if (i > C[j])
							cnt++;
						break;
					case 3:
						if (i <= C[j])
							cnt++;
						break;
					case 4:
						if (i >= C[j])
							cnt++;
						break;
					default:
						break;
					}
				}
				if(cnt > max_cnt)
					max_cnt = cnt;
			}

			System.out.println(max_cnt);
		}
	}
}

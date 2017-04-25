package hihocode;

import java.util.Scanner;

/*
 * #1304 : 搜索一·24点
 */

public class P1304 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			for (int n = 0; n < N; n++) {
				int[] num = new int[4];
				boolean[] used = new boolean[4];
				for (int i = 0; i < 4; i++) {
					num[i] = in.nextInt();
				}
				if(getNum(num, used, new int[4], 0)){
					System.out.println("Yes");
				}else{
					System.out.println("No");
				}
			}
		}
	}

	public static boolean getNum(int[] num, boolean[] used, int[] chosen,
			int depth) {
		if (depth == 4) {
			int[] op = new int[4];
			return calculate(chosen, op, 0);
		} else {
			for (int i = 0; i < 4; i++) {
				if (!used[i]) {
					chosen[depth] = num[i];
					used[i] = true;
					if (getNum(num, used, chosen, depth + 1)) {
						return true;
					}
					used[i] = false;
				}
			}
		}

		return false;
	}

	public static boolean calculate(int[] chosen, int[] op, int depth) {
		if (depth == 3) {
			if (operator(
					op[2],
					operator(op[1], operator(op[0], chosen[0], chosen[1]),
							chosen[2]), chosen[3]) == 24)
				return true;
			if (operator(op[1], operator(op[0], chosen[0], chosen[1]),
					operator(op[2], chosen[2], chosen[3])) == 24)
				return true;

		} else {
			for (int i = 0; i < 6; i++) {
				op[depth] = i;
				if (calculate(chosen, op, depth + 1)) {
					return true;
				}
			}
		}

		return false;
	}

	public static double operator(int op, double a, double b) {
		double result = 0.0;
		switch (op) {
		case 0:
			result = a + b;
			break;
		case 1:
			result = a - b;
			break;
		case 2:
			result = b - a;
			break;
		case 3:
			result = a * b;
			break;
		case 4:
			result = a / b;
			break;
		case 5:
			result = b / a;
			break;
		}
		return result;
	}
}

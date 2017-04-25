package hihocode;

import java.util.Scanner;

/*
 * #1268 : 九宫
 */

public class P1268 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int[][] matrix = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					int a = in.nextInt();
					matrix[i][j] = matrix[i][j] > a ? matrix[i][j] : a;
					if (a != 0) {
						if ((i == 0 || i == 2) && (j == 0 || j == 2)) {
							matrix[2 - i][2 - j] = 10 - a;
						} else if ((i == 0 || i == 2) && j == 1) {
							matrix[2 - i][1] = 10 - a;
						} else if (i == 1 && (j == 0 || j == 2)) {
							matrix[1][2 - j] = 10 - a;
						}
					}
				}
			}
			matrix[1][1] = 5;

			int cnt = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++)
					if (matrix[i][j] != 0)
						cnt++;
			}
			if (cnt <= 3) {
				System.out.println("Too Many");
			} else {
				if (matrix[0][0] + matrix[0][2] + matrix[2][0] + matrix[2][2] == 0) {
					int sum_of_neighbor = matrix[0][1] + matrix[1][0];
					if (sum_of_neighbor == 8)
						matrix[0][0] = 6;
					else if (sum_of_neighbor == 16)
						matrix[0][0] = 2;
					else if (sum_of_neighbor == 4)
						matrix[0][0] = 8;
					else if (sum_of_neighbor == 12)
						matrix[0][0] = 4;
					cnt++;
				}
				int c = 0;
				int s = 0;
				int z_i = 0;
				while (cnt != 9) {
					c = 0;
					s = 0;
					for (int i = 0; i < 3; i++) {
						s += matrix[0][i];
						if (matrix[0][i] == 0) {
							c++;
							z_i = i;
						}
					}
					if (c == 1) {
						matrix[0][z_i] = 15 - s;
						cnt++;
					}

					c = 0;
					s = 0;
					for (int i = 0; i < 3; i++) {
						s += matrix[2][i];
						if (matrix[2][i] == 0) {
							c++;
							z_i = i;
						}
					}
					if (c == 1) {
						matrix[2][z_i] = 15 - s;
						cnt++;
					}

					c = 0;
					s = 0;
					for (int i = 0; i < 3; i++) {
						s += matrix[i][0];
						if (matrix[i][0] == 0) {
							c++;
							z_i = i;
						}
					}
					if (c == 1) {
						matrix[z_i][0] = 15 - s;
						cnt++;
					}

					c = 0;
					s = 0;
					for (int i = 0; i < 3; i++) {
						s += matrix[i][2];
						if (matrix[i][2] == 0) {
							c++;
							z_i = i;
						}
					}
					if (c == 1) {
						matrix[z_i][2] = 15 - s;
						cnt++;
					}
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++)
						if (j == 2)
							System.out.println(matrix[i][j]);
						else
							System.out.print(matrix[i][j] + " ");
				}
			}
		}
	}
}

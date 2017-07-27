package hihocode;

import java.util.Scanner;

public class P1404 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = in.nextInt();
			in.nextLine();
			for (int t = 0; t < T; t++) {
				char[][] board = new char[15][15];
				for (int i = 0; i < 15; i++) {
					String line = in.nextLine();
					for (int j = 0; j < 15; j++) {
						board[i][j] = line.charAt(j);
					}
				}

				boolean white_win = false;
				boolean black_win = false;

				for (int i = 0; i < 15; i++) {
					for (int j = 0; j < 15; j++) {
						if (white_win && black_win)
							break;

						if (board[i][j] != '.') {
							char c = board[i][j];
							if (white_win && c == 'W' || black_win && c == 'B') {
								continue;
							}
							// horizontal
							int count = 0;
							if (i == 0 || board[i - 1][j] != c) {
								for (int k = 1; k < 5; k++) {
									if (i + k < 15 && board[i + k][j] == c) {
										count++;
									} else {
										break;
									}
								}
							}
							if (count == 4) {
								if (c == 'W')
									white_win = true;
								else
									black_win = true;
							}

							// vertical
							count = 0;
							if (j == 0 || board[i][j - 1] != c) {
								for (int k = 1; k < 5; k++) {
									if (j + k < 15 && board[i][j + k] == c) {
										count++;
									} else {
										break;
									}
								}
							}
							if (count == 4) {
								if (c == 'W')
									white_win = true;
								else
									black_win = true;
							}

							// diagonal-left to right
							count = 0;
							if (i == 0 || j == 0 || board[i - 1][j - 1] != c) {
								for (int k = 1; k < 5; k++) {
									if (i + k < 15 && j + k < 15
											&& board[i + k][j + k] == c) {
										count++;
									} else {
										break;
									}
								}
							}
							if (count == 4) {
								if (c == 'W')
									white_win = true;
								else
									black_win = true;
							}

							// diagonal-right to left
							count = 0;
							if (i == 0 || j == 14 || board[i - 1][j + 1] != c) {
								for (int k = 1; k < 5; k++) {
									if (i + k < 15 && j - k >= 0
											&& board[i + k][j - k] == c) {
										count++;
									} else {
										break;
									}
								}
							}
							if (count == 4) {
								if (c == 'W')
									white_win = true;
								else
									black_win = true;
							}
						}
					}
				}
				
				if(black_win && white_win)
					System.out.println("Both");
				else if(!black_win && !white_win)
					System.out.println("None");
				else if(black_win)
					System.out.println("Black");
				else
					System.out.println("White");
			}
		}
	}
}

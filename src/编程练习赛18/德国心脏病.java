package 编程练习赛18;

import java.util.Scanner;

public class 德国心脏病 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int k = in.nextInt();
			in.nextLine();

			int[] cards = new int[n];
			for (int i = 0; i < n; i++) {
				cards[i] = 10000000;
			}

			int deskCards = 0;
			int[][] curCard = new int[n][6];// curCard[i][5] 0 : none 1 : f 2 :
											// a
			int[] fruit = new int[4];
			int[] animal = new int[3];

			int player = 0;

			for (int i = 0; i < k; i++) {
				String step = in.nextLine();
				String[] piece = step.split(" ");

				if (piece[0].equals("Ring")) {
					int curPlay = Integer.parseInt(piece[1]);
					boolean flag = false;
					for (int j = 0; j < 4; j++) {
						if (fruit[j] == 5) {
							flag = true;
							break;
						}
					}

					if (!flag && animal[0] > 0 && fruit[3] == 0
							&& (fruit[0] + fruit[1] + fruit[2] > 0)) {
						flag = true;
					}

					if (!flag && animal[1] > 0 && fruit[1] == 0
							&& (fruit[0] + fruit[2] + fruit[3] > 0)) {
						flag = true;
					}

					if (!flag && animal[2] > 0
							&& (fruit[0] + fruit[1] + fruit[2] + fruit[3] > 0)) {
						flag = true;
					}

					if (flag) {
						cards[curPlay] += deskCards;

						deskCards = 0;
						curCard = new int[n][6];
						fruit = new int[4];
						animal = new int[3];
					} else {
						cards[curPlay] -= n - 1;
						for (int j = 0; j < n; j++) {
							if (j != curPlay) {
								cards[j]++;
							}
						}
					}

					player = curPlay;
				} else {
					if (piece[0].equals("Fruit")) {
						int[] fCount = new int[4];

						int fNum = Integer.parseInt(piece[1]);
						for (int j = 0; j < fNum; j++) {
							fCount[Integer.parseInt(piece[2 + j])]++;
						}

						for (int j = 0; j < 4; j++) {
							fruit[j] = fruit[j] + fCount[j];
						}

						if (curCard[player][5] == 0) {

						} else if (curCard[player][5] == 1) {
							for (int j = 0; j < 4; j++) {
								fruit[j] -= curCard[player][j];
							}
						} else if (curCard[player][5] == 2) {
							animal[curCard[player][4]]--;
						}
						
						curCard[player][5] = 1;

						for (int j = 0; j < 4; j++) {
							curCard[player][j] = fCount[j];
						}

						cards[player]--;
						deskCards++;
						player = (player + 1) % n;
					} else if (piece[0].equals("Animal")) {
						int ani = Integer.parseInt(piece[1]);
						animal[ani]++;
						
						if (curCard[player][5] == 0) {

						} else if (curCard[player][5] == 1) {
							for (int j = 0; j < 4; j++) {
								fruit[j] -= curCard[player][j];
							}
						} else if (curCard[player][5] == 2) {
							animal[curCard[player][4]]--;
						}
						
						curCard[player][5] = 2;
						curCard[player][4] = ani;
						
						cards[player]--;
						deskCards++;
						player = (player + 1) % n;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				System.out.println(cards[i]);
			}
		}
	}
}

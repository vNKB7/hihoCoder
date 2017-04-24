package hihocode;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class P1137 {

	public static void main(String[] args) {
//		FileReader fin = null;
//		try {
//			fin=new FileReader("P1137_data.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Scanner in = new Scanner(fin);
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int X = in.nextInt();
			int Y = in.nextInt();
			int B = in.nextInt();
			in.nextLine();
			int male = 0, female = 0;
			int m_sum = 0, f_sum = 0;
			int[][] fm = new int[101][1001];
			int[][] ff = new int[101][1001];
			long[][][] gm = new long[101][1001][2];
			long[][][] gf = new long[101][1001][2];
			for (int j = 0; j < 101; j++) {
				for (int k = 0; k < 1001; k++) {
					fm[j][k] = -1;
					ff[j][k] = -1;
				}
			}
			fm[0][0] = 0;
			ff[0][0] = 0;

			for (int n = 0; n < N; n++) {
				int g = in.next().charAt(0);
				int v = in.nextInt();
				int s = in.nextInt();
				in.nextLine();

				if (g == 'M') {
					male++;
					m_sum += s;

					int x = male < X ? male : X;
					int b = m_sum < B ? m_sum : B;

					for (int j = x; j >= 1; j--) {
						for (int k = b; k >= s; k--) {
							if (fm[j - 1][k - s] >= 0) {
								if (fm[j][k] < fm[j - 1][k - s] + v) {
									fm[j][k] = fm[j - 1][k - s] + v;
									gm[j][k][0] = gm[j - 1][k - s][0];
									gm[j][k][1] = gm[j - 1][k - s][1];
									if (n < 50) {
										gm[j][k][0] |= (1L << n);
									} else {
										gm[j][k][1] |= (1L << (n - 50));
									}
								}
							}
						}
					}
				} else {
					female++;
					f_sum += s;

					int y = female < Y ? female : Y;
					int b = f_sum < B ? f_sum : B;

					for (int j = y; j >= 1; j--) {
						for (int k = b; k >= s; k--) {
							if (ff[j - 1][k - s] >= 0) {
								if (ff[j][k] < ff[j - 1][k - s] + v) {
									ff[j][k] = ff[j - 1][k - s] + v;
									gf[j][k][0] = gf[j - 1][k - s][0];
									gf[j][k][1] = gf[j - 1][k - s][1];
									if (n < 50) {
										gf[j][k][0] |= 1L << n;
									} else {
										gf[j][k][1] |= 1L << (n - 50);
									}
								}
							}
						}
					}
				}
			}

//			for (int j = 0; j <= X; j++) {
//				for (int k = 0; k <= Math.max(B, m_sum); k++) {
//					System.out.print(fm[j][k] + " ");
//				}
//				System.out.println();
//			}
//
//			for (int j = 0; j <= Y; j++) {
//				for (int k = 0; k <= Math.max(B, f_sum); k++) {
//					System.out.print(ff[j][k] + " ");
//				}
//				System.out.println();
//			}

//			int m_index = -1;
//			int f_index = -1;
			int max_v = -1;
			int min_b = -1;

			int b_m = B > m_sum ? B : m_sum;
			int b_f = B > f_sum ? B : f_sum;
										
			long[] idx = new long[2];
			
			for (int i = 0; i <= b_m; i++) {
				if (fm[X][i] < 0)
					continue;

				for (int j = 0; j <= b_f; j++) {
					if (ff[Y][j] < 0)
						continue;

					if (i + j <= B && fm[X][i] + ff[Y][j] > max_v
							|| fm[X][i] + ff[Y][j] == max_v && i + j < min_b) {
						max_v = fm[X][i] + ff[Y][j];
						min_b = i + j;
//						m_index = i;
//						f_index = j;
						idx[0] = gm[X][i][0] | gf[Y][j][0]; 
						idx[1] = gm[X][i][1] | gf[Y][j][1]; 
//						System.out.println(max_v + " " + min_b + " " + idx[0]
//								+ " " + idx[1]);
					}else if(fm[X][i] + ff[Y][j] == max_v && i + j == min_b){
						long idx0 = gm[X][i][0] | gf[Y][j][0]; 
						long idx1 = gm[X][i][1] | gf[Y][j][1];  
						if(idx[0] > idx0){
							idx[0] = idx0;
							idx[1] = idx1;
						}else if(idx[0] == idx0 && idx[1] > idx1){
							idx[0] = idx0;
							idx[1] = idx1;
						}
					}
				}
			}
			System.out.println(max_v + " " + min_b);

//			System.out.println();
//			System.out.println(idx[0]);
//			System.out.println(idx[1]);
//			System.out.println();

			for (int i = 0; i < N; i++) {
				if (i < 50) {
					long c = idx[0] & 1L;
					idx[0] = idx[0] >> 1;
					if (c > 0) {
						System.out.print((i + 1) + " ");
					}
				} else {
					long c = idx[1] & 1L;
					idx[1] = idx[1] >> 1;
//					System.out.println(i + " " + c1 + " " + c2);
					if (c > 0) {
						System.out.print((i + 1) + " ");
					}
				}
			}
			System.out.println();
		}
	}
}

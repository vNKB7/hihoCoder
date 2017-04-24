package hihocode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.BitSet;

public class hiho147 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int[][] matrix = new int[5][N];
			int[][] rev_matrix = new int[5][N];
			BitSet[][] bs = new BitSet[5][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 5; j++) {
					matrix[j][i] = in.nextInt() - 1;
					rev_matrix[j][matrix[j][i]] = i;
				}
			}

			for(int i = 0; i < 5; i++){
				for(int j = 0; j < N; j++){
					if(j == 0)
						bs[i][j] = new BitSet(N);
					else{
						bs[i][j] = (BitSet) bs[i][j-1].clone();
						bs[i][j].set(rev_matrix[i][j-1]);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				BitSet bm = new BitSet(N);
				bm.flip(0,bm.size());
				for (int j = 0; j < 5; j++) {
					int index = matrix[j][i];
					bm.and(bs[j][index]);
				}
				System.out.println(bm.cardinality());
			}
		}
	}
}

// // TLE
// public class hiho147 {
// public static void main(String[] args) {
// Scanner in = new Scanner(System.in);
// while (in.hasNext()) {
// int N = in.nextInt();
// int[][] matrix = new int[5][N];
// int[][] tmp = new int[5][N];
// Map<Integer, Integer>[] hm = new HashMap[5];
// Map<Integer, Integer>[] rev_hm = new HashMap[5];
//
//
// for (int i = 0; i < 5; i++) {
// hm[i] = new HashMap<>();
// rev_hm[i] = new HashMap<>();
// }
//
// for (int i = 0; i < N; i++) {
// for (int j = 0; j < 5; j++) {
// matrix[j][i] = in.nextInt();
// hm[j].put(matrix[j][i], i);
// }
// }
//
// for (int i = 0; i < 5; i++) {
// tmp[i] = matrix[i].clone();
// Arrays.sort(tmp[i]);
// }
//
// for (int i = 0; i < 5; i++) {
// for (int j = 0; j < N; j++) {
// rev_hm[i].put(tmp[i][j], j);
// }
// }
//
// for (int i = 0; i < N; i++) {
// BitSet[] bm = new BitSet[5];
// for (int j = 0; j < 5; j++) {
// bm[j] = new BitSet(N);
// int index = rev_hm[j].get(matrix[j][i]);
// for (int k = 0; k < index; k++) {
// bm[j].set(hm[j].get(tmp[j][k]));
// }
// bm[0].and(bm[j]);
// }
// System.out.println(bm[0].cardinality());
// }
// }
// }
// }

// // TLE
// public class hiho147 {
//
// public static void main(String[] args) {
// Scanner in = new Scanner(System.in);
// while (in.hasNext()) {
// int N = in.nextInt();
// in.nextLine();
// int[][] matrix = new int[N][5];
//
// for (int i = 0; i < N; i++) {
// for (int j = 0; j < 5; j++) {
// matrix[i][j] = in.nextInt();
// }
// }
//
// for(int i = 0; i < N; i++){
// int count = 0;
// for(int j = 0; j < N; j++){
// int t = 0;
// for(int k = 0; k < 5; k++){
// if(matrix[i][k] > matrix[j][k])
// t++;
// }
// if(t == 5)
// count ++;
// }
// System.out.println(count);
// }
//
// }
// }
// }

// //WA
// public class hiho147 {
// public static void main(String[] args) {
// Scanner in = new Scanner(System.in);
// while (in.hasNext()) {
// int N = in.nextInt();
// int[][] matrix = new int[5][N];
// int[][] tmp = new int[5][N];
// Map<Integer, Integer>[] hm = new HashMap[5];
//
// for (int i = 0; i < 5; i++) {
// hm[i] = new HashMap<>();
// }
//
// for (int i = 0; i < N; i++) {
// for (int j = 0; j < 5; j++) {
// matrix[j][i] = in.nextInt()-1;
// hm[j].put(matrix[j][i], i);
// }
// }
//
// for (int i = 0; i < 5; i++) {
// tmp[i] = matrix[i].clone();
// Arrays.sort(tmp[i]);
// }
//
// for (int i = 0; i < 5; i++) {
// for (int j = 0; j < N; j++) {
// hm[i].put(tmp[i][j], j);
// }
// }
//
// for (int i = 0; i < N; i++) {
// BitSet[] bm = new BitSet[5];
// for (int j = 0; j < 5; j++) {
// bm[j] = new BitSet(N);
// int index = hm[j].get(matrix[j][i]);
// for(int k = 0; k < index; k++){
// bm[j].set(hm[j].get(tmp[j][k]));
// }
// bm[0].and(bm[j]);
// }
// System.out.println(bm[0].cardinality());
// }
//
// }
// }
// }


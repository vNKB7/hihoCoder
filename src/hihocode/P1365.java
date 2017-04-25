package hihocode;

import java.util.Scanner;

/*
 * #1365 : 图片排版
 */

public class P1365 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int M = in.nextInt();
			int N = in.nextInt();

			int[] W = new int[N];
			int[] H = new int[N];

			int[] height = new int[N + 1];

			for (int i = 0; i < N; i++) {
				W[i] = in.nextInt();
				H[i] = in.nextInt();
			}

			for (int i = N - 1; i >= 0; i--) {
				int max_h = 0;
				int remain_space = M;
				int j = i;
				for (; j < N; j++) {
					if (remain_space == 0) {
						break;
					} else if (remain_space >= W[j]) {
						remain_space -= W[j];
						max_h = max_h > H[j] ? max_h : H[j];
					} else {
						int cur_h = (int)Math.ceil((double)remain_space * H[j] / W[j]);//(remain_space * H[j] + W[j] - 1) / W[j];
						max_h = max_h > cur_h ? max_h : cur_h;
						remain_space = 0;
					}
				}
				height[i] = max_h + height[j];
			}

			int min_height = Integer.MAX_VALUE;
			int min_index = 0;
			int pre_h = 0; // 本行之上的高度
			int row_h = 0; // 本行中在此之间的最大高度
			int row_w = 0; // 本行剩余的空间
			for (int i = 0; i < N; i++) {
				// 计算i不在时的高度
				int max_h = row_h;
				int remain_space = M - row_w;
				int j = i + 1;
				for (; j < N; j++) {
					if (remain_space == 0) {
						break;
					} else if (remain_space >= W[j]) {
						remain_space -= W[j];
						max_h = max_h > H[j] ? max_h : H[j];
					} else {
						int cur_h = (int)Math.ceil((double)remain_space * H[j] / W[j]);//(remain_space * H[j] + W[j] - 1) / W[j];
						max_h = max_h > cur_h ? max_h : cur_h;
						remain_space = 0;
					}
				}

				int temp = pre_h + max_h + height[j];
				if (temp < min_height) {
					min_height = temp;
					min_index = i;
				}

				// 更新pre_h, row_h, row_w
				remain_space = M - row_w;
				if (remain_space > W[i]) {
					row_w += W[i];
					row_h = row_h > H[i] ? row_h : H[i];
				} else if (remain_space == W[i]) {
					row_w = 0;
					row_h = row_h > H[i] ? row_h : H[i];
					pre_h += row_h;
					row_h = 0;
				} else {
					int cur_h = (int)Math.ceil((double)remain_space * H[i] / W[i]);//(remain_space * H[i] + W[i] - 1) / W[i];
					row_h = row_h > cur_h ? row_h : cur_h;
					pre_h += row_h;
					row_h = 0;
				}
			}
			System.out.println(min_height);
			System.out.println(min_index);
		}
	}

}

package 拼多多;

import java.util.ArrayList;
import java.util.List;

public class P1 {

	public static void main(String[] args) {
		List<int[]> result = solve(new int[][]{
				{0,0,0,0,0,0,0,1,1,1,1,1},
				{0,0,0,0,1,1,1,1,1,1,1,1},
				{0,0,0,0,0,0,1,1,1,1,1,1},
				{0,0,0,0,0,0,0,0,0,1,1,1},
				{0,0,0,0,0,0,0,1,1,1,1,1},
				{0,0,0,0,1,1,1,1,1,1,1,1}});
		for(int[] r : result){
			System.out.println(r[0] + " " + r[1]);
		}
	}

	public static List<int[]> solve(int[][] matrix) {
		List<int[]> result = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}

		int index = matrix[0].length - 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = index; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					index = j;
				} else {
					break;
				}
			}
		}

		if (index == matrix[0].length - 1) {
			boolean flag = false;
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][matrix[0].length - 1] == 1) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				for (int i = 0; i < matrix.length; i++) {
					result.add(new int[] { i+1, 0 });
				}
				return result;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][index] == 1) {
				result.add(new int[] { i+1, matrix[0].length-index});
			}
		}
		return result;
	}

}

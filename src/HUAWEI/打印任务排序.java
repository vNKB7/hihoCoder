package HUAWEI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class 打印任务排序 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String line = in.nextLine();
			if(line.length() == 0){
				System.out.println();
			}
			String[] numStr = line.split(",");
			HashSet<Integer> set = new HashSet<Integer>();
			ArrayList<Integer> result = new ArrayList<>();
			LinkedList<int[]> numsList = new LinkedList<>();

			int[] nums = new int[numStr.length];
			int[] count = new int[9];
			for (int i = 0; i < nums.length; i++) {
				int[] num = new int[2];
				num[1] = Integer.parseInt(numStr[i].trim());
				num[0] = i;
				set.add(num[1]);
				count[num[1] - 1]++;
				numsList.add(num);
			}

			LinkedList<Integer> list = new LinkedList<>(set);
			Collections.sort(list);
			Collections.reverse(list);

			while (numsList.size() > 0) {
				int[] num = numsList.pollFirst();
				int max = 0;
				for(int[] i : numsList){
					if(i[1] > max)
						max = i[1];
				}
				if(num[1] == max){
					result.add(num[0]);
				}else{
					numsList.add(num);
				}
			}

			if (result.size() > 0) {
				System.out.print(result.get(0));
				for (int i = 1; i < result.size(); i++) {
					System.out.print(", " + result.get(i));
				}
				System.out.println();
			} else {
				System.out.println();
			}
		}
	}
}

class Pair {
	int first;
	int second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
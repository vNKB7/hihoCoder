package 编程练习赛19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 数组重排3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = in.nextInt();
			in.nextLine();

			for (int t = 0; t < T; t++) {
				String line = in.nextLine().trim();
				//StringBuilder nums = new StringBuilder(line);
				// int[] nums = new int[line.length()];
				//
				// for(int i = 0; i < line.length(); i++){
				// nums[i] = Integer.parseInt(line.charAt(i)+"");
				// }
				String dest = "";
				for (int i = 1; i <= line.length(); i++) {
					dest += i;
				}

				if (line.equals(dest)) {
					System.out.println(0);
					continue;
				}

				Set<String> history = new HashSet<>();
				List<String> pool = new ArrayList<>();
				int count = 0;

				history.add(line);
				pool.add(line);

				boolean flag = false;
				
				while (pool.size() > 0) {
					count++;
					
					List<String> newPool = new ArrayList<>();

					for (String list : pool) {
						for (int i = 0; i < list.length() - 1; i++) {
							String insert = list.substring(i, i+2);
							String base = list.substring(0, i) + list.substring(i+2, list.length());
							for(int j = 0; j <= base.length(); j++){
								String newLine = base.substring(0,j) + insert + base.substring(j, base.length());
								if(newLine.equals(dest)){
									flag = true;
									break;
								}
								if(history.contains(newLine)){
									continue;
								}else{
									history.add(newLine);
									newPool.add(newLine);
								}
							}
						}
						if(flag){
							break;
						}
					}
					
					if(flag){
						break;
					}
					
					pool = newPool;
				}

				if(flag){
					System.out.println(count);
				}else{
					System.out.println(-1);
				}
			}
		}
	}
}

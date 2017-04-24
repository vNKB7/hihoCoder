package hihocode;

import java.util.Scanner;


/*
 * #1143 : 骨牌覆盖问题·一
 */

public class P1143 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			in.nextLine();
			
			int count = 0;
			int e = 1;
			while(e < N){
				e *= 2;
				count ++;
			}
			
			for(int i = 1; i < count; i++){
				
			}
		}
	}
}

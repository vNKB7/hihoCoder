package 编程练习赛18;

import java.util.Scanner;

public class 分数取模 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			long a = in.nextInt();
			int b = in.nextInt();
			int p = in.nextInt();
			for(long i = 1; i < p; i++){
				if((b * i) % p == 1){
					System.out.println((a*i)%p);
					break;
				}
			}
		}
	}

}

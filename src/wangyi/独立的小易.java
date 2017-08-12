package wangyi;

import java.util.Scanner;

public class 独立的小易 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int x = in.nextInt();
			int f = in.nextInt();
			int d = in.nextInt();
			int p = in.nextInt();
			
			int count = 0;
			int notBuy = d / x;
			if(f > notBuy){
				System.out.println(notBuy);
			}else{
				d -= x * f;
				count = f + d / (x + p);
				System.out.println(count);
			}
		}
	}

}

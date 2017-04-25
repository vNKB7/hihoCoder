package hihocode;

import java.util.Scanner;

/*
 * #1350 : Binary Watch
 */

public class P1350 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			for(int i = 0; i < 24; i++){
				for(int j = 0; j < 60; j++){
					if(Integer.bitCount(i)+Integer.bitCount(j) == n){
						String str = "";
						if (i <= 9) {
							str += "0";
						}
						str += i + ":";
						if (j <= 9) {
							str += "0";
						}
						str += j;
						System.out.println(str);
					}
				}
			}
		}
	}
}

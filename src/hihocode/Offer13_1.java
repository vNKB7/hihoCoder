package hihocode;

import java.util.Scanner;


/*
 * [Offer收割]编程练习赛13
 * 题目1 : 风格不统一如何写程序
 */


public class Offer13_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			in.nextLine();
			for(int n = 0; n < N; n++){
				String name = in.nextLine();
				name = name.trim();
				StringBuilder sb = new StringBuilder();
				if(name.contains("_")){
					sb.append(name.charAt(0));
					for(int i = 1; i < name.length(); i++){
						char c = name.charAt(i);
						if(c == '_'){
							continue;
						}else if(name.charAt(i-1) == '_'){
							if(i-1 != 0){
								if(c - 'a' >= 0 && c - 'a' < 26){
									sb.append((char)('A' + c - 'a'));
								}else{
									sb.append(c);
								}
							}else{
								sb.append(c);
							}
						}else{
							sb.append(c);
						}
					}
				}else{
					for(int i = 0; i < name.length(); i++){
						char c = name.charAt(i);
						if(c - 'A' >= 0 && c - 'A' < 26){
							sb.append('_');
							sb.append((char)(c - 'A' + 'a'));
						}else{
							sb.append(c);
						}
					}
				}
				
				System.out.println(sb);
			}
		}
	}
}

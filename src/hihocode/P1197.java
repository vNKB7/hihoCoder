package hihocode;

import java.util.Scanner;


/*
 * #1197 : Give My Text Back
 */

public class P1197 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			StringBuilder new_str = new StringBuilder();
			
			String[] piece = str.split("\\.");
			boolean f = true;
			for(String s : piece){
				StringBuilder sb = new StringBuilder(s.trim());
				if(sb.length() == 0){
					continue;
				}
				
				if(!f){
					new_str.append(" ");
				}else{
					f = false;
				}
				
//				char ch = sb.charAt(0);
//				if(ch >= 'a' && ch <= 'z'){
//					ch = (char)(ch - 'a' +'A');
//				}
//				new_str.append(ch);
				
				boolean f2 = true;
				String[] words = sb.toString().toLowerCase().trim().split(" ");
				for(String w : words){
					if(w.length() == 0)
						continue;
					if(w.charAt(0) == ',' && w.length() == 1){
						new_str.append(',');
					}else{
						if(f2){
							char ch = w.charAt(0);
							if(ch >= 'a' && ch <= 'z'){
								ch = (char)(ch - 'a' +'A');
							}
							new_str.append(ch + w.substring(1));
							f2 = false;
						}else
							new_str.append(" " + w);
					}
				}
				new_str.append(".");
			}
			System.out.println(new_str);
		}
	}

}

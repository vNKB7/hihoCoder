package hihocode;

import java.util.Scanner;

public class P1082 {
	public static void main(String[] args) {
		String A = "marshtomp";
		String B = "fjxmlhx";
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			String tmp = str.toLowerCase();
			int start = 0;
			while(start < str.length()){
				tmp = str.toLowerCase();
				int index = tmp.indexOf(A);
				if(index == -1){
					break;
				}
				str = str.substring(0, index) + B + str.substring(index+9, str.length());
				start += 7;
			}
			System.out.println(str);
		}
	}

}

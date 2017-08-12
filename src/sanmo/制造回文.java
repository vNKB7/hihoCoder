package sanmo;

import java.util.Scanner;

public class 制造回文 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String line = in.nextLine();
			int[] counts = new int[26];
			for(int i = 0; i < line.length(); i++){
				char c = line.charAt(i);
				counts[c-'a']++;
			}
			int single = 0;
			int pair = 0;
			for(int i = 0; i < 26; i++){
				single += counts[i] % 2;
				pair += counts[i] / 2;
			}
			
			System.out.println(single);
		}
	}
}

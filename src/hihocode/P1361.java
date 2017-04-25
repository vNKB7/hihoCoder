package hihocode;

import java.util.Scanner;

/*
 * #1361 : Playfair密码表
 */

public class P1361 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine().trim();
			int index = 0;
			int[] alphabet = new int[26];
			str = str.replaceAll("J", "I");
			for (int i = 0; i < str.length(); i++) {
				if (alphabet[str.charAt(i) - 'A'] == 0) {
					alphabet[str.charAt(i) - 'A'] = 1;
					System.out.print(str.charAt(i));
					index++;
					if (index % 5 == 0) {
						System.out.println();
					}
				}
			}

			for (int i = 0; i < 26; i++) {
				if (i != 'J'-'A' && alphabet[i] == 0) {
					System.out.print((char)('A'+i));
					index++;
					if (index % 5 == 0) {
						System.out.println();
					}
				}
			}

		}
	}

}

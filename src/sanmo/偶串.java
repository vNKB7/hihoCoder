package sanmo;

import java.util.Scanner;

public class 偶串 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String line = in.nextLine().trim();
			char[] array = line.toCharArray();
			int remain = array.length-2;
			for(; remain > 0; remain -= 2){
				if(equal(array, 0, remain/2, remain/2, remain)){
					break;
				}
			}
			System.out.println(remain);
		}
	}
	
	public static boolean equal(char[] array, int i, int j, int x, int y){
		for(; i < j && x < y; i++, x++){
			if(array[i] != array[x])
				return false;
		}
		return true;
	}
}

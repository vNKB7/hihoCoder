package hihocode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * #1152 : Lucky Substrings
 */

public class P1152 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			
			Set<String> result = new TreeSet<>();
			Set<Integer> set = new HashSet<Integer>(
					Arrays.asList(1, 2, 3, 5, 8, 13, 21));
			
			for(int i = 0; i < str.length(); i++){
				Set<Character> s = new HashSet<>();
				for(int j = i+1; j <= str.length(); j++){
					s.add(str.charAt(j-1));
					if(s.size() > 21) 
						break;
					if(set.contains(s.size())){
						result.add(str.substring(i, j));
					}
				}
			}
			
			for(String s : result){
				System.out.println(s);
			}
		}
	}
}

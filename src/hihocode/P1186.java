package hihocode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * #1186 : Coordinates
 */

public class P1186 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int P = in.nextInt();
			int Q = in.nextInt();
			List<Integer> p_d = divisor(P);
			List<Integer> q_d = divisor(Q);
			
			for(int i : p_d){
				for(int j : q_d){
					System.out.println(i + " " + j);
				}
			}
		}
	}
	
	public static List<Integer> divisor(int a){
		List<Integer> array1 = new ArrayList<Integer>();
		List<Integer> array2 = new ArrayList<Integer>();
		
		for(int i = 1; i * i <= a; i++){
			if(a % i == 0){
				array1.add(i);
				if(i * i != a){
					array2.add(a / i);
				}
			}
		}
		
		Collections.reverse(array2);
		array1.addAll(array2);
		
		return array1;
	}
	
}

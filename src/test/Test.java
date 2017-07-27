package test;

import java.math.BigInteger;

public class Test {

	public static void main(String[] args) {
		int num = Integer.valueOf("10101",2);
		for(int i = 0; i < 35; i++){
			num = num >>> 1;
			System.out.println(i + " : " + Integer.toBinaryString(num));
		}
		
	}

}

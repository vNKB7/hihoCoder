package hihocode;

import java.util.Scanner;

public class hiho149 {
	public static void main(String[] args) {
		int[] Mask = new int[33];
		int x = (~0); 
		for(int i = 32; i >= 0; i--){
			Mask[i] = x;
			x = x << 1;
		}
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int M = in.nextInt();
			in.nextLine();
			
			boolean[] pemission = new boolean[N];
			int[] IP = new int[N];
			int[] mask = new int[N];
			
			for(int n = 0; n < N; n++){
				String[] rule = in.nextLine().trim().split(" ");
				String[] piece = rule[1].split("/");
				if(rule[0].equals("allow")){
					pemission[n] = true;
				}else{
					pemission[n] = false;
				}
				IP[n] = String2Bits(piece[0]);
				
				if(piece.length > 1){
					mask[n] = Integer.parseInt(piece[1]);
				}else{
					mask[n] = 32;
				}
			}
			
			for(int m = 0; m < M; m++){
				boolean flag = true;
				
				String ip_str = in.nextLine();
				int ip = String2Bits(ip_str);
				
				for(int i = 0; i < N; i++){
					if(equal(ip, IP[i], mask[i],Mask)){
						flag = pemission[i];
						break;
					}
				}
				
				if(flag){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
				
			}
		}
	}
	
	static int String2Bits(String ip_str){
		int bits = 0;
		String[] ip = ip_str.split("\\.");
		for(int i = 0; i < 4; i ++){
			bits = (bits << 8) | Integer.parseInt(ip[i]);
		}
		return bits;
	}
	
	static boolean equal(int ip1, int ip2, int mask, int[] Mask){
		
		//移位操作在右操作数大于31后会取模!!
		return (ip1 & Mask[mask]) == (ip2 & Mask[mask]);
	}
	
}

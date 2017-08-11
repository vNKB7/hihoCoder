package 编程练习赛21;

import java.util.Arrays;
import java.util.Scanner;

public class 集合计数 {

	static long[] pow = new long[100000];
	static{
		pow[0] = 1;
		for(int i = 1; i < pow.length; i++){
			pow[i] = (pow[i-1] * 2) % 1000000007;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int N = in.nextInt();
			int K = in.nextInt();
			int[] nums = new int[N];
			for(int i = 0; i < N; i++){
				nums[i] = in.nextInt();
			}
			
			Arrays.sort(nums);
			
			long count = 0;
			for(int num : nums){
				if(num * 2 <= K){
					count++;
				}else{
					break;
				}
			}
			
			int i = 0, j = nums.length - 1;
			while(i < j){
				int sum = nums[i] + nums[j];
				if(sum > K){
					j--;
				}else{
					int len = j-i;
					count += (pow[len] - 1) % 1000000007;
					i++;
				}
			}
			
			System.out.println(count);
		}
	}
}

package niuke;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		for(int N = 1; N<100000000;N++){
			int i = 1, j = 2;
			int length = 2;
			int sum = 3;

			while (i <= (N+1)/2) {
				if (sum == N) {
					break;
				} else if (sum < N) {
					j++;
					sum += j;
					length++;
				} else {
					sum -= i;
					i++;
					length--;
				}
			}
			int x = 1;
			if(sum == N)
				x = length;
			int y = FindContinuousSequence(N);
			if(x != y){
				System.out.println(N);
			}
		}
	}
	
	public static int FindContinuousSequence(int sum) {
		double max = Math.sqrt(2 * sum + 0.25) + 0.5;
		for (int i = (int) (max-1); i>=0; i--) {
			if ((2 * sum % i == 0) && ((2 * sum / i) - i + 1) % 2 == 0) {
				return i;
			}
		}
		return 0;
	}
}



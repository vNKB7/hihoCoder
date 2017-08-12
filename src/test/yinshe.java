package test;

public class yinshe {

	public static void main(String[] args) {
		String str = "10502";
		System.out.println(solve1(str));
		System.out.println(solve1(str));
	}

	public static int solve1(String str) {
		if (str == null || str.length() == 0)
			return 0;

		if (str.length() == 1) {
			if (str.charAt(0) == '0') {
				return 0;
			} else {
				return 1;
			}
		} else if(str.length() == 2){
			if (str.charAt(0) == '0') {
				return 0;
			} else {
				if((str.charAt(0) - '0') * 10 + (str.charAt(1) - '0') <= 26){
					return 2;
				}else
					return 1;
			}
		} else{
			if (str.charAt(0) == '0') {
				return 0;
			} else {
				int one = solve1(str.substring(1));
				int a = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
				int two = 0;
				if (a <= 26) {
 					two = solve1(str.substring(2));
				}
				return one + two;
			}
		}
	}

	public int solve2(String str){
		if(str == null || str.length() == 0)
			return 0;
		
		int[] count = new int[str.length()+1];
		for(int i = str.length()-1; i >= 0; i--){
			if(str.charAt(i) == '0'){
				count[i] = 0;
			}else{
				count[i] += count[i+1];
				if(i < str.length()-1 && (str.charAt(i)-'0')*10 + (str.charAt(i+1)-'0') <= 26){
					count[i] += count[i+2];
				}
			}
		}
		return count[0];
	}
}

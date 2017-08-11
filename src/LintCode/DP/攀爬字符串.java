package LintCode.DP;

public class 攀爬字符串 {

	public static void main(String[] args) {
		System.out.println(new 攀爬字符串().isScramble("rgtae", "great"));
	}

	public boolean isScramble(String s1, String s2) {
		// Write your code here
		if (s1.length() != s2.length()) {
			return false;
		}

		if (s1.equals(s2)) {
			return true;
		}

		int[] count = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++) {
			count[s1.charAt(i) - 'a']--;
			if (count[s1.charAt(i) - 'a'] < 0) {
				return false;
			}
		}

		if (s1.length() <= 2) {
			return true;
		}

		int[] count1 = new int[26];
		int[] count2 = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			count1[s1.charAt(i) - 'a']++;
			count2[s2.charAt(i) - 'a']++;
			if (compare(count1, count2)) {
				if (isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1))
						&& isScramble(s1.substring(i + 1, s1.length()),
								s2.substring(i + 1, s2.length()))) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean compare(int[] a, int[] b) {
		for (int i = 0; i < a.length && i < b.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

}

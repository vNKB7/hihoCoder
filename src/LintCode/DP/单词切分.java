package LintCode.DP;

import java.util.HashSet;
import java.util.Set;

public class 单词切分 {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("a");
		new 单词切分().wordBreak("a", dict);
	}

	public boolean wordBreak(String s, Set<String> dict) {
		// write your code here
		boolean[] DP = new boolean[s.length() + 1];
		DP[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (String word : dict) {
				if (word.length() > i) {
					continue;
				}

				if (word.equals(s.substring(i - word.length(), i))) {
					DP[i] |= DP[i - word.length()];
					if (DP[i]) {
						break;
					}
				}
			}
		}

		return DP[s.length()];
	}
}

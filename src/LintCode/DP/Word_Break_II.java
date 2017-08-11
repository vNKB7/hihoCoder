package LintCode.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Word_Break_II {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("aaaa");
		set.add("aaa");
//		set.add("de");
//		set.add("ding");
//		set.add("co");
//		set.add("code");
//		set.add("lint");
		System.out.println(new Word_Break_II().wordBreak("aaaaaaa", set));
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		// Write your code here
		
		List<String> result = new ArrayList<>();
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(String t : wordDict){
			searchWord(map, s, t);
		}
		
		backTracking(s, result, map, new ArrayList<String>(), 0, s.length());

		return result;
	}

	public void backTracking(String s, List<String> result, Map<Integer, Set<Integer>> map, List<String> history, int start, int end) {
		if(end == start){
			String str = "";
			if(history.size() > 0){
				str = history.get(0);
			}
			
			for(int i = 1; i < history.size(); i++){
				str += " " + history.get(i);
			}
			result.add(str);
			return;
		}
		
		Set<Integer> next = map.get(start);
		if(next == null){
			return ;
		}
		
		for(int n : next){
			history.add(s.substring(start, n+1));
			backTracking(s, result, map, history, n+1, end);
			history.remove(history.size()-1);
		}
	}

	public void searchWord(Map<Integer, Set<Integer>> map, String s, String t) {
		if(t.length() == 0)
			return;
		int start = 0;
		while (start >= 0) {
			start = s.indexOf(t, start);
			if(start < 0){
				break;
			}
			if(!map.containsKey(start)){
				map.put(start, new HashSet<Integer>());
			}
			Set<Integer> set = map.get(start);
			set.add(start+t.length()-1);
			map.put(start, set);
			start += 1;
		}
	}

}

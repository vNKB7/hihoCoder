package LintCode.DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Frog_Jump {

	public static void main(String[] args) {
		System.out.println(new Frog_Jump().canCross(new int[]{0,1,3,6,10,15,19,21,24,26,30,33}));
	}

	public boolean canCross(int[] stones) {
		// Write your code here
		if (stones == null || stones.length == 0) {
			return false;
		}
		if(stones.length == 1){
			return true;
		}
		
		int fin = stones[stones.length - 1];

		Map<Integer, Set<Integer>> jump = new HashMap<>();
		jump.put(1, new HashSet<Integer>());
		jump.get(1).add(1);
		Set<Integer> st = new HashSet<>();
		for (int s : stones) {
			st.add(s);
		}

		for (int k = 1; k < stones.length; k++) {
			int s = stones[k];
			Set<Integer> set = jump.get(s);
			if (set != null) {
				for (int i : set) {
					if (i - 1 > 0 && st.contains(s + i - 1)) {
						if(fin == s + i - 1){
							return true;
						}
						if(!jump.containsKey(s + i - 1)){
							jump.put(s + i - 1, new HashSet<Integer>());
						}
						jump.get(s + i - 1).add(i - 1);
					}
					
					if (st.contains(s + i)) {
						if(fin == s + i){
							return true;
						}
						if(!jump.containsKey(s + i)){
							jump.put(s + i, new HashSet<Integer>());
						}
						jump.get(s + i).add(i);
					}
					
					if (st.contains(s + i + 1)) {
						if(fin == s + i + 1){
							return true;
						}
						if(!jump.containsKey(s + i + 1)){
							jump.put(s + i + 1, new HashSet<Integer>());
						}
						jump.get(s + i + 1).add(i + 1);
					}
				}
			}
		}

		return false;
	}

}

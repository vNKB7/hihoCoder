package 拼多多;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P4 {

	public int[] solve(List<List<Integer>> arrays){
		Map<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();
		for(int i = 0; i < arrays.size(); i++){
			for(int num : arrays.get(i)){
				if(!map.containsKey(num)){
					map.put(num, new ArrayList<Integer>());
				}
				map.get(num).add(i);
			}
		}
		
		List<Integer> nums = new ArrayList<Integer>(map.keySet());
		Collections.sort(nums);
		
		int[] count = new int[arrays.size()];

		int i = 0;
		int j = 0;

		int range[] = new int[2];
		int length =  Integer.MAX_VALUE;
		
		while(i < j && i < nums.size()){
			while(!isCover(count) && j < nums.size()){
				for(int ai : map.get(nums.get(j))){
					count[ai]++;
				}
			}
			
			if(j-i < length){
				length = j-i;
				range[0] = nums.get(i);
				range[1] = nums.get(j);
			}
			
			for(int ai : map.get(nums.get(i))){
				count[ai]--;
			}
			
			i++;
		}
		
		return range;
	}
	
	public boolean isCover(int[] count){
		for(int i : count){
			if(i <= 0)
				return false;
		}
		return true;
	}
}

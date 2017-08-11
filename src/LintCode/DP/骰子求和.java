package LintCode.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 骰子求和 {

	public static void main(String[] args) {
		new 骰子求和().dicesSum(15);
	}

	public List<Map.Entry<Integer, Double>> dicesSum(int n) {
		// Write your code here
		// Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
		// to create the pair
		
		double all = Math.pow(6, n);
		double[][] DP = new double[n+1][6 * n + 1];
		DP[0][0] = 1;
		for(int i = 1; i <= n; i++){
			for(int j = i; j <= 6 * i; j++){
				for(int k = 1; k <= 6; k++){
					if(j-k >= 0){
						DP[i][j] += DP[i-1][j-k];
					}
				}
			}
		}
		
		HashMap<Integer, Double> result = new HashMap<>();
		
		for(int i = n; i <= 6 * n; i++){
			result.put(i, DP[n][i] / all);
		}
		
		List<Map.Entry<Integer, Double>> sort = new ArrayList<>(result.entrySet());
		Collections.sort(sort, new Comparator<Map.Entry<Integer, Double>>(){
			public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2){
				return o1.getKey() - o2.getKey();
			}
		});
		
		return sort;
	}

}

package test;

public class EditDistance {

	public static void main(String[] args) {
		System.out.println(new EditDistance().minDistance("134", "234"));
	}

	public int minDistance(String word1, String word2) {
		int[][] distance = new int[word1.length()+1][word2.length()+1];
		for(int i = 0; i <= word1.length(); i++){
			distance[i][0] = i;
			for(int j = 1; j <= word2.length(); j++){
				if(i == 0){
					distance[i][j] = j;
				}else{
					if(word1.charAt(i-1) == word2.charAt(j-1)){
						distance[i][j] = distance[i-1][j-1];
					}else{
						distance[i][j] = Math.min(distance[i-1][j-1]+1, Math.min(distance[i-1][j]+1, distance[i][j-1]+1));
					}
				}
			}
		}
		
		return distance[word1.length()][word2.length()];
	}
}

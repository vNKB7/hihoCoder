package 拼多多;

import java.util.HashSet;
import java.util.Set;

public class P3 {
	
	public int solve(){
		Set<String> visited = new HashSet<>();
		helper(visited, 0, 0);
		
		return visited.size();
	}

	public void helper(Set<String> visited, int x, int y){
		String pos = x+"#"+y;
		if(visited.contains(pos)){
			return;
		}else{
			visited.add(pos);
			if(move(0)){
				helper(visited, x + 1, y);
			}
			if(move(1)){
				helper(visited, x - 1, y);
			}
			if(move(2)){
				helper(visited, x, y+1);
			}
			if(move(3)){
				helper(visited, x, y-1);
			}
		}
	}
	
	public boolean move(int d){
		return true;
	}
}

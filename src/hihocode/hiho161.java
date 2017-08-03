package hihocode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class hiho161 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			int T = in.nextInt();
			for(int t = 0; t < T; t++){
				int N = in.nextInt();
				int M = in.nextInt();
				
				boolean flag = true;
				
				ArrayList[] graph = new ArrayList[N+1];
				for(int i = 0; i < graph.length; i++){
					graph[i] = new ArrayList<Integer>();
				}
				
				for(int i = 0; i < M; i++){
					graph[in.nextInt()].add(in.nextInt());
				}
				
				if(M + 1 != N){
					flag = false;
				}else{
					boolean[] visited = new boolean[N+1];
					LinkedList<Integer> queue = new LinkedList<>();
					
					int head = 0;
					for(int i = 1; i < graph.length; i++){
						if(graph[i].size() > 0){
							head = i;
							break;
						}
					}
					
					queue.addLast(head);
					
					while(queue.size() > 0){
						int from = queue.pollFirst();
						if(visited[from]){
							flag = false;
							break;
						}else{
							visited[from] = true;
							for(int to : (ArrayList<Integer>)graph[from]){
								queue.addLast(to);
							}
						}
					}
				}
				
				System.out.println(flag ? "YES" : "NO");
			}
		}
	}

}

package 拼多多;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class P2 {

	public static void main(String[] args) {
		System.out.println(solve("[[()]]"));
	}
	
	public static boolean solve(String str){
		if(str == null || str.length() == 0)
			return true;
		
		LinkedList<Character> stack = new LinkedList<>();
		
		Set<Character> history = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c == '{'){
				if(stack.size() == 0 || stack.getLast() == '{'){
					stack.addLast('{');
				}else{
					return false;
				}
			}else if(c == '['){
				if(stack.size() == 0 || stack.getLast() == '{'){
					stack.addLast('[');
				}else{
					return false;
				}
			}else if(c == '('){
				if(stack.size() == 0 || stack.getLast() == '['){
					stack.addLast('(');
				}else{
					return false;
				}
			}else if(c == '}'){
				char left = stack.pollLast();
				if(left != '{'){
					return false;
				}
				
				if(!history.contains('[') && history.size() > 0){
					return false;
				}
				history = new HashSet<>();
				
			}else if(c == ']'){
				char left = stack.pollLast();
				if(left != '['){
					return false;
				}
				if(!history.contains('(')){
					return false;
				}
				history.remove('(');
				history.add('[');
				
			}else if(c == ')'){
				char left = stack.pollLast();
				if(left != '('){
					return false;
				}
				history.add('(');
			}
		}
		
		return true;
	}

}

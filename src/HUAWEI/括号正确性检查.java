package HUAWEI;

import java.util.Scanner;
import java.util.Stack;

public class 括号正确性检查 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			boolean flag = true;
			String line = in.nextLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c == '(' || c == '[' || c == '{') {
					stack.add(c);
				} else if (c == ')' && stack.pop() != '(') {
					flag = false;
					break;
				} else if (c == ']' && stack.pop() != '[') {
					flag = false;
					break;
				} else if (c == '}' && stack.pop() != '{') {
					flag = false;
					break;
				}
			}
			
			if(!flag){
				System.out.println("false");
				continue;
			}
			if (stack.size() > 0) {
				System.out.println("false");
			} else {
				System.out.println("true");
			}
		}

	}

}

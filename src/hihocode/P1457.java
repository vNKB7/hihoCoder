package hihocode;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * #1457 : 后缀自动机四·重复旋律7
 */


// ETL
public class P1457 {

	static BigInteger sum = BigInteger.valueOf(0);
	static BigInteger mod = BigInteger.valueOf(1000000007);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			in.nextLine();
			Set<String> set = new HashSet<>();

			for (int i = 0; i < N; i++) {
				String str = in.nextLine();
				for (int j = 0; j < str.length(); j++) {
					for (int k = j + 1; k < str.length()+1; k++)
						set.add(str.substring(j, k));
				}
			}

			for (String s : set)
				sum_up(s);
			System.out.println(sum);
		}
	}

	public static void sum_up(String str) {
		if (str.length() > 0) {
			BigInteger a = new BigInteger(str);
			sum = sum.add(a);
			sum = sum.mod(mod);
		}
	}
}

// ETL
// public class P1457 {
//
// static BigInteger sum = BigInteger.valueOf(0);
// static BigInteger mod = BigInteger.valueOf(1000000007);
//
// public static void main(String[] args) {
// Scanner in = new Scanner(System.in);
// while (in.hasNext()) {
// int N = in.nextInt();
// in.nextLine();
// Node root = new Node(-1);
//
// for (int i = 0; i < N; i++) {
// String str = in.nextLine();
// for (int j = 0; j < str.length(); j++) {
// insert(root, str.substring(j), 0);
// }
// }
//
// compute(root, "");
// System.out.println(sum);
// }
// }
//
// public static void insert(Node node, String str, int index) {
// if (index != str.length()) {
// int no = str.charAt(index) - '0';
// if (node.children[no] == null) {
// node.children[no] = new Node(no);
// }
// insert(node.children[no], str, index + 1);
// }
// }
//
// public static void compute(Node node, String prefix) {
// sum_up(prefix);
//
// for (int i = 0; i < 10; i++) {
// if (node.children[i] != null) {
// compute(node.children[i], prefix + (char) ('0' + i));
// }
// }
// }
//
// public static void sum_up(String str) {
// if (str.length() > 0) {
// BigInteger a = new BigInteger(str);
// sum = sum.add(a);
// sum = sum.mod(mod);
// }
// }
// }
//
// class Node {
// int val = 0;
// Node[] children = new Node[10];
//
// public Node(int v) {
// val = v;
// }
// }
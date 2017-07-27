package 编程练习赛19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 相交的铁路线_tree {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = in.nextInt();
			for (int t = 0; t < T; t++) {
				int N = in.nextInt();
				int M = in.nextInt();

				List<List<Integer>> path = new ArrayList<>(N + 1);
				for (int i = 0; i < N + 1; i++) {
					path.add(new ArrayList<Integer>());
				}

				for (int i = 0; i < N - 1; i++) {
					int src = in.nextInt();
					int dest = in.nextInt();
					path.get(src).add(dest);
					path.get(dest).add(src);
				}

				int max_degree = 0;
				int max_degree_node = 1;
				for (int i = 1; i < path.size(); i++) {
					if (path.get(i).size() > max_degree) {
						max_degree = path.get(i).size();
						max_degree_node = i;
					}
				}

				List<Node> nodeList = new ArrayList<Node>(N + 1);
				for (int i = 0; i < N + 1; i++) {
					nodeList.add(new Node(i));
				}

				Node root = nodeList.get(max_degree_node);
				buildTree(root, nodeList, path);

				for (int m = 0; m < M; m++) {
					int x1 = in.nextInt();
					int y1 = in.nextInt();
					int x2 = in.nextInt();
					int y2 = in.nextInt();
					Set<Integer> s1 = getCover(nodeList, x1, y1);
					Set<Integer> s2 = getCover(nodeList, x2, y2);
					s1.retainAll(s2);
					if(s1.size() > 0){
						System.out.println("YES");
					}else{
						System.out.println("NO");
					}
				}
			}
		}

		in.close();
	}

	public static void buildTree(Node root, List<Node> nodeList,
			List<List<Integer>> path) {
		int root_index = root.index;
		int parent_index = root.parent != null ? root.parent.index : 0;

		List<Integer> nexts = path.get(root_index);
		for (int next : nexts) {
			if (next != parent_index) {
				Node child = nodeList.get(next);
				child.parent = root;
				root.children.add(child);
				buildTree(child, nodeList, path);
			}
		}
	}

	public static List<Integer> getPath(Node curNode) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(curNode.index);
		while (curNode.parent != null) {
			curNode = curNode.parent;
			list.addFirst(curNode.index);
		}

		return list;
	}

	public static Set<Integer> getCover(List<Node> nodeList, int x, int y) {
		List<Integer> x_list = new ArrayList<>(getPath(nodeList.get(x)));
		List<Integer> y_list = new ArrayList<>(getPath(nodeList.get(y)));
		int i = 0;
		for (; i < Math.min(x_list.size(), y_list.size()); i++) {
			if (x_list.get(i) != y_list.get(i)) {
				break;
			}
		}

		Set<Integer> cover = new HashSet<>();

		for (int j = i; j < x_list.size(); j++) {
			cover.add(x_list.get(j));
		}

		for (int j = i; j < y_list.size(); j++) {
			cover.add(y_list.get(j));
		}
		
		if (i > 0 && (i >= Math.min(x_list.size(), y_list.size()) || x_list.get(i) != y_list.get(i))) {
			cover.add(x_list.get(i-1));
		}

		return cover;
	}
}

class Node {
	public int index;
	public Node parent;
	public List<Node> children;

	public Node(int index) {
		this.index = index;
		children = new ArrayList<Node>();
	}
}

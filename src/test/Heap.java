package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Heap {
	List<Integer> heap;
	int size = 0;

	public Heap() {
		heap = new ArrayList<Integer>();
	}

	public Heap(int[] nums) {
		heap = new ArrayList<Integer>();
		for(int n : nums){
			heap.add(n);
		}
		size = nums.length;
		buildHeap();
	}

	public static void main(String[] args) {
//		Heap hp = new Heap();
//		
//		for(int i = 0; i < 20; i++){
//			hp.add(i);
//		}
		
		Heap hp = new Heap(new int[]{1,2,3,4,5,6,7,8,9});
		
		while(!hp.isEmpty()){
			System.out.println(hp.pop());
		}
	}

	public boolean isEmpty(){
		return size == 0;
	}
	
	
	public void buildHeap() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapdown(i);
		}
	}

	public void heapdown(int i) {
		if (i > size / 2 - 1)
			return;

		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int max = i;

		if (left < size && heap.get(left) > heap.get(max)) {
			max = left;
		}

		if (right < size && heap.get(right) > heap.get(max)) {
			max = right;
		}

		if (max != i) {
			swap(max, i);
			heapdown(max);
		}
	}

	public Integer pop() {
		if (size == 0)
			return null;
		int rt = heap.get(0);
		swap(0, size - 1);
		size--;

		heapdown(0);
		return rt;
	}

	public void add(int i) {
		heap.add(i);
		size++;
		
		heapUp(size-1);
	}

	public void heapUp(int i) {
		if (i >= size || i == 0)
			return;
		
		int parent = (i - 1) / 2;
		if(heap.get(parent) < heap.get(i)){
			swap(parent, i);
		}
		
		heapUp(parent);
	}

	private void swap(int i, int j) {
		if (i < size && j < size) {
			int tmp = heap.get(i);
			heap.set(i, heap.get(j));
			heap.set(j, tmp);
		}
	}

	public static void Native() {
		PriorityQueue<Integer> heap = new PriorityQueue<>(
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						return o2 - o1;
					}
				});

		for (int i = 0; i < 10; i++) {
			heap.add(i);
		}

		while (heap.size() > 0) {
			System.out.println(heap.poll());
		}
	}

}

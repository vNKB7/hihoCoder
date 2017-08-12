package test;

import java.util.Arrays;

public class quickSearch {

	public static void main(String[] args) {
		int[] nums = {3,1,5,4,2,8,9,0};
		System.out.println(quickSelect(nums, 0, nums.length, 0));
		System.out.println(Arrays.toString(nums));
	}
	
	public static int quickSelect(int[] nums, int i, int j, int k){
		if(k < i || k >= j)
			return -1;
		int index = partition(nums, i, j);
		if(index == k)
			return index;
		else if(index < k){
			return quickSelect(nums, index+1, j, k);
		}else{
			return quickSelect(nums, i, index, k);
		}
	}
	
	public static void quickSort(int[] nums, int i, int j){
		if(j - i <= 1)
			return;
		int p = partition(nums, i, j);
		quickSort(nums, i, p);
		quickSort(nums, p+1, j);
	}
	
	public static int partition(int[] nums, int i, int j){
		if(j-i == 1){
			return i;
		}
		
		int p = i;
		int q = i+1;
		for(;q < j; q++){
			if(nums[i] < nums[q]){
				continue;
			}else{
				p++;
				swap(nums, p, q);
			}
		}
		swap(nums, i, p);
		return p;
	}
	
	public static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}

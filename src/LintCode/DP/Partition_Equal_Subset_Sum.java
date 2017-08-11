package LintCode.DP;

public class Partition_Equal_Subset_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Partition_Equal_Subset_Sum().canPartition(new int[]{1,5,11,5}));
	}

	public boolean canPartition(int[] nums) {
        // Write your code here
        if(nums == null)
            return false;
        
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum % 2 != 0)
            return false;
        
        sum = sum / 2;
        
        int[] DP = new int[sum+1];
        //Arrays.fill(DP, -1);
        DP[0] = 1;
        
        for(int i = 0; i < nums.length; i++){
            for(int j = sum; j >= nums[i]; j--){
                DP[j] = Math.max(DP[j], DP[j-nums[i]]);
            }
        }
        
        return DP[sum] == 1;
    }
}

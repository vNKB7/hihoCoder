package LintCode.DP;

public class k数和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int kSum(int A[], int k, int target) {
        // write your code here
        int[][] DP = new int[k+1][target+1];
        DP[0][0] = 1;
        for(int i = 0; i < A.length; i++){
            for(int j = k; j > 0; j--){
                for(int l = target; l >= A[i]; l--){
                    DP[j][l] = DP[j][l] + DP[j-1][l-A[i]];
                }
            }
        }
        return DP[k][target];
    }

}

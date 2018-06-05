package leetcode;

public class DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int climbStairs(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		int pre1 = 2,pre2=1;
		for(int i=2;i<n;i++) {
			int cur = pre1+pre2;
			pre2 = pre1;
			pre1 = cur;
		}
		return pre1;
	}
	
	public int rob(int[] nums) {
		int n = nums.length;
		if(n==0) return  0;
		if(n==1) return nums[0];
		if(n==2) return Math.max(nums[0], nums[1]);
		int pre3 = nums[0],pre2 = nums[1],pre1 =  nums[2]+nums[0];
		for(int i=3;i<n;i++) {
			int cur = Math.max(pre2, pre3)+nums[i];
			pre3 = pre2;
			pre2 = pre1;
			pre1 = cur;
		}
		return Math.max(pre1,pre2);
	}
}

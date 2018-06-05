package leetcode;

import java.util.Arrays;

public class SubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		//System.out.println(maxSubArray(nums));
		int[] nums2 = {1,2,3,4,6,7,8,9};
		System.out.println(arithmeticSlices(nums2));
	}
	
	public static int maxSubArray(int[] nums) {
		if(nums==null || nums.length==0)
			return -1;
		int presum = nums[0];
		int maxsum = presum;
		for(int i=0;i<nums.length;i++) {
			presum = presum>0?presum+nums[i]:nums[i];
			maxsum = Math.max(maxsum, presum);
		} 
		return maxsum;
	}
	
	public static int arithmeticSlices(int nums[]) {
		if(nums==null || nums.length==0)
			return 0;
		int dp[] = new int[nums.length];
		for(int i=2;i<nums.length;i++) {
			if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]) {
				dp[i] = dp[i-1]+1;
			}
		}
		int ret = 0;
		for(int tp:dp) {
			ret+=tp;
		}
		//System.out.println(Arrays.toString(dp));
		return ret;
	}

}	

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePath(7, 3));
		int[] prices = {1,2,3,0,2};
		System.out.println(maxProfit(prices));
	}
	
	public static int uniquePath(int m,int n) {
		int s = m+n-2;
		int d = m-1 ;
		long ret = 1;
		for(int i =1;i<=d;i++) {
			ret = ret*(s-d+i)/i;
		}
		return (int) ret;
	}
	
	public int minPathSum(int[][] grid) {
		if(grid.length == 0||grid[0].length == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[] dp = new int[n];
		for(int i = 0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(j==0) dp[0] = dp[0]+grid[i][0];
				else if(i==0) dp[j] = dp[j-1] + grid[i][0];
				else dp[j] = Math.min(dp[j-1], dp[j])+grid[i][j];
			}
		}
		return dp[n-1];
	}
	
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0 ) return 0;
		int N = prices.length;
		int[] buy = new int[N];
		int[] s1 = new int[N];
		int[] sell = new int[N];
		int[] s2 = new int[N];
		s1[0] = buy[0] = -prices[0];
		sell[0] = s2[0] = 0;
		for(int i = 1;i<N;i++) {
			buy[i] = s2[i-1]-prices[i];
			s1[i] = Math.max(buy[i-1],s1[i-1]);
			sell[i] = Math.max(buy[i-1], s1[i-1])+prices[i];
			s2[i] = Math.max(s2[i-1], sell[i-1]);
		}
		return Math.max(sell[N-1], s2[N-1]);	
	}
	
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0,cur = 0;
		for(int num : nums ) {
			cur = num==0 ? 0:cur+1;
			max = Math.max(max, cur);
		}
		return max;
	}
	
	public int[] findErrorNums(int[] nums) {
		for(int i = 0; i<nums.length;i++) {
			while(nums[i] != i+1) {
				if(nums[i] == nums[nums[i]-1]) {
					return new int[] {nums[nums[i]-1],i+1};
				}
				swap(nums,i,nums[i]-1);
			}
		}
		return nums;
	}
	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
	}
	
	//找到数组中所有重复的数
	public List<Integer> findDuplicates(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++) {
			int index = Math.abs(nums[i])-1;
			if(nums[index] < 0) {
				res.add(nums[i]);
			}
			nums[index] = -(nums[index]); 
		}
		return res;
	}
}

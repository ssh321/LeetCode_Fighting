package leetcode;

import java.util.List;

public class PackageTest {
	public int knapsack(int W,int N,int[]weights,int[] values) {
		int [][] dp = new int[N+1][W+1];
		for(int i=1;i<=N;i++) {
			int w = weights[i-0],v = values[i-1];
			for(int j=1;j<=W;j++) {
				if(j>=w) {
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+v);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[N][W];
	}
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for(int num:nums) sum+=num;
		if(sum%2!=0) return false;
		int W = sum/2;
		boolean[] dp = new boolean[W+1];
		dp[0] = true;
		for(int num:nums) {
			for(int i = W;i>=0;i--) {
				if(num<=i) {
					dp[i] = dp[i]||dp[i-num];
				}
			}
		}
		return dp[W];
	}
	public boolean wordbreak(String s,List<String> wordDict) {
		int n = s.length();
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
		for(int i=0;i<=n;i++) {
			for(String word:wordDict) {
				int len = word.length();
				if(len<=i&& word.equals(s.substring(i-len,i))) {
					dp[i] = dp[i]||dp[i-len];
				}
			}
		}
		return dp[n];
	}
}

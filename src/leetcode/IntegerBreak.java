package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(integerBreak(9));
		System.out.println(numSquares(12));
	}
	
	public static int integerBreak(int n) {
		int[] dp = new int[n+1];
		dp[1] = 1;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<i;j++) {
				dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
			}
		}
		return dp[n];	
	}
	
	public static int numSquares(int n) {
		List<Integer> squareList = generateSquareList(n);
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			for(int square :squareList) {
				if(square>i) break;
				min = Math.min(min, dp[i-square]+1);
			}
			dp[i] = min;
		}
		return dp[n];
	}
	
	private static List<Integer> generateSquareList(int n){
		List<Integer> squareList = new ArrayList<>();
		int diff = 3;
		int square = 1;
		while(square<=n) {
			squareList.add(square);
			square +=diff;
			diff +=2;
		}
		return squareList;
	}
	
	public int numDecoding(String s) {
		if(s==null||s.length()==0)
			return 0;
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = s.charAt(0)=='0'?0:1;
		for(int i=2;i<=n;i++) {
			int one = Integer.valueOf(s.substring(i-1, i));
			if(one != 0) dp[i] += dp[i-1];
			if(s.charAt(i-2) == '0') continue;
			int two = Integer.valueOf(s.substring(i-2, i));
			if(two <= 26) dp[i] +=dp[i-2];
		}
		return dp[n];
	}
}
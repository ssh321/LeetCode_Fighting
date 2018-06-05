package leetcode;

public class StringEdit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		System.out.println(lcs("cnblogs","belong"));
		System.out.println(lcsubstring("cnblogs","belong"));
		System.out.println(lcstring("cnblogs","belong"));*/
		System.out.println(minDis("intention","execution"));
	}
	
	public int minDistance(String word1, String word2) {
		int index = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<word1.length();i++) {
			if(word1.charAt(i)==word2.charAt(index))
				sb.append(word1.charAt(i)+"");
		}
		return 0;
	}
	
	public static int lcs(String str1, String str2) {  
	    int len1 = str1.length();  
	    int len2 = str2.length();  
	    int c[][] = new int[len1+1][len2+1];  
	    for (int i = 0; i <= len1; i++) {  
	        for( int j = 0; j <= len2; j++) {  
	            if(i == 0 || j == 0) {  
	                c[i][j] = 0;  
	            } else if (str1.charAt(i-1) == str2.charAt(j-1)) {  
	                c[i][j] = c[i-1][j-1] + 1;  
	            } else {  
	                c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);  
	            }  
	        }  
	    }  
	    return c[len1][len2];  
	} 
	
	public static int lcsubstring(String str1, String str2) {  
	    int len1 = str1.length();  
	    int len2 = str2.length();  
	    int result = 0;     //记录最长公共子串长度  
	    int c[][] = new int[len1+1][len2+1];  
	    for (int i = 0; i <= len1; i++) {  
	        for( int j = 0; j <= len2; j++) {  
	            if(i == 0 || j == 0) {  
	                c[i][j] = 0;  
	            } else if (str1.charAt(i-1) == str2.charAt(j-1)) {  
	                c[i][j] = c[i-1][j-1] + 1;  
	                result = Math.max(c[i][j], result);  
	            } else {  
	                c[i][j] = 0;  
	            }  
	        }  
	    }  
	    return result;  
	} 
	
	public static String lcstring(String str1, String str2) {  
	    int len1 = str1.length();  
	    int len2 = str2.length();  
	    String result = "";     //记录最长公共子串长度  
	    String[][] c = new String[len1+1][len2+1];  
	    for (int i = 0; i <= len1; i++) {  
	        for( int j = 0; j <= len2; j++) {  
	            if(i == 0 || j == 0) {  
	                c[i][j] = "";  
	            } else if (str1.charAt(i-1) == str2.charAt(j-1)) {  
	                c[i][j] = c[i-1][j-1]+str1.charAt(i-1);  
	                result = result.length()>c[i][j].length()?result:c[i][j];
	            } else {  
	                c[i][j] ="";  
	            }  
	        }  
	    }  
	    return result;  
	} 
	
	public static int minDis(String word1,String word2) {
		if(word1==null||word2==null)
			return 0;
		int m = word1.length(),n = word2.length();
		int[][] dp = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			dp[i][0] = i;
		}
		for(int i=0;i<=n;i++) {
			dp[0][i] = i;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(word1.charAt(i-1)==word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]))+1;
				}
			}
		}
		return dp[m][n];		
	}
}

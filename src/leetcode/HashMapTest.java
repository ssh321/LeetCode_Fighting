package leetcode;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		int[] nums = {1,3,2,2,5,2,3,7};
		System.out.println(findHS(nums));*/
		int[] nums2 = {100,4,102,1,3,2,101,98};
		System.out.println(longestConsecutive(nums2));
	}
	
	public static int findHS(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		int result = 0;
		for(int key:map.keySet()) {
			if(map.containsKey(key+1)) {
				result = Math.max(result, map.get(key)+map.get(key+1));
			}
		}
		return result;
	}
	
	public static int longestConsecutive(int[] nums) {
		Map<Integer,Integer> numCnts = new HashMap<>();
		for(int num : nums) {
			numCnts.put(num, 1);
		}
		for(int num :nums) {
			count(numCnts,num);
		}
		int max = 0;
		for(int num :nums) {
			max = Math.max(max, numCnts.get(num));
		}
		return max;
	}
	
	private static int count(Map<Integer,Integer> numCnts,int num) {
		if(!numCnts.containsKey(num)) {
			return 0;
		}
		int cnt = numCnts.get(num);
		if(cnt>1) {
			return cnt;
		}
		cnt = count(numCnts,num+1)+1;
		numCnts.put(num, cnt);
		return cnt;
	}
	
	public boolean isAnagram(String s, String t) {
		int[] cnts = new int[26];
		for(char c : s.toCharArray()) cnts[c-'a']++;
		for(char c : t.toCharArray()) cnts[c-'a']--;
		for(int cnt :cnts) if(cnt!=0) return false;
		return true;
	} 
	
	public int longestPalindrome(String s) {
		int[] cnts = new int[256];
		for(char c: s.toCharArray()) cnts[c]++;
		int ret = 0;
		for(int cnt : cnts) ret+=(cnt/2)*2;
		if(ret<s.length()) ret++;
		return ret;
	}
	
	public boolean isIsomorphic(String s, String t) {
		int[] preIndexOfS = new int[256];
		int[] preIndexOfT = new int[256];
		for(int i = 0;i<s.length();i++) {
			char sc = s.charAt(i), tc = t.charAt(i);
			if(preIndexOfS[sc] != preIndexOfT[tc]) return false;
			preIndexOfS[sc] = i+1;
			preIndexOfT[tc] = i+1;
		}
		return true;
	}
	
	public boolean isPalindrome(int x) {
		if(x == 0) return true;
		if(x < 0) return false;
		if(x % 10 == 0) return false;
		int right = 0;
		while(x > right) {
			right = right*10 + x % 10;
			x /=10;
		}
		return x==right || x == right/10;
	}
	
	//回文子字符串的数量
	public static int cnt = 0;
	public int countSubstring(String s) {
		for(int i = 0; i<s.length();i++) {
			extendSubstring(s, i, i);
			extendSubstring(s, i, i+1);
		}
		return cnt;
	}
	public static void extendSubstring(String s, int start,int end) {
		while(start>0 && end <s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
			cnt++;
		}
	}
	
	//统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
	public static int countBinarySubstrings(String s) {
		int preLen = 0,curLen = 1, ret = 0;
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == s.charAt(i-1)) curLen++;
			else {
				preLen = curLen;
				curLen = 1;
			}
			if(preLen >= curLen) ret++;
		}
		return ret;
	}
	
}

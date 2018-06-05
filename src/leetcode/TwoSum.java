package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TwoSum {
	
	public HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e',
			'i','o','u','A','E','I','O','U'));
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String reverseVowels(String s) {
		if(s.length()==0) return s;
		int i=0,j=s.length()-1;
		char[] result = new char[s.length()];
		while(i<j) {
			char ci = s.charAt(i);
			char cj = s.charAt(j);
			if(!vowels.contains(ci)) {
				result[i] = ci;
				i++;
			}
			else if(!vowels.contains(cj)) {
				result[j] = cj;
				j--;
			}
			else {
				result[i] = cj;
				result[j] = ci;
				i++;
				j--;
			}
		}
		return new String(result);	
	}
	
	/*回文字符串*/
	public boolean validpalindrome(String s) {
		int i = 0,j=s.length()-1;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return isPalindrome(s,i,j-1)||isPalindrome(s,i++,j);
			}
		}
		return true;
	}
	
	public boolean isPalindrome(String s, int l,int r) {
		while(l<r) {
			if(s.charAt(l++) !=s.charAt(r--))
				return false;
		}
		return true;
	}
	
	public String findLongestWord(String s,List<String> d) {
		String ret = "";
		for(String str:d) {
			for(int i=0,j=0;i<s.length()&&j<str.length();i++) {
				if(s.charAt(i)==s.charAt(j)) j++;
				if(j==str.length()) {
					if(ret.length()<str.length()||(ret.length()==str.length()
							&&str.compareTo(ret)>0))
						ret = str;
				}
			}
		}
		return ret;
	}
	/*堆排序*/
	public int findKthLargest(int[] nums,int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int val:nums) {
			pq.add(val);
			if(pq.size()>k)
				pq.poll();
		}
		return pq.peek();
	}
	/*桶排序*/
	public List<Integer> topKFrequent(int[] nums,int k){
		List<Integer> ret = new ArrayList<Integer>();
		Map<Integer,Integer> numMap= new HashMap<>();
		for(Integer num :nums) {
			numMap.put(num, numMap.getOrDefault(num, 0)+1);
		}
		List<Integer>[] bucket = new List[nums.length+1];
		for(Integer key:numMap.keySet()) {
			int frequency = numMap.get(key);
			if(bucket[frequency]==null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		for(int i=bucket.length-1;i>=0&&ret.size()<k;i--) {
			if(bucket[i]!=null) {
				ret.addAll(bucket[i]);
			}
		}
		return ret;
	}
	
}

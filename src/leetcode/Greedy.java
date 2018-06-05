package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Greedy {
	
	public static void main(String[] args) {
		Integer[] points = {5,2,8,3,9,1,0};
		/*int[][] points= {{10,16},{2,8},{1,9},{7,12}}; 
		Arrays.sort(points,(a,b)->(a[0]-b[0]));
		System.out.println(Arrays.toString(points[0]));
		System.out.println(Arrays.toString(points[1]));
		System.out.println(Arrays.toString(points[2]));*/
	}
	
	public int findContentChildren(int[] g,int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i=0,j=0;
		while(i<g.length&&j<s.length) {
			if(g[i]<s[j]) i++;
			j++;
		}
		return i;
	}
	
	public int findMinArrowShots(int[][] points) {
		if(points.length==0) return 0;
		Arrays.sort(points,(a,b)->(a[1]-b[1]));
		int curPos = points[0][1];
		int ret = 1;
		for(int i = 1;i<points.length;i++) {
			if(points[i][0]<=curPos)
				continue;
			curPos = points[i][1];
			ret++;
		}
		return ret;
	}
	
	public boolean isSubsequence(String s,String t) {
		int index = 0;
		for(char c:s.toCharArray()) {
			index = t.indexOf(c,index);
			if(index == -1) return false;
		}
		return true;
	}
	
	public List<Integer> partitionLabels(String s){
		List<Integer> ret = new ArrayList<>();
		int [] lastIndexs = new int[26];
		for(int i=0;i<s.length();i++) {
			lastIndexs[s.charAt(i)-'a'] = i;
		}
		int firstIndex = 0;
		while(firstIndex<s.length()) {
			int lastIndex = firstIndex;
			for(int i=firstIndex;i<s.length()&&i<lastIndex;i++) {
				int index = lastIndexs[s.charAt(i)-'a'];
				if(index==i) continue;
				if(index>lastIndex) lastIndex = index;
			}
			ret.add(lastIndex-firstIndex+1);
			firstIndex = lastIndex+1;
		}
		return ret;
	}
	
}

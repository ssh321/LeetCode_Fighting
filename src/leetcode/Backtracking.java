package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String digits){
		List<String> ret = new ArrayList<>();
		if(digits==null||digits.length()==0)
			return ret;
		combinatin(new StringBuilder(), digits, ret);
		return ret;	
	}
	private void combinatin(StringBuilder prefix,String digits,List<String> ret) {
		if(prefix.length()==digits.length()) {
			ret.add(prefix.toString());
			return;
		}
		String letters = KEYS[digits.charAt(prefix.length())-'0'];
		for(char c:letters.toCharArray()) {
			prefix.append(c);
			combinatin(prefix, digits, ret);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}
	
	/*不同元素求排列*/
	 public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		List<Integer> permuteList = new ArrayList<>();
		combinationPremute(permuteList, nums, ret, visited);
		return ret;     
	 }
	 public void combinationPremute(List<Integer> list,int[] nums,List<List<Integer>> ret,boolean[] visited) {
		 if(list.size()==nums.length) {
			 ret.add(new ArrayList<>(list));
			 return;
		 }
		 for(int i = 0; i < visited.length; i++) {
			 if(visited[i]) continue;
			 list.add(nums[i]);
			 visited[i] = true;
			 combinationPremute(list,nums,ret,visited);
			 list.remove(list.size()-1);
			 visited[i] = false;
		 }
		 
	 }
	 
	 /*有重复元素求排列*/
	 public List<List<Integer>> permuteUnique(int[] nums) {
		    List<List<Integer>> ret = new ArrayList<>();
		    List<Integer> permuteList = new ArrayList<>();
		    Arrays.sort(nums);
		    boolean[] visited = new boolean[nums.length];
		    backtracking1(permuteList, visited, nums, ret);
		    return ret;
		}

		private void backtracking1(List<Integer> permuteList, boolean[] visited, int[] nums, List<List<Integer>> ret) {
		    if (permuteList.size() == nums.length) {
		        ret.add(new ArrayList(permuteList)); // 重新构造一个 List
		        return;
		    }
		    for (int i = 0; i < visited.length; i++) {
		        if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue; // 防止重复
		        if (visited[i]) continue;
		        visited[i] = true;
		        permuteList.add(nums[i]);
		        backtracking1(permuteList, visited, nums, ret);
		        permuteList.remove(permuteList.size() - 1);
		        visited[i] = false;
		    }
		}
		
	 /*组合*/
		public List<List<Integer>> combine(int n,int k){
			List<List<Integer>> ret = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			backtracking2(1, n, k, list, ret);
			return ret;
		}
		
		public void backtracking2(int start,int n,int k,List<Integer> list,List<List<Integer>> ret) {
			if(k==0) {
				ret.add(new ArrayList<>(list));
				return;
			}
			for(int i=start;i<=n-k+1;i++) {
				list.add(i);
				backtracking2(i+1, n, k-1, list, ret);
				list.remove(list.size()-1);
			}
		}
	 
}

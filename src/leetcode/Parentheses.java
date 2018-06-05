package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(2));
	}
	public static List<String> generate(int n){
		 List<String> list = new ArrayList<String>();
		 backtrack(list, "", 0, 0,n);
		 return list;
	}
	
	public static void backtrack(List<String> list,String str,int open,int close,int max) {
		if(str.length()==max*2) {
			list.add(str);
			return;
		}
		if(open<max)
			backtrack(list,str+"(",open+1,close,max);
		if(close<open)
			backtrack(list, str+")", open, close+1, max);
	}
	
	public static int maxLength(String str) {
		char array[] = str.toCharArray();
		int num = 0;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<array.length;i++) {
			if(array[i]=='(') {
				stack.push(array[i]);
			}
			else if(array[i]==')' && !stack.isEmpty()) {
				stack.pop();
				num+=2;
			}
		}
		return num;
	}
}

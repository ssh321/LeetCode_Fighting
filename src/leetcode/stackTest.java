package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class stackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
//一个栈实现
class MyQueue {
	private Stack<Integer> st = new Stack();
	public void push(int x) {
		Stack<Integer> temp = new Stack();
		while(!st.isEmpty()) {
			temp.push(st.pop());
		}
		st.push(x);
		while(!temp.isEmpty()) {
			st.push(temp.pop());
		}
	}
	
	public int pop() {
		return st.pop();
	}
	public int peek() {
		return st.peek();
	}
	public boolean isEmpty() {
		return st.isEmpty();
	}
}

//两个栈实现
class MyQueue2{
	private Stack<Integer> in = new Stack<>();
	private Stack<Integer> out = new Stack<>();
	private void in2out() {
		if(out.isEmpty()) {
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
		}
	}
	public void push(int x) {
		in.push(x);
	}
	public int pop() {
		in2out();
		return out.pop();
	}
	public int peek() {
		in2out();
		return out.peek();
	}
	public boolean isEmpty() {
		return in.isEmpty() && out.isEmpty();
	}
}

//用队列实现栈
class MyStack{
	private Queue<Integer> queue;
	public MyStack() {
		queue = new LinkedList<>();
	}
	
	public void push(int x) {
		queue.add(x);
		int cnt = queue.size();
		while(cnt-- >1) {
			queue.add(queue.poll());
		}
	}
	
	public int pop() {
		return queue.remove();
	}
	public int top() {
		return queue.peek();
	}
	public boolean empty() {
		return queue.isEmpty();
	}
}

//最小值栈
class MinStack{
	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;
	private int min;
	
	public MinStack() {
		dataStack = new Stack<>();
		minStack  = new Stack<>();
		min = Integer.MAX_VALUE;
	}
	
	public void push(int x) {
		dataStack.add(x);
		min = Math.min(min, x);
		minStack.add(min);
	}
	
	public void pop() {
		dataStack.pop();
		minStack.pop();
		min = minStack.isEmpty()?Integer.MAX_VALUE:minStack.peek();
	}
	
	public int top() {
		return dataStack.peek();
	}
	
	public int getMin() {
		return min;
	}
}

//栈括号匹配
class Brackets{
	public boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		char[] chars = s.toCharArray();
		for(char c : chars) {
			if(c=='{'||c=='['||c=='(')
				st.push(c);
			else {
				if(st.isEmpty()) return false;
				char cStack = st.pop();
				boolean b1 = c==')'&& cStack !='(';
				boolean b2 = c==']'&& cStack !='[';
				boolean b3 = c=='}'&& cStack !='{';
				if(b1||b2||b3) return false;
			}
		}
		return st.isEmpty();
	}
}

//数组元素与下一个比它大元素之间的距离
class ArrayMostDistance{
	public int[] dailyTemperatures(int[] tems) {
		int n = tems.length;
		Stack<Integer> st = new Stack<>();
		int[] ret = new int[n];
		for(int i=0;i<n;i++) {
			while(!st.isEmpty() && tems[i] >tems[st.peek()]) {
				int index = st.pop();
				ret[index] = i-index;
			}
			st.add(i);
		}
		return ret;
	}
	
	//另一个数组中比当前元素大的下一个元素
	public int[] nextGreaterElement(int[] nums1,int[] nums2) {
		Map<Integer,Integer> map = new HashMap<>();
		Stack<Integer> st = new Stack<>();
		int[] ret = new int[nums1.length];
		for(int num:nums2) {
			while(!st.isEmpty() && num>st.peek()) {
				map.put(st.pop(),num);
			}
			st.add(num);
		}
		for(int i =0;i<nums1.length;i++) {
			if(map.containsKey(nums1[i])) ret[i] = map.get(nums1[i]);
			else ret[i] = -1;
		}
		return ret;
	}
	//循环数组中比当前元素大的下一个元素
	public int[] nextCircleGreaterElements(int[] nums) {
		int n = nums.length;
		int next[] = new int[n];
		Arrays.fill(next, -1);
		Stack<Integer> st = new Stack<>();
		for(int i = 0;i<n*2;i++) {
			int num = nums[i%n];
			while(!st.isEmpty() && num >nums[st.peek()]) {
				next[st.pop()] = num;
			}
			if(i<n) st.push(i);
		}
		return next;
	}
}

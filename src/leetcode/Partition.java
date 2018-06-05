package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	}
	
	public List<Integer> diffWays(String input){
		int n = input.length();
		List<Integer> ret = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			char c = input.charAt(i);
			if(c=='+'||c=='-'||c=='*') {
				List<Integer> left = diffWays(input.substring(0,i));
				List<Integer> right = diffWays(input.substring(0,i));
				for(int l:left) {
					for(int r:right) {
						switch(c) {
						case '+':ret.add(l+r);break;
						case '-':ret.add(l-r);break;
						case '*':ret.add(l*r);break;
						}
					}
				}
			}
		}
		if(ret.size()==0) ret.add(Integer.valueOf(input));
		return ret;
	}

}

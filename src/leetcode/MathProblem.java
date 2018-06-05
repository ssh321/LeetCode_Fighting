package leetcode;

public class MathProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,5,7,3,5,2,2,2,2,9,4,2,2,2,2};
		System.out.println(morjorityElement(nums));
	}
	
	public static int morjorityElement(int[] nums) {
		int cnt = 0, morjority = nums[0];
		for(int num :nums) {
			morjority = (cnt==0)?num:morjority;
			cnt = (morjority==num)?cnt+1:cnt-1;
		}
		return morjority;
	}
	
	public static boolean isPerfectSquare(int num) {
		int subNum = 1;
		while(num > 0) {
			num -=subNum;
			subNum +=2;
		}
		return num==0;
	}
}

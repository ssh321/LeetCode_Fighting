package leetcode;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int search(int key, int[] array) {
		int l = 0,h =array.length-1;
		while(l<=h) {
			int mid = l+(h-l)/2;
			if(key>array[mid])
				l = mid+1;
			else if(key<array[mid])
				h = mid-1;
			else
				return mid;
		}
		return -1;	
	}
	
	public int mySqrt(int x) {
		if(x<1) return x;
		int l = 1,h = x;
		while(l<=h) {
			int mid = l+(h-l)/2;
			int sqrt = x/mid;
			if(sqrt==mid) return mid;
			else if(sqrt>mid)
				l = mid+1;
			else
				h = mid-1;
		}
		return h;
	}
}

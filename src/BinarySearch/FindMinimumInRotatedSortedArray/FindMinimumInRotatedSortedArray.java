package BinarySearch.FindMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int[] a = {3,4,5,6,1,2};
		System.out.println(findMin(a));

	}
	public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
        	int mid = left + (right - left)/2;
        	if(nums[mid] < nums[right]) {
        		right = mid;
        	}else {
        		left = mid + 1;
        	}
        
    }
        return nums[left];
}
}
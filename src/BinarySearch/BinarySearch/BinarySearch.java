package BinarySearch.BinarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		int [] a = {-1, 0, 2, 4, 6, 8};
		System.out.println(search(a,4));

	}
	public static int search(int[] nums, int target) {
        int right = nums.length-1;
        for(int left = 0; left < nums.length; left++) {
        	if(target == nums[left])
        		return left;
        	if(target == nums[right])
        		return right;
        	else
        		right--;
        }
        return -1;
        
    }
}

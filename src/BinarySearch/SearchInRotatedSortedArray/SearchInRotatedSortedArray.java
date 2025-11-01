package BinarySearch.SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] a = {3,4,5,6,1,2};
		System.out.println(search(a, 1));

	}
	public static int search(int[] nums, int target) {
        int right = nums.length-1;
        int left = 0;
      	while(left<=right) {
        	int mid = (right + left)/2;
        	if(nums[mid] == target)
        		return mid;
        	if(nums[left]<=nums[mid]) {
        		if(nums[left] <= target && target < nums[mid]) {
        			right = mid -1;
        		} else {
        			left = mid + 1;
        		}
        	}
        	else {
        		if(nums[mid] < target && target <=nums[right]) {
        			left = mid +1;
        		} else {
        			right = mid - 1;
        		}
        	}
        	
        }
        return -1;
    }
}

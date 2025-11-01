#Find Minimum in Rotated Sorted Array 


**Category:** Binary Search (NeetCode)

**Difficulty:** Medium

**Time Complexity:** O(log n)

**Space Complexity:** O(1)



#Problem Description: 

Given a rotated sorted array of unique elements, find the minimum element in the array. You must solve this in O(log n) time.



#Approach
- Use a left pointer that begins at 0 and a right pointer that begins at the array length minus 1. 
- Iterate through the array while the left pointer is less than the right. 
- Calculate the mid using left + (right - left)/2.
- If nums[mid] < nums[right], the minimum is in the left half, including the mid, so set the right pointer equal to mid. 
- Otherwise, the minimum is in the right half, excluding the mid, so set the left pointer equal to the mid plus 1. 
- Keep iterating through and return nums[left] which should be the smallest element. 

#Example: 


**Input:**

nums = [3,4,5,6,1,2]

**Output:**

1



**Explanation:**

Array rotated at pivot between 6 and 1. Minimum element is 1.



##Java Code: 

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
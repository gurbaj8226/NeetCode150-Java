#Search in Rotated Sorted Array 

**Category:** Binary Search (NeetCode)

**Difficulty:** Medium

**Time Complexity:** O(log n)

**Space Complexity:** O(1)



## Problem Description: 

You are given an integer array nums sorted in ascending order and then rotated at an unknown pivot. Given an integer target, return its index if it exists in the array, otherwise return -1.



##Approach: 
- Initialize a left and a right pointer, the left starting at 0 and the right starting at the end of the array. 
- Iterate through the array while the left pointer is less than or equal to the right. 
- Calculate the middle of the array by doing (right+left)/2. 
- If the target is at mid, then return mid. 
- Otherwise, check which half of the array is sorted. If nums[left] <= nums[mid], then the left half is sorted. If the target is in between nums[left] and nums[mid], move the right pointer to mid - 1. Else, move the left to mid + 1. 
- If that is not the case, then the right half of the array is sorted. If the target is in between nums[mid] and nums[right], move the left pointer to mid + 1, otherwise, move the right pointer to mid - 1. 

##Example: 


**Input:**

nums = [3,4,5,6,1,2], target = 1

**Output:**

4



**Explanation:**

Array rotated at pivot between 6 and 1. Target 1 is found at index 4.



##Java Code:
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
        		
        			left = mid + 1;
        			
        		} else {
        		
        			right = mid - 1;
        		}
        	}
        	
        }
        
        return -1;
    }
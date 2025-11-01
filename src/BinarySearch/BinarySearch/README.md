# Binary Search 


**Category:** Binary Search (NeetCode)

**Difficulty:** Easy

**Time Complexity:** O(log n)

**Space Complexity:** O(1)



## Problem Description: 
Given a sorted integer array nums and an integer target, return the index of target if it exists in the array. If it does not exist, return -1.


## Approach:
- Initialize a right pointer which is the array length minus 1, and another pointer can be initialized during the for loop. 
- If the target equals the array at the left pointer, return the index. If the target equals the array at the right pointer, then return that index. 
- Decrement the right by once if neither of those apply, and the left will increment for each iteration of the for loop. 
- If after iterating through the entire array and the number does not exist in that array, return a default value of -1. 


## Example:


**Input:**

nums = [-1, 0, 2, 4, 6, 8], target = 4

**Output:**

3



**Explanation:**

The value 4 is found at index 3.



## Java Code

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
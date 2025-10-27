# Two Sum II - Input Array Is Sorted

**Category:** Two Pointers (NeetCode)
**Difficulty:** Medium
**Time Complexity:** O(n)
**Space Complexity:** O(1)

## Problem Description:
Given a **1-indexed sorted array** of integers `numbers` and a target value `target`, return the indices of the two numbers that add up to `target`.

## Approach:
- Create two pointers, the left one starting at the beginning and the right starting at the end of the array. 
- While the left pointer is smaller than right, compute the sum, and if it is equal to the target, then return the indexes+1. You need to add one since the problem asks for 1-indexed sorted array. 
- If the sum is not equal to the target, then you need to check if the sum is smaller than or greater than the target. The array is sorted, so if the sum is smaller, you can move the left pointer up to find a bigger number, and if the sum is too big, than you can move the right pointer down. 

## Example:
**Input:**
`numbers = [2,7,11,15], target = 9`

**Output:**
`[1,2]`

**Explanation:**
`2 + 7 = 9`

## Java Code:
public class TwoSumII {

	public static int[] twoSum(int[] numbers, int target) {
	
        int left = 0;
        
        int right = numbers.length-1;
        
        while(left < right) {
        
        	int sum = numbers[left] + numbers[right];
        	
        	if(sum == target) {
        	
        		return new int [] {left + 1, right + 1};
        		
        	}
        	
        	if(sum < target)
        	
        		left++;
        		
        	else
        	
        		right--;
        		
        }
        
        return new int[] {};
    }
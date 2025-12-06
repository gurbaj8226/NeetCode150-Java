# Find the Duplicate Number (Negative Marking)

**Category:** Arrays (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n)  
**Space Complexity:** O(1)

## Problem Description
You are given an array `nums` of length `n + 1`, where each value is in the range `[1, n]`.  
Exactly one integer appears more than once.  
Return that duplicate number.

You must solve this without using extra space greater than O(1).

## Approach
* Use **negative marking**.  
* Iterate through the array and treat each number as an index.  
* For each value `x = abs(nums[i])`:  
  - If `nums[x]` is already negative, then `x` is the duplicate.  
  - Otherwise, multiply `nums[x]` by `-1` to mark it as visited.
* This works because each value is in `[1, n]`, making them valid indices.

## Example
**Input:**  
nums = [3,1,3,4,2]

**Output:**  
3

## Code
```java
public class FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {

		for (int n : nums) {
			int idx = Math.abs(n) - 1;

			if (nums[idx] < 0) {
				return Math.abs(n);
			}

			nums[idx] *= -1;
		}

		return -1;
	}
}


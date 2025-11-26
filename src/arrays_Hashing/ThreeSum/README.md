# 3Sum

**Category:** Arrays & Hashing (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n²)  
**Space Complexity:** O(1) (not counting output)

## Problem Description
Given an integer array `nums`, return all unique triplets `[a, b, c]` such that:

a + b + c = 0

Triplets must be unique, and the order inside the final list does not matter.

## Approach
* Sort the array.  
* Iterate with index `i`, and for each `i` use a **two-pointer** approach:
  * `left = i + 1`
  * `right = n - 1`
* For each triplet:
  * If the sum is **too small**, move `left` forward.
  * If the sum is **too large**, move `right` backward.
  * If the sum is **zero**, record it and skip duplicates.
* Continue until all valid triplets are found.

Sorting allows duplicates to be avoided cleanly.

## Example
**Input:**  
`nums = [-1,0,1,2,-1,-4]`

**Output:**  
`[[-1,-1,2], [-1,0,1]]`

## Code (Java)
```java

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
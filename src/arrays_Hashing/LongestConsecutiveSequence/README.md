# Longest Consecutive Sequence

**Category:** Arrays & Hashing (NeetCode)  

**Difficulty:** Medium  

**Time Complexity:** O(n)  

**Space Complexity:** O(n)

## Problem Description
Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.  You must write an algorithm that runs in O(n) time.

## Approach
* Use a `HashSet` to store all numbers for O(1) lookups.  
* Iterate through the set and for each number, check if it is the **start** of a sequence (i.e., `n - 1` is not in the set).  
* From that start, count consecutive numbers until the sequence ends.  
* Track the maximum sequence length found.  

This avoids redundant checks and ensures O(n) total time.

## Example
**Input:**  
`nums = [100, 4, 200, 1, 3, 2]`  

**Output:**  
`4`  

**Explanation:**  
The longest consecutive elements sequence is `[1, 2, 3, 4]`.

## Java Code
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);

        int max = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int current = n;
                int counter = 1;

                while (set.contains(current + 1)) {
                    current++;
                    counter++;
                }

                max = Math.max(max, counter);
            }
        }
        return max;
    }
}
---
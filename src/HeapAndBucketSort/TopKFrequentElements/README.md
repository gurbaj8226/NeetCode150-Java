# Top K Frequent Elements

**Category:** Heap / Bucket Sort (NeetCode)

**Difficulty:** Medium

**Time Complexity:** O(N) — using bucket sort

**Space Complexity:** O(N)

## Problem Description
Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may return the answer in any order.

## Approach
- Create a HashMap to store the frequency of each number. 
- Create an Array of Lists called sorted to use the bucket sort technique. The numbers stored at the index will have a frequency equal to the index. 
- If multiple numbers have the same frequency, using a normal Array would be mean one of them would get lost. Therefore, you need a for loop that initializes an ArrayList at every index of the array of Lists. 
- Add the frequency of each variable to the HashMap, and then iterate through the entire HashMap and add the number to the Array of Lists at the index which is their frequency. 
- Create an array of size k to store the final result, and an index to keep track of how many numbers are being added to the result before we have enough. 
- Start from the back of the array of lists, because if we want to return the most frequent numbers, and the frequency is equal to the index, we will have to start from the back. Go through all the numbers in the specific index if there are more than one, and add it to the result. Afterwards, incremement the variable that keeps track of the index. Once we have added enough numbers, return the result. 

## Example
**Input:**
`nums = [1,1,1,2,2,3], k = 2`

**Output:**
`[1, 2]`

**Explanation:**
1 appears 3 times, 2 appears 2 times, and 3 appears once.
The top 2 frequent elements are 1 and 2.

## Java Code

```java

public class TopKFrequentElements {

	public static int[] topKFrequent(int[] nums, int k) {
	
		Map<Integer, Integer> freq = new HashMap<>();
		
		List<Integer>[] sorted = new List[nums.length + 1];

		for (int i = 0; i < sorted.length; i++)
		
			sorted[i] = new ArrayList<>();

		for (int num : nums)
		
			freq.put(num, freq.getOrDefault(num, 0) + 1);

		for (Map.Entry<Integer, Integer> entry : freq.entrySet())
		
			sorted[entry.getValue()].add(entry.getKey());

		int[] result = new int[k];
		
		int index = 0;
		
		for (int i = sorted.length - 1; i > 0 && index < k; i--) {
		
			for (int n : sorted[i]) {
			
				result[index++] = n;
				
				if (index == k)
				
					return result;
					
			}
			
		}
		
		return result;
	}
}

package HeapAndBucketSort.TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 3, 3 };
		System.out.println(topKFrequent(nums, 2));
	}

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

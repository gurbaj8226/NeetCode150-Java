package arrays_Hashing.LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
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
				max = Math.max(counter, max);
			}
		}
		return max;
	}
}

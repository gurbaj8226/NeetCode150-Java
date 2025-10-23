package Sliding_Windows.LengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
	public int LengthofLongestSubString(String s) {
		int left = 0;
		int result = 0;
		Set<Character> L = new HashSet<>();
		for (int right = 0; right < s.length(); right++) {
			while (L.contains(s.charAt(right))) {
				L.remove(s.charAt(left));
				left++;
			}
			L.add(s.charAt(right));
			result = Math.max(result, right - left + 1);
		}
		return result;
	}

}

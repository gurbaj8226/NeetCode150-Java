package Sliding_Windows.MinimumWindowSubString;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

	public static String minWindow(String s, String t) {

		Map<Character, Integer> Frequency = new HashMap<>();
		
		Map<Character, Integer> Window = new HashMap<>();

		for (char c : t.toCharArray())
			Frequency.put(c, Frequency.getOrDefault(c, 0) + 1);

		int have = 0;
		
		int need = Frequency.size();
		
		int left = 0;
		
		int start = 0;
		
		int minLength = Integer.MAX_VALUE;

		for (int right = 0; right < s.length(); right++) {
			
			char c = s.charAt(right);
			
			Window.put(c, Window.getOrDefault(c, 0) + 1);

			if (Frequency.containsKey(c) && Window.get(c).equals(Frequency.get(c))) {
				
				have++;
			}

			while (have == need) {
				
				if (right - left + 1 < minLength) {
					
					minLength = right - left + 1;
					
					start = left;
					
				}
				char leftChar = s.charAt(left);
				
				Window.put(leftChar, Window.getOrDefault(leftChar, 0) - 1);

				if (Frequency.containsKey(leftChar) && Window.get(leftChar) < (Frequency.get(leftChar)))
					
					have--;

				left++;
			}
		}
		return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);

	}

}

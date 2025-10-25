#Minimum Window Substring

**Category:** Sliding Window (Neetcode)

**Difficulty:** Hard

**Time Complexity:** O(N)

**Space Complexity:** O(m), m = number of unique chars in t. 

#Problem Description: Find the smallest substring of 's' that contains all letters of 't'.

#Approach: 
- Use two HashMaps, one that keeps track of all the unique letters in t, and another to keep track of the length of the substring (our window). 
- While we iterate through String s, we will add the character at the right pointer to the HashMap.If that same letter is found in the HashMap that tracks t's letters, the number of them is the same, you will increment the "have" integer. 
- You will keep iterating through String s until the have integer is equal to the need integer, which means you have all the unique characters you need. 
- A variable minLen, stores the length of the window, and we want the smallest one, so this tracks whether or not the current window is smaller than the previous one, and if so, update the variable to the smaller window. 
- Lastly, we will now try to shrink the Window to get an even smaller one. Use the left pointer that starts at 0 to reduce the count of the variable in the HashMap for our window. If now, the amount of that letter in the window is less than the amount in the String t, we will have to decrement "have", and iterate through the next for loop until "have" is equal to "next" again. 

#Example: 
Input: s = "ADOBECODEBANC", t = "ABC"

Output: BANC

Explanation: The smallest substring of s that contains all letters of t, is BANC. 

#Java Code: 

public class LengthOfLongestSubstring {

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


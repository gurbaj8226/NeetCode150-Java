# Longest Repeating Character Replacement

**Category:** Sliding Window (NeetCode)

**Difficult:** Medium 

**Time Complexity:** O(N)

**Space Complexity:** O(1)

#Problem Description: Given a string 's' and an integer 'k', return the length of the longest substring that can be obtained by replacing at most 'k' characters so that all the characters in the substring are the same. 


#Approach
- Use a HashMap<Character, Integer> to keep track of the frequency of the letters in the window. 
- Initialize a left and right pointer that both start at 0. 
- Initialize a maxF variable that keeps track of the most frequent character in the window. 
- Create a for loop with the right pointer that iterates through the String and updates each variable and its frequency in the HashMap. Use Math.max to continue updating maxF with the most frequent character. 
- If the current window size, subtracting all the occurrences of the most frequent character, is greater than the number of replacements we have, which is 'k', then the window is too big. Now, you must slide over the left pointer and update the HashMap.  
- Have a result variable keep track of the biggest window size using Math.max and (right - left +1). 
- Iterate through the entire string, and afterwards, return the result, which will be the largest window. 

#Example
Input: s = "AABABBA", k = 1

Output: 4

Explanation: Replace the B in "AABA" (the first 4 characters), which then becomes "AAAA," which is the largest possible substring of repeating characters. 

#Java Code

public class LongestRepeatingCharacter {

	public static int characterReplacement(String s, int k) {
	
		Map<Character, Integer> map = new HashMap<>();
		
		int left = 0;
		
		int maxF = 0;
		
		int result = 0;
		
		for (int right = 0; right < s.length(); right++) {
		
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
			
			maxF = Math.max(maxF, map.get(s.charAt(right)));
			
			while ((right - left + 1) - maxF > k) {
			
				map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
				
				left++;
				
			}
			
			result = Math.max(result, right - left + 1);
			
		}

		return result;

	}
}

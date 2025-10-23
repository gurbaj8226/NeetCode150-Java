#Longest SubString Without repeating Characters

**Category:** Sliding Window (Neetcode)

**Difficulty:** Medium

**Time Complexity:** O(N)

**Space Complexity:** O(N)

#Problem Description: Given a string 's', find the length of the longest substring without repeating characters.

#Approach: 
- Use left and right pointers to create sliding window that iterates over the string. 
- Create a set to keep track of unique values, and run a for loop that starts at right=0. 
- If you found a duplicate, delete values from the Set while incrementing left pointer. 
- Afterwards, add the value of right to HashSet and keep track of Window Size using Math.max();

#Example: 
Input: "abcabcbb"
Output: 3
Explanation: The longest substring without repeating characters is "abc".

#Java Code: 

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


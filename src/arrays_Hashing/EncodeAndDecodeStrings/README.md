# Encode and Decode Strings

**Category:** Arrays & Hashing (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n)  
**Space Complexity:** O(n)

## Problem Description
Design an algorithm to encode a list of strings into a single string, and then decode the string back into 
the original list.  
The encoding must preserve all possible characters, including spaces, numbers, and `#`.

## Approach
* Use **length-prefix encoding**.  
* For each string, encode it as:  
  `length#string`  
* Example: `"hello"` becomes `"5#hello"`.

**Decoding:**  
* Parse characters until reaching `#` → this is the length of the string.  
* Read exactly that many characters.  
* Continue until all strings are decoded.

This avoids ambiguity and works with all special characters.

## Example
**Input:**  
`["neet", "code", "love#ai"]`

**Encoded:**  
`"4#neet4#code6#love#ai"`

**Decoded:**  
`["neet", "code", "love#ai"]`

## Java Code
```java
public class EncodeAndDecodeStrings {
	class Solution {

	    public String encode(List<String> strs) {
	        StringBuilder sb = new StringBuilder();
	        for(String s: strs){
	            sb.append(s.length()).append('#').append(s);
	        }
	        return sb.toString();
	    }

	    public List<String> decode(String str) {
	        List<String> res = new ArrayList<>();
	        
	        int i = 0;

	        while(i < str.length()){
	            int j = i;
	            while(str.charAt(j) != '#'){
	                j++;
	            }
	            int length = Integer.parseInt(str.substring(i, j));
	            j++;
	            res.add(str.substring(j, j + length));
	            i = j + length;
	        }

	        return res;
	    }
	}
}

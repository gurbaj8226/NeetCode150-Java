#Valid Parentheses

**Category:** Stack (NeetCode)

**Difficulty:** Easy

**Time Complexity:** O(n)

**Space Complexity:** O(n)



##Problem Description

Given a string s containing just the characters '(', ')', '{', '}', '[', and ']', determine if the input string is valid. A string is valid if open brackets are closed by the same type of brackets and open brackets are closed in the correct order.


##Approach

- Use a stack to keep track of the opening brackets.
- Iterate through the String, and if a character is an opening bracket, push it to the stack. 
- Afterwards, check if the stack is not empty, and if not, make sure that if the character is an ending brace, that stack.pop has the corresponding opening brace. This indicates they are in the correct order. 
- If it matches, the element will be popped, and if it does not, it will return false. After iterating through the entire String, return if the stack is empty, which it should be since all the opening braces will get popped after meeting their corresponding ending brace. 

##Example

**Input:**

s = "()[]{}"

**Output:**

true



**Explanation:**

Each bracket type is opened and closed in the correct order.



**Input:**

s = "(]"

**Output:**

false



**Explanation:**

The closing bracket ] doesn’t match the previous opening bracket (.



##Java Code
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				char top = stack.pop();
				if (c == ')' && top != '(' || c == ']' && top != '[' || c == '}' && top != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

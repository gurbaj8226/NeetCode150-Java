# Evaluate Reverse Polish Notation

**Category:** Stacks (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n)  
**Space Complexity:** O(n)

## Problem Description
You are given an array of strings `tokens` representing an arithmetic expression in **Reverse Polish Notation (RPN)**.

Valid operators are: `+`, `-`, `*`, `/`.

Each operand may be an integer or negative integer.

Return the value of the expression.

RPN rules:
* Evaluate when you see an operator.
* Operators always apply to the **two most recent numbers**.

## Approach
* Use a **stack** to store integers.  
* For each token:
  * If it’s a number → push to stack.
  * If it’s an operator:
    * Pop the top two numbers: `b` then `a`.
    * Compute `a op b`.
    * Push the result back to the stack.
* At the end, the stack contains exactly **one** number → return it.

Notes:
* Division should truncate toward zero (Java handles this correctly).

## Example
**Input:**  
`["2","1","+","3","*"]`

**Output:**  
`9`  
Because `(2 + 1) * 3 = 9`

## Code (Java)
```java
public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack <Integer> s = new Stack<>();
        
        
        for(String t: tokens){
            if(t.equals("+")){
                int first = s.pop();
                int second = s.pop();
                s.push(first + second);
            }
            else if(t.equals("-")){
                int first = s.pop();
                int second = s.pop();
                s.push(second - first);
            }
            else if(t.equals("*")){
                int first = s.pop();
                int second = s.pop();
                s.push(first*second);
            }
            else if(t.equals("/")){
                int first = s.pop();
                int second = s.pop();
                s.push(second/first);
            }
            else{
                s.push(Integer.parseInt(t));
            }
        }
            return s.pop();
    }
}


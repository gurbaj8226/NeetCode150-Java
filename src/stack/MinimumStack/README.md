#Min Stack

**Category:** Stack (NeetCode)

**Difficulty:** Medium

**Time Complexity:** O(1) for all operations (push, pop, top, getMin)

**Space Complexity:** O(n)



##Problem Description

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

push(int val) – Pushes the element onto the stack.

pop() – Removes the element on the top of the stack.

top() – Gets the top element.

getMin() – Retrieves the minimum element in the stack.

pop, top, and getMin will always be called on non-empty stacks. 

##Approach
- Use two stacks, stack will hold all the values, and minStack will keep track of the current minimum value after each push. 
- When you push a value, push it to the stack, and if minStack is Empty or the value is less than the current top value of minStack, then push it to minStack as well. 
- When you pop, pop the value from the stack and if that value was also the top value in MinStack, then pop it there as well. 
- getMin() will return the top of the minimum value which we have been tracking, and since it is the top of a stack, it will be O(1) complexity. 

##Example


**Input:**

MinStack minStack = new MinStack();

minStack.push(-2);

minStack.push(0);

minStack.push(-3);

minStack.getMin();   // return -3

minStack.pop();

minStack.top();      // return 0

minStack.getMin();   // return -2

**Output:**

[-3, 0, -2]



##Java Code

class MinStack {

Stack<Integer> stack;
Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
       stack.push(val);
       if(minStack.isEmpty() || val<= minStack.peek())
    	   minStack.push(val);
    }
    
    public void pop() {
        int top = stack.pop();
        if(top == minStack.peek())
        	minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
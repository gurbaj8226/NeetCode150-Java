# Add Two Numbers

**Category:** Linked Lists (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n + m)  
**Space Complexity:** O(1)

## Problem Description
You are given two non-empty linked lists representing two non-negative integers.  
The digits are stored in reverse order, and each node contains a single digit.  
Add the two numbers and return the result as a linked list.  
You may assume the two numbers do not contain leading zeros except for the number 0 itself.

## Approach
* Use a dummy head to build the result list.  
* Use a **carry** value for digit overflow.  
* Traverse both lists until all digits and carry are processed.  
* At each step, compute:  
  - `sum = x + y + carry`  
  - Next node value = `sum % 10`  
  - Update carry = `sum / 10`

## Example
**Input:**  
l1 = [2,4,3]  
l2 = [5,6,4]

**Output:**  
[7,0,8]

**Explanation:**  
342 + 465 = 807

## Code
```java
package LinkedLists.AddTwoNumbers;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode node = dummy;

		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {

			int v1 = (l1 != null) ? l1.val : 0;
			int v2 = (l2 != null) ? l2.val : 0;

			int val = v1 + v2 + carry;

			carry = val / 10;
			val = val % 10;

			node.next = new ListNode(val);
			node = node.next;

			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}

		return dummy.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

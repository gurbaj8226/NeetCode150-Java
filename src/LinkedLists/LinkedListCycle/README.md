# Linked List Cycle

**Category:** Linked List (NeetCode)  
**Difficulty:** Easy  
**Time Complexity:** O(n)  
**Space Complexity:** O(1)

## Problem Description
Given the head of a linked list, determine whether the list contains a **cycle**.  
A cycle occurs when a node’s `next` pointer points to a previous node in the list.

## Approach
* Use **Floyd’s Tortoise and Hare Algorithm**:  
  * Use two pointers:  
    * `slow` moves 1 step  
    * `fast` moves 2 steps  
  * If there is **no cycle**, `fast` will eventually hit `null`.  
  * If there **is** a cycle, `fast` and `slow` will meet at some point.

## Example

**Input:**  
head = [3,2,0,-4], pos = 1

**Output:**  
true

**Explanation:**  
Node at index 1 forms a cycle by pointing back through the last node.

## Java Code
```java

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}
		return false;
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
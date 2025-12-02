# Remove Nth Node From End of List

**Category:** Linked List (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n)  
**Space Complexity:** O(1)

## Problem Description
Given the head of a linked list, remove the **n-th node from the end** of the list and return the updated head.

The solution must run in a single pass with constant extra memory.

## Approach
* Use the **two-pointer** technique:  
  - Create a dummy node pointing to head (handles edge cases).  
  - Move `fast` pointer `n` steps ahead.  
  - Then move `slow` and `fast` together until `fast` reaches the end.  
* Now `slow` is directly before the node to remove.  
* Adjust `slow.next` to skip the target node.

## Example
**Input:**  
`head = [1,2,3,4,5], n = 2`

**Output:**  
`[1,2,3,5]`  
(Remove 4, the 2nd node from the end)

## Java Code
```java
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while(n > 0){
            right = right.next;
            n--;
        }

        while(right != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
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
# Reverse Linked List

**Category:** Linked List (NeetCode)  
**Difficulty:** Easy  
**Time Complexity:** O(n)  
**Space Complexity:** O(1)

## Problem Description
Given the head of a singly linked list, reverse the list and return the new head.

A linked list is reversed by flipping the direction of its `next` pointers so that each node points to the previous node instead of the next.

## Approach
* Use three pointers to reverse the list in-place:
  * `prev` – points to the previous node (initially `null`)
  * `curr` – the current node being processed
  * `next` – temporarily stores `curr.next`
* Iterate through the linked list:
  * Save the next node  
  * Flip the `next` pointer  
  * Move `prev` and `curr` forward
* At the end, `prev` will be the new head of the reversed list.

This achieves an in-place reversal using only constant extra space.

## Example

**Input:**  
`head = [1,2,3,4,5]`

**Output:**  
`[5,4,3,2,1]`

**Explanation:**  
The list is reversed by redirecting each node's pointer to the previous node.

## Code (Java)

```java
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }

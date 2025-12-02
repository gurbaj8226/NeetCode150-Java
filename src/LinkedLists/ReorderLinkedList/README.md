# Reorder List

**Category:** Linked List (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n)  
**Space Complexity:** O(1)

## Problem Description
Given the head of a singly linked list, reorder it in the following form:

L0 → L1 → … → Ln-1 → Ln

becomes:

L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

You must reorder the list **in-place** without modifying node values.

## Approach
1. **Find the middle** using the fast/slow pointer technique.  
2. **Reverse the second half** of the list.  
3. **Merge the two halves** by alternating nodes:  
   - first from the left half  
   - then from the reversed right half  
4. Continue until the second half is exhausted.

This achieves O(1) auxiliary space and linear time.

## Example
**Input:**  
`1 → 2 → 3 → 4 → 5`

**Output:**  
`1 → 5 → 2 → 4 → 3`

## Java Code
```java

public class ReorderLinkedList {
	public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        ListNode prev = slow.next = null;

        while(second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;
        second = prev;

        while(second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
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
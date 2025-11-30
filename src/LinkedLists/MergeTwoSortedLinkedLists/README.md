# Merge Two Sorted Lists

**Category:** Linked List (NeetCode)  
**Difficulty:** Easy  
**Time Complexity:** O(n + m)  
**Space Complexity:** O(1)

## Problem Description
You are given the heads of two sorted singly linked lists `list1` and `list2`.  
Merge the two lists into one **sorted** list and return the head.  
You must merge the nodes by **relinking**, not by creating new nodes.

## Approach
* Create a **dummy node** to simplify pointer management.  
* Maintain a pointer `curr` that builds the merged list.  
* Compare values at `list1` and `list2`:  
  * Append the smaller value to `curr.next`.  
  * Move the pointer in the list from which the value was taken.  
* If one list becomes empty, attach the remainder of the other list.  
* Return `dummy.next` as the merged list.

## Example

**Input:**  
list1 = [1,2,4]  
list2 = [1,3,4]

**Output:**  
[1,1,2,3,4,4]

## Java Code
```java

public class MergeTwoSortedLinkedLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				node.next = list1;
				list1 = list1.next;
			} else {
				node.next = list2;
				list2 = list2.next;
			}
			node = node.next;
		}

		if (list1 != null) {
			node.next = list1;
		} else {
			node.next = list2;
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

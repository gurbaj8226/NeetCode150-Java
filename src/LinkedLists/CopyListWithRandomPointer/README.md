# Copy List With Random Pointer

**Category:** Linked Lists (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n)  
**Space Complexity:** O(n)

## Problem Description
You are given a linked list where each node has:
* `val`
* `next` pointer
* `random` pointer (may point to any node or null)

Return a **deep copy** of the list.  
The new list must not reuse any original nodes.

## Approach
* Step 1: Insert cloned nodes after every original node.  
  Example: A → B → C becomes A → A' → B → B' → C → C'
* Step 2: Assign `random` pointers for the cloned nodes.  
  If original node's random is R, then clone's random = R.next.
* Step 3: Detach the cloned list from the original.

This uses no extra hashmap, allowing O(1) additional space.

## Example
**Input:**  
A list with nodes:  
Node1.random → Node3  
Node2.random → Node1  
Node3.random → null

**Output:**  
A deep copy list with identical structure and random pointers.

## Code
```java
public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
		Node curr = head;

		while (curr != null) {
			Node copy = new Node(curr.val);
			copy.next = curr.next;
			curr.next = copy;
			curr = copy.next;
		}

		curr = head;

		while (curr != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}

		curr = head;
		Node newHead = head.next;

		while (curr != null) {
			Node copy = curr.next;
			curr.next = copy.next;

			if (copy.next != null) {
				copy.next = copy.next.next;
			}

			curr = curr.next;
		}

		return newHead;
	}

}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

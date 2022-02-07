package LinkedList;

import java.util.HashSet;

/*
 * Initialize two pointers, fast and slow to the head of the linked list.
 * Traverse through the linked list until the fast pointer doesn’t reach the end of the linked list.
 * If the fast pointer reaches the end, it means that the linked list doesn’t contain any cycle. Hence, return False.
 * Else, move the slow pointer by one node i.e. slow = slow -> next and fast pointer by two nodes i.e. fast = fast -> next -> next.
 * At any point, if the fast and the slow pointers point to the same node, return True as a loop has been detected.
 */

/*
 * Time Complexity: O(N), where N is the number of nodes of the linked list.
 * Space Complexity: O(1), as a map is used.
 */

public class DetectLoopLinkedList {

	static DetectNode head;

	class DetectNode {
		int data;
		DetectNode next;

		DetectNode(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectLoopLinkedList listObj = new DetectLoopLinkedList();

		listObj.push(20);
		listObj.push(4);
		listObj.push(15);
		listObj.push(10);

		/* Create loop for testing */
		// head-> 10 ->15 ->4 -> 20 ->10
		listObj.head.next.next.next.next = listObj.head;
		String out = listObj.detectLoop();
		System.out.println(out);
		removeLoop(head);
	}

	public void push(int new_data) {
		DetectNode new_node = new DetectNode(new_data);
		new_node.next = head;
		head = new_node;
	}

	String detectLoop() {

		if (head == null) {
			return "Empty Linked List";
		}

		DetectNode slow = head;
		DetectNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return "Loop Not Found";
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = fast.next;
		return "Loop found from " + slow.data + " looped to " + fast.data;
	}

	private static String removeLoop(DetectNode h) {
		// TODO Auto-generated method stub

		HashSet<DetectNode> s = new HashSet<DetectNode>();
		DetectNode prev = null;
		while (h != null) {
			// If we have already has this node
			// in hashmap it means their is a cycle and we
			// need to remove this cycle so set the next of
			// the previous pointer with null.

			if (s.contains(h)) {
				System.out.println("Loop Data  : " + prev.next.data);
				prev.next = null;
				return "Loop Removed";
			}

			// If we are seeing the node for
			// the first time, insert it in hash
			else {
				s.add(h);
				prev = h;
				h = h.next;
			}
		}

		return "Nothing to remove";

	}

}

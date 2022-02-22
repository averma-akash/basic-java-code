package interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

public class RemoveDuplicateLinkedList {
	// Helper function to print a given linked list
	public static void printList(Node head) {
		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + " —> ");
			ptr = ptr.next;
		}
		System.out.println("null");
	}

	// Function to remove duplicates from a sorted list
	public static Node removeDuplicates(Node head) {
		Node previous = null;
		Node current = head;

		// take an empty set to store linked list nodes for future reference
		Set<Integer> set = new HashSet<>();
		List<Integer> duplicateElements = new ArrayList<>();

		// do till the linked list is empty
		while (current != null) {
			// if the current node is seen before, ignore it
			if (set.contains(current.data)) {
				previous.next = current.next;
				duplicateElements.add(current.data);
				
			} else {
				// insert the current node into the set and proceed to the next node
				set.add(current.data);
				previous = current;
			}
			current = previous.next;
		}
		System.out.println("Duplicate Elements : " +duplicateElements);
		return head;
	}

	public static void main(String[] args) {
		// input keys
		int[] keys = { 5,1,1, 2, 2, 2, 4, 3,3 };

		// points to the head node of the linked list
		Node head = null;

		// construct a linked list
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new Node(keys[i], head);
		}
		printList(head);
		removeDuplicates(head);

		// print linked list
		printList(head);
	}
}

/*
The time complexity of the above solution is O(n), where n is the total number of nodes in the linked list. The auxiliary space required by the program is O(n).

https://www.techiedelight.com/remove-duplicates-sorted-linked-list/
*/
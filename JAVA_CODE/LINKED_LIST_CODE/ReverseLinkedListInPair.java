package LinkedList;

public class ReverseLinkedListInPair {

	private Node head;

	private static class Node {
		private int value;
		private Node next;

		Node(int value) {
			this.value = value;

		}
	}

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	// Reverse linked list in pair
	public static Node reverseLinkedListInPairs(Node head) {

		Node current = head;
		Node temp = null;
		Node newHead = null;
		while (current != null && current.next != null) {

			if (temp != null) {
				// This is important step
				temp.next.next = current.next;
			}
			temp = current.next;
			current.next = temp.next;
			temp.next = current;

			if (newHead == null)
				newHead = temp;
			current = current.next;

		}
		return newHead;
	}

	public static void main(String[] args) {
		ReverseLinkedListInPair list = new ReverseLinkedListInPair();
		// Creating a linked list
		Node head = new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(8));

		list.printList(head);
		// Reversing LinkedList in pairs
		Node result = reverseLinkedListInPairs(head);
		System.out.println("After reversing in pair");
		list.printList(result);
	}

}

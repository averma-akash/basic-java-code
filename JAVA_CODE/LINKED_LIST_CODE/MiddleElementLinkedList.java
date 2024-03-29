package interview.nagarro;

class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;

	}
}

public class MiddleElementLinkedList {
	
	private Node head;
	
	public static void main(String[] args) {
		MiddleElementLinkedList list = new MiddleElementLinkedList();
		// Creating a linked list
		Node head = new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(21));
		list.addToTheLast(new Node(8));

		list.printList();
		// finding middle element
		Node middle = list.findMiddleNode(head);
		System.out.println("Middle node will be: " + middle.value);

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

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	// This function will find middle element in linkedlist
	public Node findMiddleNode(Node head) {
		Node slowPointer, fastPointer;
		slowPointer = fastPointer = head;

		while (fastPointer != null) {
			fastPointer = fastPointer.next;
			if (fastPointer != null && fastPointer.next != null) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
		}

		return slowPointer;

	}

}

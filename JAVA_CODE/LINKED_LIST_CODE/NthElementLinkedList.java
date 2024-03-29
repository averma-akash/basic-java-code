package LinkedList;

/*
 * Algorithm for this problem would be :
	Use two pointer firstPtr and secondPtr and initialize both to head of linkedlist
	Move firstPtr by n-1 nodes.
	Increment firstPtr and secondPtr until firstPtr.next not equal to null.
	SecondPtr will be at nth from end node.
 */

package interview.nagarro;

class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;

	}
}

public class NthElementLinkedList {

	private Node head;
	
	public static void main(String[] args) {
		NthElementLinkedList list = new NthElementLinkedList();
		// Creating a linked list
		Node head = new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(8));

		list.printList();
		// Finding 3rd node from end
		Node nthNodeFromLast = list.nthFromLastNode(head, 4);
		System.out.println("node from end is : " + nthNodeFromLast.value);

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

	public Node nthFromLastNode(Node head, int n) {
		Node firstPtr = head;
		Node secondPtr = head;

		for (int i = 0; i < n; i++) {
			firstPtr = firstPtr.next;

		}

		while (firstPtr != null) {
			firstPtr = firstPtr.next;
			secondPtr = secondPtr.next;
		}

		return secondPtr;
	}

}


/*

5 6 7 1 2 8 
3th node from end is : 1

*/
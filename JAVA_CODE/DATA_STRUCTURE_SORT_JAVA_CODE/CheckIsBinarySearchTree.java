package Sorting;
/*
 * we can looks at each node only once. we will write a utility helper function that traverses down the tree keeping track 
 * of the narrowing min and max allowed values as it goes, looking at each node only once. 
 * The initial values for min and max should be INT_MIN and INT_MAX — they narrow from there. 

	Note: This method is not applicable if there are duplicate elements with value INT_MIN or INT_MAX.
 * 
 * 
 */
class AddNode {
	int data;
	AddNode left;
	AddNode right;

	public AddNode(int item) {
		data = item;
		left = right = null;
	}
}
/*Time Complexity: O(n) 
Auxiliary Space: O(1) if Function Call Stack size is not considered, otherwise O(n)
*/
public class CheckIsBinarySearchTree {

	// Root of the Binary Tree
	AddNode root;

	/*
	 * can give min and max value according to your code or can write a function to
	 * find min and max value of tree.
	 */

	/*
	 * returns true if given search tree is binary search tree (efficient version)
	 */
	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <= max.
	 */
	boolean isBSTUtil(AddNode node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		CheckIsBinarySearchTree tree = new CheckIsBinarySearchTree();
		tree.root = new AddNode(4);
		tree.root.left = new AddNode(2);
		tree.root.right = new AddNode(5);
		tree.root.left.left = new AddNode(1);
		tree.root.left.right = new AddNode(3);

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}

}

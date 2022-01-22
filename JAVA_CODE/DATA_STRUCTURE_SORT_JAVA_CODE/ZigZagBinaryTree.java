package Sorting;

//import statement  
import java.util.*;

//instantiating this class   
//creates a node  
class TreeNode {
//for holding value of the node  
	int val;
//for referring to the other nodes   
//left for the left child and right to the right child  
	TreeNode left, right;

//constructor of the class TreeNode  
//the construct initializes the class fields  
	public TreeNode(int i) {
		val = i;
		right = left = null;
	}
}

public class ZigZagBinaryTree {

	TreeNode r = null;

	public static void main(String[] argvs) {
//creating an object of the class ZigZagTraversalExample3   
		ZigZagBinaryTree tree = new ZigZagBinaryTree();
//root node  
		tree.r = new TreeNode(18);
//remaining nodes of the tree  
		tree.r.left = new TreeNode(20);
		tree.r.right = new TreeNode(30);
		tree.r.left.left = new TreeNode(60);
		tree.r.left.right = new TreeNode(34);
		tree.r.right.left = new TreeNode(45);
		tree.r.right.right = new TreeNode(65);
		tree.r.left.left.left = new TreeNode(12);
		tree.r.left.left.right = new TreeNode(50);
		tree.r.left.right.left = new TreeNode(98);
		tree.r.left.right.right = new TreeNode(82);
		tree.r.right.left.left = new TreeNode(31);
		tree.r.right.left.right = new TreeNode(59);
		tree.r.right.right.left = new TreeNode(71);
		tree.r.right.right.right = new TreeNode(41);
		System.out.println("The zigzag traversal of the binary tree is: ");

		// using stack and queue:
		System.out.println("\nThe zigzag traversal of the binary tree using stack and queue: ");
		ArrayList<Integer> list = tree.usingStackQueue(tree.r);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("\n \nThe zigzag traversal of the binary tree recursion: ");
		tree.usingBinaryTreeRecurssion(tree.r);

		System.out.println("\n \nThe zigzag traversal of the binary tree using two Stack: ");
		tree.usingTwoStacks();
	}

// *********** Using two Stack Starts ************
	/*
	 * Time Complexity: There is only one while loop in the program. Therefore, the
	 * time complexity of the above program is O(n), where n is the total number of
	 * nodes present in the binary tree. Space Complexity: There are two stacks
	 * present in the program; each stack takes the space complexity of O(n), where
	 * n is the total number of nodes present in the binary tree. Thus, O(n) + O(n)
	 * = O(2 * n), which in terms of asymptotic complexity is equal to O(n).
	 */
	void usingTwoStacks() {
		// if node is null then return
		if (r == null) {
			return;
		}
		// declaring two stacks
		// currLevel and the nextLevel stack
		Stack<TreeNode> currLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		// push the root
		currLevel.push(r);
		boolean LtoR = true;
		// check if the stack is empty
		while (!currLevel.isEmpty()) {
			// the node is popped out
			// from the current level stack
			TreeNode currNode = currLevel.pop();
			// display the value of it
			System.out.print(currNode.val + " ");
			// store the data according to the current order.
			// if LtoR is true, then the traversal is from left to right
			// and if LtoR is false, then the traversal is from right to left
			if (LtoR) {
				if (currNode.left != null) {
					nextLevel.push(currNode.left);
				}
				if (currNode.right != null) {
					nextLevel.push(currNode.right);
				}
			} else {
				if (currNode.right != null) {
					nextLevel.push(currNode.right);
				}
				if (currNode.left != null) {
					nextLevel.push(currNode.left);
				}
			}
			if (currLevel.isEmpty()) {
				// toggle the value of LtoR
				LtoR = !LtoR;
				// interchanging the currLevel stack
				// and the nextLevel stack
				Stack<TreeNode> stk = currLevel;
				currLevel = nextLevel;
				nextLevel = stk;
			}
		}
	}
	// *********** Using two Stack ENDS ************

	// *********** Using RECURSION Starts ************

	// Recursive method for finding the height of the binary tree
	// note that total levels in a tree are equal
	// to the height of the tree
	// height of the tree (taking reference from the root node) is equal to the
	// max(height of the left subtree, height of the right subtree) + 1
	public int heightOfBTree(TreeNode r) {
		// base case
		if (r == null) {
			return 0;
		}
		int lh = heightOfBTree(r.left);
		int rh = heightOfBTree(r.right);
		return Math.max(lh + 1, rh + 1);
	}

	// Method for printing the node values from right to left
	public void displayRightToLeft(TreeNode r, int lvl) {
		// base case
		if (r == null) {
			return;
		}
		if (lvl == 1) {
			System.out.print(r.val + " ");
		} else if (lvl > 1) {
			displayRightToLeft(r.right, lvl - 1);
			displayRightToLeft(r.left, lvl - 1);
		}
	}

	// Method for priting the node values from left to right
	public void displayLeftToRight(TreeNode r, int lvl) {
		// base case
		if (r == null) {
			return;
		}
		// handling the root node
		if (lvl == 1) {
			System.out.print(r.val + " ");
		}
		// handling the other nodes of the binary tree
		else if (lvl > 1) {
			displayLeftToRight(r.left, lvl - 1);
			displayLeftToRight(r.right, lvl - 1);
		}
	}

	// Method that prints the zigzag traversal of the binary tree
	/**
	 * Time Complexity: Since we are visiting a node only once; therefore, the time
	 * complexity of the above program is O(n), where n represents the total number
	 * of nodes present in the binary tree. Space Complexity: The space complexity
	 * of the above program is O(n).
	 */
	public void usingBinaryTreeRecurssion(TreeNode r) {
		// a variable f is used for marking the change
		// in the level
		int f = 0;
		// Height of the tree
		int ht = heightOfBTree(r);
		// a loop for iterating across the levels
		//
		for (int j = 1; j <= ht; j++) {
			// If the flag value is one then display nodes from right to left
			if (f == 1) {
				// printing from right to left for the level j
				displayRightToLeft(r, j);
				// after the traversal of the level j is finished
				// toggle the value of f from 1 to 0
				f = 1 - f;
			}
			// If the flag value is one then display nodes from right to left
			else if (f == 0) {
				// printing from left to right for the level j
				displayLeftToRight(r, j);
				// after the traversal of the level j is finished
				// toggle the value of f from 1 to 0
				f = 1 - f;
			}
		}
	}

	// *********** Using RECURSION ENDS ************

	// *********** Using STACK QUEUE Starts ************

	ArrayList<Integer> usingStackQueue(TreeNode root) {
		/*
		 * Time Complexity: For the above program, the time complexity is O(n), where n
		 * represents the total number of nodes present in the binary tree. Space
		 * Complexity: The space complexity of the above program is O(n).
		 */
		// storing the element that has been traversed during zigzag traversal
		ArrayList<Integer> keep = new ArrayList<Integer>();
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		// the stack will be used when we traverse from left to right
		// and the stored nodes will be used when we traverse from right to left
		Stack<TreeNode> currentLevelNodes = new Stack<TreeNode>();
		nodes.add(root);
		// the value of l to r (left to right)
		// will vary from 0 to 1
		int ltor = 1;
		while (!nodes.isEmpty()) {
			if (ltor == 1) {
				int size = nodes.size();
				for (int j = 0; j < size; j++) {
					TreeNode currNode = nodes.peek();
					nodes.poll();
					keep.add(currNode.val);
					if (currNode.left != null) {
						nodes.add(currNode.left);
						// adding nodes to the stack
						currentLevelNodes.push(currNode.left);
					}
					if (currNode.right != null) {
						nodes.add(currNode.right);
						// adding nodes to the stack
						currentLevelNodes.push(currNode.right);
					}
				}
			} else {
				int size = nodes.size();
				for (int j = 0; j < size; j++) {
					TreeNode currentNode = nodes.peek();
					nodes.poll();
					// using the stored nodes
					keep.add(currentLevelNodes.peek().val);
					currentLevelNodes.pop();
					if (currentNode.left != null) {
						nodes.add(currentNode.left);
					}
					if (currentNode.right != null) {
						nodes.add(currentNode.right);
					}
				}
			}
			// toggling between 0 & 1
			ltor = 1 - ltor;
		}
		return keep;
	}

	// *********** Using RECURSION ENDS ************
}
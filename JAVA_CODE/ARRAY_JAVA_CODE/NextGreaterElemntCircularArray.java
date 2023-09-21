package practicebook.java;

import java.util.Stack;

/*
 * Time Complexity: O(N)
	Auxiliary Space: O(N)
 */

public class NextGreaterElemntCircularArray {
	public static void main(String[] args) {
		int[] arr = { 8, 6, 7 };
		printNGE(arr);

	}

	private static void printNGE(int[] arr) {
		// TODO Auto-generated method stub

		Stack<Integer> stack = new Stack<>();
		int n = arr.length;
		int[] result = new int[n];

		for (int i = 2 * n - 1; i >= 0; i--) {

			// Remove all the elements in Stack that are less than arr[i%n]
			while (!stack.isEmpty() && arr[i % n] >= stack.peek()) {
				stack.pop();
			}
			if (i < n) {
				if (!stack.isEmpty())
					result[i] = stack.peek();
				else
					result[i] = -1; // When none of elements in Stack are greater than arr[i%n]
			}
			stack.push(arr[i % n]);
		}
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
/*
-1, 7, 8

In a circular array, the indices will wrap around as if it were connected end-to-end. 
In other words, the end of the array wraps around to the start of the array. Therefore,
 we can search circularly to find the next greater number. 
 If the next greater element doesn’t exist, consider it to be -1.
*/
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

	public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; 
        Arrays.fill(result, -1); // Default value for elements with no greater value
        Stack<Integer> stack = new Stack<>(); // Stores indices, not values

        // Traverse the array **twice** to handle the circular condition
        for (int i = 0; i < 2 * n; i++) {
            int num = arr[i % n]; // Circular index
            
            // Process elements in stack: Pop smaller elements
            while (!stack.isEmpty() && arr[stack.peek()] < num) {
                result[stack.pop()] = num;
            }

            // Push index in the first pass only (not in second pass)
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result;
    }

}
/*
-1, 7, 8

Time Complexity: 𝑂(𝑛)
Each element is pushed once and popped once → 𝑂(𝑛)
Traversing twice still keeps it	O(n).
Space Complexity:  O(n) (Stack for indices + result array)

In a circular array, the indices will wrap around as if it were connected end-to-end. 
In other words, the end of the array wraps around to the start of the array. Therefore,
 we can search circularly to find the next greater number. 
 If the next greater element doesn’t exist, consider it to be -1.
*/
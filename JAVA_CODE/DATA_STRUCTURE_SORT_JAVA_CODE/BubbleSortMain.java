/* Bubble sort works on the repeatedly swapping of adjacent elements until they are not in the intended order. 
* Best Case	O(n)
* Average Case	O(n2)
* Worst Case	O(n2)
* Space Complexity 	O(1)
*
*/

package Sorting;

public class BubbleSortMain {

	public static void main(String args[]) {
		int arr[] = { 100, 20, 15, 30, 5, 75, 40 };
		bubbleSort(arr);

	}

	public static int[] bubbleSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.print("Iteration " + (i + 1) + ": ");
			printArray(arr);
		}
		return arr;
	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

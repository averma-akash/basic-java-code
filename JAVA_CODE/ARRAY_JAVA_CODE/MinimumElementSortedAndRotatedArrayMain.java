package practicebook.java;

public class MinimumElementSortedAndRotatedArrayMain {

	public static void main(String[] args) {
		int arr[] = { 16, 19, 21, 25, 3, 5, 8, 10 };
		System.out.println(
				"Minimum element in the array : " + findMinimumElementRotatedSortedArray(arr, 0, arr.length - 1));
	}

	public static int findMinimumElementRotatedSortedArray(int[] arr, int low, int high) {
		int mid;
		while (low < high) {
			mid = low + ((high - low) / 2);

			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return arr[low];
	}
}
//Minimum element in the array : 3
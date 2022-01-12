package Sorting;

public class BinarySerarchMain {

	public static int binarySearch(int[] sortedArray, int elementToBeSearched) {
		int first = 0;
		int last = sortedArray.length - 1;

		while (first <= last) {

			int mid = (first + last) / 2; // Compute mid point.

			if (elementToBeSearched < sortedArray[mid]) {
				last = mid - 1; // repeat search in first half.
			} else if (elementToBeSearched > sortedArray[mid]) {
				first = mid + 1; // Repeat sortedArray in last half.
			} else {
				return mid; // Found it. return position
			}
		}

		return -1; // Failed to find element
	}

	public static void main(String[] args) {

		int[] sortedArray = { 12, 56, 74, 96, 112, 114, 123, 567 };
		int indexOfElementToBeSearched = binarySearch(sortedArray, 74);
		System.out.println("Index of 74 in array is: " + indexOfElementToBeSearched);

		int indexOfElementToBeSearchedNotFound = binarySearch(sortedArray, 7);
		System.out.println("Index of 7 in array is: " + indexOfElementToBeSearchedNotFound);
	}

}

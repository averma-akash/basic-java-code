package interview;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 2, 3, 1, 5 };
		int n = 7;
		System.out.println(majorityElement(arr, n));
	}

	private static String majorityElement(int[] arr, int n) {
		Arrays.sort(arr);
		int count = 1, max_ele = -1, temp = arr[0], ele = 0, f = 0;
		for (int i = 1; i < n; i++) {

			/*
			 * Increases the count if the same element occurs otherwise starts counting new
			 * element
			 */
			if (temp == arr[i]) {
				count++;
			} else {
				count = 1;
				temp = arr[i];
			}

			/*
			 * Sets maximum count and stores maximum occurred element so far if maximum
			 * count becomes greater than n/2 it breaks out setting the flag
			 */
			if (max_ele < count) {
				max_ele = count;
				ele = arr[i];

				if (max_ele > (n / 2)) {
					f = 1;
					break;
				}
			}
		}

		// Returns maximum occurred element
		// if there is no such element, returns -1
		return (f == 1 ? "Majority Element " + ele : "No majority element");
	}

}
/*
 * Time Complexity: O(nlogn). Sorting requires O(n log n) time complexity.
 * Auxiliary Space: O(1). As no extra space is required.
 */

/*
 private static void majorityElement(int[] arr, int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int count = map.get(arr[i]) + 1;
				if (count > arr.length / 2) {
					System.out.println("Majority found :- " + arr[i]);
					return;
				} else
					map.put(arr[i], count);

			} else
				map.put(arr[i], 1);
		}
		System.out.println(" No Majority element");
	}
	
	Time Complexity: O(n). 
One traversal of the array is needed, so the time complexity is linear.
Auxiliary Space: O(n). 
Since a hashmap requires linear space.
*/

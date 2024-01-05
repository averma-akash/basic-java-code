package practicebook.java;

public class FindLargestSmallestNumberMain {
	
	public static void main(String[] args) {

		firstWayNormalForLoop();
		secondWay();
		thirdWay();
	}

	private static void firstWayNormalForLoop() {
		// array of 10 numbers
		int arr[] = new int[] { 12, 56, 76, 89, 100, 343, 21, 234 };
		/// assign first element of an array to largest and smallest
		int largest = arr[0];
		int smallest = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest)
				largest = arr[i];
			else if (arr[i] < smallest)
				smallest = arr[i];
		}
		System.out.println("Max : " + largest + "  Min : " + smallest);
	}

	private static void secondWay() {
		int arr[] = { 2, 3, 1, 22, 11, 33, 5 };
		int max = Arrays.stream(arr).boxed().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b)).intValue();
		int min = Arrays.stream(arr).boxed().reduce(Integer.MAX_VALUE, (a, b) -> Integer.min(a, b)).intValue();
		System.out.println("Max : " + max + "  Min : " + min);

	}

	private static void thirdWay() {
		int arr[] = { 2, 3, 22, 11, 33, 5, 99 };
		// Using the method reference;
		int max1 = Arrays.stream(arr).boxed().reduce(Integer::max).get();
		int min1 = Arrays.stream(arr).boxed().reduce(Integer::min).get();
		System.out.println("Max : " + max1 + "  Min : " + min1);
	}

}
/*
Max : 343  Min : 12
Max : 33  Min : 1
Max : 99  Min : 2
*/
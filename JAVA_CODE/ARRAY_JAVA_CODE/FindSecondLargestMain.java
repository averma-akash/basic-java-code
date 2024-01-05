package practicebook.java;

public class FindSecondLargestMain {
	
	public static void main(String args[]) {
		firstWay();
		secondWay();
	}

	private static void firstWay() {

		int a[] = { 3, 6, 32, 1, 8, 5, 31, 22 };
		int secundMax = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).skip(1).findAny().get();
		System.out.println("Second largest element in the array : " + secundMax);
	}

	private static void secondWay() {
		int[] array = { 17, 15, 6, 11, 24, 32 };
		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > highest) {
				secondHighest = highest;
				highest = array[i];
			} else if (array[i] > secondHighest && array[i] != highest)
				secondHighest = array[i];
		}
		System.out.println("Second largest element in the array : " + secondHighest);
	}

}
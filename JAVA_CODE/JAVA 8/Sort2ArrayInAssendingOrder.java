package interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatteringList {
	// Output : [0, 3, 4, 5, 7, 9, 11, 12, 13, 22]
	public static void main(String[] args) {
		int i[] = { 4, 5, 13, 22 };
		int j[] = { 0, 9, 3, 7, 12, 11 };
		List<Integer> sortedList = Stream.concat(Arrays.stream(i).boxed(), Arrays.stream(j).boxed()).sorted()
				.collect(Collectors.toList());
		System.out.println(sortedList);
	}
	// Sort Array 2 ways
	public static void main(String[] args) {
		int a[] = { 3, 6, 32, 1, 8, 5, 31, 22 };
		List<Integer> newArra = Arrays.stream(a).boxed().sorted().collect(Collectors.toList());
		System.out.println("1st way : "+newArra);
		Arrays.sort(a);
		System.out.println("2nd way : "+Arrays.toString(a));
	}
}

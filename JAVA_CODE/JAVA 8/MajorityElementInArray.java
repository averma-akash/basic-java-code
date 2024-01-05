package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElementInArray {
	public static void main(String[] args) {
		int majorityArray[] = { 5, 3, 2, 1, 2, 4, 3, 2, 2, 6, 2, 3, 2, 2, 2 };
		int notMajorityArray[] = { 3, 6, 32, 1, 8, 5, 31, 22 };
		printMajorityElementByJava8(majorityArray);
		printMajorityElementByJava8(notMajorityArray);
	}

	private static void printMajorityElementByJava8(int a[]) {
		int majorityElement = Arrays.stream(a).boxed()
				.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting())).entrySet()
				.stream().filter(k -> k.getValue() >= a.length / 2).map(Entry::getKey).findFirst().orElse(0);
		System.out.println("Majority element in array : " + majorityElement);
	}
}

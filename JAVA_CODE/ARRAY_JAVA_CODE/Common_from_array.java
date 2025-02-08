package interview.nagarro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Common_from_array {

	public static void main(String[] args) {

		String data = " I am from India and my name is Akash Verma";

		Map<Character, Long> charWithCOunt = data.chars().mapToObj(d -> (char) d)
				.filter(d -> !Character.isWhitespace(d))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("character with count : " + charWithCOunt);

		charWithCOunt.entrySet().stream().filter(entry -> entry.getValue() == Collections.min(charWithCOunt.values()))
				.map(Map.Entry::getKey).collect(Collectors.toList())
				.forEach(e -> System.out.println(e + " with frequency : " + Collections.min(charWithCOunt.values())));

		findCommonElementSortedArray();

		findNonCommonElementSortedArray();
	}

	private static void findCommonElementSortedArray() {
		int[] arr1 = { 1, 2, 3, 5, 10 };
		int[] arr2 = { 1, 3, 5, 7, 10 };
		int[] arr3 = { 1, 3, 5, 9, 10 };

		Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
		Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
		Set<Integer> set3 = Arrays.stream(arr3).boxed().collect(Collectors.toSet());

		Set<Integer> result = set1.stream().filter(set2::contains).filter(set3::contains).collect(Collectors.toSet());
		System.out.println(result);

		/*
		 * 2nd way two pointer way
		 */
		int i = 0, j = 0, l = 0;
		List<Integer> common = new ArrayList<>();
		while (i < arr1.length && j < arr2.length && l < arr3.length) {

			if (arr1[i] == arr2[j] && arr2[j] == arr3[l]) {
				common.add(arr1[i]);
				i++;
				j++;
				l++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr2[j] < arr3[l]) {
				j++;
			} else {
				l++;
			}
		}
		System.out.println(common);

		/*
		 * Different elements
		 * 
		 */

	}

	private static void findNonCommonElementSortedArray() {

		int[] arr1 = { 1, 2, 3, 5, 10 };
		int[] arr2 = { 1, 3, 5, 7, 10 };
		int[] arr3 = { 1, 3, 5, 9, 10 };

		Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
		Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
		Set<Integer> set3 = Arrays.stream(arr3).boxed().collect(Collectors.toSet());

		Set<Integer> allElements = new HashSet<>();
		allElements.addAll(set1);
		allElements.addAll(set2);
		allElements.addAll(set3);

		Set<Integer> result = set1.stream().filter(set2::contains).filter(set3::contains).collect(Collectors.toSet());

		allElements.removeAll(result);
		// Print uncommon elements
		System.out.println("Uncommon Elements: " + allElements);

	}
}
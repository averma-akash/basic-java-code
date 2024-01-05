package interview.nagarro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateOrPrintDuplicate {

	public static void main(String[] args) {
		printDuplicate();
		System.out.println("*************");
		removeDuplicate();
	}

	private static void removeDuplicate() {
		List<Integer> myList = Arrays.asList(10, 15, 15, 25, 44, 25);
		Set<Integer> inSet = new HashSet<>(myList);
		inSet.stream().forEach(System.out::println);
	}

	private static void printDuplicate() {
		List<Integer> myList = Arrays.asList(10, 15, 15, 25, 44, 25);
		Set<Integer> inSet = new HashSet<>();
		myList.stream().filter(n -> !inSet.add(n)).forEach(System.out::println);
	}
}
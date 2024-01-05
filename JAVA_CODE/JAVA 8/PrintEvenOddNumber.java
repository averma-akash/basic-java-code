package interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintEvenOddNumber {
	public static void main(String[] args) {
		printEvenNumber();
		printOddNumber();
	}

	private static void printEvenNumber() {
		IntStream.rangeClosed(0, 10).filter(x -> x % 2 == 0).forEach(System.out::println);
	}

	private static void printOddNumber() {
		IntStream.rangeClosed(0, 10).filter(x -> x % 2 != 0).forEach(System.out::println);
	}
}

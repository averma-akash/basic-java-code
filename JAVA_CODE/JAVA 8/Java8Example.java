package interview.nagarro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Example {

	private static void integerWork(List<Integer> integer) {
		// find Largest number in List using reduce(Integer::max).get()
		int max1 = integer.stream().reduce(Integer::max).get();
		
		System.out.println(max1);

	}

	private static void stringWork(List<String> st) {

		// start with example
		st.stream().filter(e -> !e.startsWith("A")).forEach(System.out::println);
		// List to map with filter
		Map<String, String> collect = st.stream().filter(e -> !e.startsWith("A"))
				.collect(Collectors.toMap(e -> e, e -> e));
		// List to map without filter
		Map<String, String> collect2 = st.stream().collect(Collectors.toMap(e -> e, e -> e));
		// List contains a particular match
		boolean anyMatch = st.stream().anyMatch(e -> e.equalsIgnoreCase("RAM"));
		// longest string in list
		String longestStr = st.stream().collect(Collectors.maxBy(Comparator.comparingInt(String::length))).get();
		String longestStr1 = st.stream().reduce((x, y) -> x.length() > y.length() ? x : y).get();
		// length of above string
		int max = st.stream().collect(Collectors.summarizingInt(String::length)).getMax();
		
		System.out.println(collect);
		System.out.println(collect2);
		System.out.println(anyMatch);
		System.out.println(longestStr);
		System.out.println(max);
		System.out.println(longestStr1);

	}

	public static void main(String[] args) {
		List<String> st = new ArrayList<>();
		st.add("Akash");
		st.add("Anjali");
		st.add("Vivek");
		st.add("RAM");

		List<Integer> integer = new ArrayList<>();
		integer.add(12);
		integer.add(333);
		integer.add(678);
		integer.add(34);

		stringWork(st);
		integerWork(integer);

	}

}

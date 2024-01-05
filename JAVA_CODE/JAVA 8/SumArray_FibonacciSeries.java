package interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumArray {
	public static void main(String[] args) {
		firstWay();
		secondWay();
	}

	private static void firstWay() {
		int a[] = { 3, 6, 32, 1, 8, 5, 31, 22 };
		int sum = Arrays.stream(a).boxed().reduce(0, (x, y) -> x + y).intValue();
		System.out.println(sum);
	}

	private static void secondWay() {
		int a[] = { 3, 6, 32, 1, 8, 5, 31, 22 };
		int sumValue = Arrays.stream(a).boxed().collect(Collectors.summingInt(Integer::intValue));
		System.out.println(sumValue);
	}
}

//Fibonacci Series
public static void main(String[] args) {
		Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(10).map(f -> f[0])
				.forEach(System.out::println);
	}

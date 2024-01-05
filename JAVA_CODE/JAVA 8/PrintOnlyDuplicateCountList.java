package interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintOnlyDuplicateCountList {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Java", "Spring", "JPA", "Java", "Cloud", "JPA");
		Map<String, Long> namesCount = names.stream().filter(x -> Collections.frequency(names, x) > 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(namesCount);
	}
}
//{Java=2, JPA=2}
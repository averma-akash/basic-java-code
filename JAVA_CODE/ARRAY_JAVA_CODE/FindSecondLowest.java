package practicebook.java;

public class FindSecondLowest {
	public static void main(String[] args) {
		int a[] = { 3, 6, 32, 1, 8, 5, 31, 22, 2 };
		int secundMin = Arrays.stream(a).boxed().sorted().skip(1).findAny().get();
		System.out.println(secundMin);
	}
}
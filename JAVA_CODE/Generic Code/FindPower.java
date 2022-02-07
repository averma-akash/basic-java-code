package practicebook.java;

public class FindPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -2;
		int y = 2;
		System.out.println(power(x, y));

	}

	private static int power(int x, int y) {
		// TODO Auto-generated method stub
		// If x^0 return 1
		if (y == 0)
			return 1;

		// If we need to find of 0^y
		if (x == 0)
			return 0;

		// For all other cases
		return x * power(x, y - 1);
	}

}
//Time Complexity: O(n)
//Auxiliary Space: O(1)
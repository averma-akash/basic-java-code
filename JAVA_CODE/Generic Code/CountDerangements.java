package practicebook.java;

/*
 * As we only need to remember only two previous values So,
 * instead of Storing the values in an array two variables can be used to just store the required previous only.
 * Time Complexity: O(n) 
 * Auxiliary Space: O(1)
 */
public class CountDerangements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		//{0,1,2,3}
		System.out.println("Count of Dearrangements is " + getCountDerangements(n));
		smallestDerangements(n);
	}

	private static int getCountDerangements(int n) {
		// TODO Auto-generated method stub
		// Base case
		if (n == 1 || n == 2) {
			return n - 1;
		}

		// Variable for storing prev values
		int a = 0;
		int b = 1;

		// manner using above recursive formula
		for (int i = 3; i <= n; ++i) {
			int cur = (i - 1) * (a + b);
			a = b;
			b = cur;
			System.out.println(a + " " + b);
		}
		// Return result for n
		return b;
	}

	
	/*Smallest Derangement of Sequence */
	private static void smallestDerangements(int N) {
		// TODO Auto-generated method stub
		{
			// Generate Sequence S
			int S[] = new int[N + 1];
			for (int i = 1; i <= N; i++)
				S[i] = i;

			// Generate Derangement
			int D[] = new int[N + 1];
			for (int i = 1; i <= N; i += 2) {
				if (i == N) {

					// Only if i is odd
					// Swap S[N-1] and S[N]
					D[N] = S[N - 1];
					D[N - 1] = S[N];
				} else {
					D[i] = i + 1;
					D[i + 1] = i;
				}
			}

			// Print Derangement
			for (int i = 1; i <= N; i++)
				System.out.print(D[i] + " ");
			System.out.println();
		}
	}
}

package interview;

import java.util.*;

public class palindromeCheck {
	// To check sentence is palindrome or not
	static boolean canFormPalindrome(String str) {

		// Create a list
		List<Character> list = new ArrayList<Character>();

		// For each character in input strings,
		// remove character if list contains
		// else add character to list
		for (int i = 0; i < str.length(); i++) {
			if (list.contains(str.charAt(i)))
				list.remove((Character) str.charAt(i));
			else
				list.add(str.charAt(i));
		}

		// if character length is even
		// list is expected to be empty or
		// if character length is odd list size
		// is expected to be 1

		// if string length is even
		if (str.length() % 2 == 0 && list.isEmpty() || (str.length() % 2 == 1 && list.size() == 1))
			return true;

		// if string length is odd
		else
			return false;
	}

	// Driver code
	public static void main(String args[]) {
		if (sentencePalindrome("Too hot to hoot"))
			System.out.println("Yes");
		else
			System.out.println("No");

		if (canFormPalindrome("geeksogeeks"))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	static boolean sentencePalindrome(String str) {
		int l = 0;
		int h = str.length() - 1;

		// Lowercase string
		str = str.toLowerCase();

		// Compares character until they are equal
		while (l <= h) {

			char getAtl = str.charAt(l);
			char getAth = str.charAt(h);

			// If there is another symbol in left
			// of sentence
			if (!(getAtl >= 'a' && getAtl <= 'z'))
				l++;

			// If there is another symbol in right
			// of sentence
			else if (!(getAth >= 'a' && getAth <= 'z'))
				h--;

			// If characters are equal
			else if (getAtl == getAth) {
				l++;
				h--;
			}

			// If characters are not equal then
			// sentence is not palindrome
			else
				return false;
		}

		// Returns true if sentence is palindrome
		return true;
	}
}
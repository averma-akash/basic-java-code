package interview;

import java.util.stream.IntStream;

public class PalindromeCheck {

	public static void main(String[] args) {
		System.out.println(" Is Palindrome : " + isPalindrome("9934399"));
		System.out.println(" Is Palindrome : " + isPalindrome2ndWay("akaaka"));
		System.out.println(" Is Palindrome : " + isPalindromeSentance("aka kaa"));
	}

	private static boolean isPalindrome(String n) {
		String value = String.valueOf(n);
		int len = value.length();
		boolean isPalindromeNumber = IntStream.range(0, len / 2)
				.anyMatch(index -> value.charAt(index) == value.charAt(len - index - 1));
		return isPalindromeNumber;
	}
	public static boolean isPalindrome2ndWay(String originalString) {
        String reversedString = new StringBuilder(originalString).reverse().toString();
        return originalString.equals(reversedString);
    }
	
	//Palindrome sentance
	public static boolean isPalindromeSentance(String originalString) {
		 
        String tempString = originalString.replaceAll("\\s+", "").toLowerCase();
 
        return IntStream.range(0, tempString.length() / 2)
            .noneMatch(i -> tempString.charAt(i) != tempString.charAt(tempString.length() - i - 1));
 
    }
}
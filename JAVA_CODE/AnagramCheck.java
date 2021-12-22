import java.util.Arrays;
 
public class AnagramCheck {
 
    public static void main(String[] args) {
 
        String word1 = "jordan";
        String word2 = "danjor";
 
        System.out.println("given words are Anagram :" + isAnagramUsingArraySort(word1, word2));
 
    }
 
    public static boolean isAnagramUsingArraySort(String word1, String word2) {
 
        String sortedWord = sortChars(word1);
        String sortedAnagram = sortChars(word2);
 
        return sortedWord.equals(sortedAnagram);
    }
 
    public static String sortChars(String word) {
        char[] wordArr = word.toLowerCase().toCharArray();
        Arrays.sort(wordArr);
        return String.valueOf(wordArr);
    }
}
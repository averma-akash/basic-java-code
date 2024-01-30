package interview;
import java.util.*; 

public class ReverseString {

	public static void main(String[] args) {

		//String str = "Akash";
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a string: ");  
		String str= sc.nextLine();
		System.out.print("You have entered: "+str +"\n\n");   
		System.out.println("Reversed String: "+reverse(str));
		
		//reverse using recursion
		
		recursionReverse(str);
		/* reverse Sentance starts*/
		String text = "I Love India";
		String output[] = text.split(" ");
        String output1 = "";
        
        for(int i = output.length-1; i>=0; i--) {
            output1 += output[i]+ " ";
        }
         System.out.println(output1.substring(0,output1.length()-1));
		 //India Love I
         /* reverse Sentance ends*/
	}

	public static String reverse(String in) {
		if (in == null)
			throw new IllegalArgumentException("Null is not valid input");

		StringBuilder out = new StringBuilder();

		char[] chars = in.toCharArray();

		for (int i = chars.length - 1; i >= 0; i--)
			out.append(chars[i]);

		return out.toString();
	}
	
	static void recursionReverse(String str)
    {
        if ((str==null)||(str.length() <= 1))
           System.out.println(str);
        else
        {
            System.out.print(str.charAt(str.length()-1));
            recursionReverse(str.substring(0,str.length()-1));
        }
    }
}

// Java 8

import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class ReverseCompleteStringUsingJava8 {
 
    public static void main(String[] args) {
 
        // sample string
        String str = "quick brown fox jumps over lazy dog";
 
 
        // reverse a String using Java 8
        String reverseStr = Stream.of(str)
                .map(string -> new StringBuilder(string).reverse())
                .collect(Collectors.joining());
 
 
        // print both strings to console
        System.out.println("Original String = " + str);
        System.out.println("Reversed String = " + reverseStr);
 
 
        // print both string length to console
        System.out.println("\n\nOriginal String length = " + str.length());
        System.out.println("Reversed String length = " + reverseStr.length());
    }
}
//Output:

//Original String = quick brown fox jumps over lazy dog
//Reversed String = god yzal revo spmuj xof nworb kciuq
 
import java.util.*;
public class DuplicateCharacterCountinString
{
   private static List charCount = new ArrayList();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		
		for(int i=0; i<input.length(); i++) {
		    char c = input.charAt(i);
		    
		    if(isChecked(c)) 
		        continue;
		  
		  int count = 0;
		  for(int j=0;j<input.length(); j++) {
		      if(c == input.charAt(j)) {
		          count++;
		      }
		  }
		  System.out.println(c+" : "+count);
		}
	}
	
	private static boolean isChecked(char c) {
	    if(charCount.contains(Character.toString(c))) {
	        return true;
	    } else {
	        charCount.add(Character.toString(c));
	    }
	    return false;
	}
}
import java.util.*;

/*
*
* LEFT TRIANGLE STAR PATTERN PROGRAMS
Enter number of rows: 5
           * 
         * * 
       * * * 
     * * * * 
   * * * * * 

*/

public class StarPatter1 {

    public static void printStars(int n) { 

        int i, j;  

        for(i=0; i<n; i++) { //an outer loop for number of rows(n) 
            for(j=2*(n-i); j>=0; j--) { // an inner loop for spaces 

                System.out.print(" "); // to print space

            } 

            for(j=0; j<=i; j++) {  // an inner loop for columns

                System.out.print("* "); // to print star

            }           

            System.out.println(); // end-line after every row

        } 

    } 

    public static void main(String args[]) { 

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");  
		int n = sc.nextInt();
        printStars(n); 

    } 

}
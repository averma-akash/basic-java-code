import java.util.*;

/*
*
* DOWNWARD TRIANGLE STAR PATTERN PROGRAM IN JAVA
Enter the number of rows: 5

* * * * * 
* * * * 
* * * 
* * 
* 

*/

public class DownwardTriangle {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rows: "); //to take input from user
    int rows = sc.nextInt();
    for (int i= rows-1; i>=0 ; i--) {
		for (int j=0; j<=i; j++) {
			System.out.print("*" + " ");
		}
		System.out.println();
	}
    sc.close();
	}
}
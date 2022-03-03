package interview;

import java.util.Scanner;

public class MaximumProductOfAdjacentElement {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Product=0;
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i=0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i<len-1; i++){
            if (arr[i]*arr[i+1]>Product){
                Product=arr[i]*arr[i+1]; 
                
            }
            else {
            	System.out.println("Element forming maximum product : " +arr[i-1] + " and " +arr[i]);
            }
        }
        System.out.println(Product);
    }

}

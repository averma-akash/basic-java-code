package interview;

import java.util.Scanner;

public class MaximumProductOfAdjacentElement {
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int len = sc.nextInt();
//		int[] arr = new int[len];
//		for (int i = 0; i < len; i++) {
//			arr[i] = sc.nextInt();
//		}
		int[] arr1 = { 3, 6, -2, -5, 7, 3 };
		System.out.println(adjacentElementsProduct(arr1));
	}

	private static int adjacentElementsProduct(int[] arr) {
		int maxProduct = Integer.MIN_VALUE;
		int currentProduct = 1;
		for (int i = 0; i < arr.length - 1; ++i) {
			currentProduct = arr[i] * arr[i + 1];
			maxProduct = maxProduct < currentProduct ? currentProduct : maxProduct;
		}

		return maxProduct;
	}

}

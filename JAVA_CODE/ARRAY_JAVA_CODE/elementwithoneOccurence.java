/*
we are using binary search algorithm to find the single element 
The first step is to sort the array because binary search algorithm wont work if the array is not sorted.
The solution is to take two indexes of the array(low and high) where low points to array-index 0 and high points to array-index (array size-2). We take out the mid index from the values by (low+high)/2

Now check if the mid index value falls in the left half or the right half. If it falls in the left half then we change the low value to mid+1 and if it falls in the right half, then we change the high index to mid-1. To check it , we used a logic (if(arr[mid]==arr[mid^1]). If mid is an even number then mid^1 will be the next odd index , and if the condition gets satisfied, then we can say that we are in the left index,else we can say we are in the right half. But if mid is an odd index, then mid^1 takes us to mid-1 which is the previous even index , which is gets equal means we are in the right half else left half.

^ --> Bitwise XOR operator

The time complexity of the solution is O(N log(N))+O(log N) and its space complexity is O(1).
**/
package interview;

import java.util.*;

public class elementwithoneOccurence {
	static int singleelement(int arr[], int n) {
		int low = 0, high = n - 2;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] == arr[mid ^ 1]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return arr[low];
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 2, 3, 5, 4, 5, 3, 4};
		Arrays.sort(arr);
		System.out.println(singleelement(arr, arr.length));
	}

}

import java.io.*;
import java.util.*;
 
class elementwithoneOccurence
{
    // function which find number
    static int singleNumber(int[] nums, int n)
    {
        HashMap<Integer, Integer> m = new HashMap<>();
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++)
        {
            if (!m.containsKey(nums[i]))
            {
                sum1 += nums[i];
                m.put(nums[i], 1);
            }
            sum2 += nums[i];
        }
 
        // applying the formula. 2*(sum_of_array_without_duplicates) – (sum_of_array) 
        return (int)(2 * (sum1) - sum2);
    }
 
    // Driver code
    public static void main(String args[])
    {
        int[] a = {2, 3, 5, 4, 5, 3, 4};
        int n = 7;
        System.out.println(singleNumber(a,n));
 
        int[] b = {15, 18, 16, 18, 16, 15, 89};
        System.out.println(singleNumber(b,n));
    }
}
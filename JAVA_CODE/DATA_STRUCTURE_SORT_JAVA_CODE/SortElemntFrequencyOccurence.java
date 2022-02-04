package practicebook.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortElemntFrequencyOccurence {

	public static void main(String[] args) {

		Scanner sr = new Scanner(System.in);
		int n = sr.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sr.nextInt();
		}
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> outputArray = new ArrayList<>();
		for (int current : arr) {
			int count = map.getOrDefault(current, 0);
			map.put(current, count + 1);
			outputArray.add(current);
		}
		// Compare the map by value
		SortComparator comp = new SortComparator(map);
		// Sort the map using Collections CLass
		Collections.sort(outputArray, comp);
		// Final Output
		for (Integer i : outputArray) {
			System.out.print(i + " ");
		}
	}
}

class SortComparator implements Comparator<Integer> {
	private final Map<Integer, Integer> freqMap;

	// Assign the specified map
	SortComparator(Map<Integer, Integer> tFreqMap) {
		this.freqMap = tFreqMap;
	}

	// Compare the values
	@Override
	public int compare(Integer k1, Integer k2) {

		// Compare value by frequency
		int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

		// Compare value if frequency is equal
		int valueCompare = k1.compareTo(k2);

		// If frequency is equal, then just compare by value, otherwise -
		// compare by the frequency.
		if (freqCompare == 0)
			return valueCompare;
		else
			return freqCompare;
	}
}
//Time Complexity
//O(NlogN) where N is the number of elements present in the array. Here we arrange elements in sorted multimap.

//Space Complexity
//O(N) because here we use multimap and map which have maximum size up to N.
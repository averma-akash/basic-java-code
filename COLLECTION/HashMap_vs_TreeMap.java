/************ What are the differences between HashMap and Tree Map? *****************

HashMap:-

--> HashMap is a hashtable-based implementation and It extends the AbstractMap class and implements the Map interface. A HashMap works on the principle of hashing.
--> HashMap doesn't provide any guarantee over the way the elements are arranged in the Map.It means, we can't assume any order while iterating over keys and values of a HashMap.
--> HashMap allows storing at most one null key and many null values.
--> Classes used in sets are Set: HashSet, Linked HashSet, TreeSet, SortedSet etc.

TreeMap :-

--> TreeMap extends AbstractMap class and implements NavigableMap interface. A TreeMap stores map elements in a Red-Black tree, which is a Self-Balancing Binary Search Tree.
--> TreeMap are sorted according to their natural order.If TreeMap objects cannot be sorted according to natural order then we may make use of a Comparator or Comparable to define the order in which the elements are arranged within the Map.
--> TreeMap doesn't allow a null key but may contain many null values. A null key isn't allowed because the compareTo() or the compare() method throws a NullPointerException.
--> Map implementation classes are HashMap, HashTable, TreeMap, ConcurrentHashMap, and LinkedHashMap.

*/
//https://www.baeldung.com/java-treemap-vs-hashmap


/* Java program to print frequencies of all elements using
   HashMap */
import java.util.*;
 
class Main
{
    // This function prints frequencies of all elements
    static void printFreq(int arr[])
    {
        // Creates an empty HashMap
        HashMap<Integer, Integer> hmap =
                     new HashMap<Integer, Integer>();
 
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            Integer c = hmap.get(arr[i]);
 
            // If this is first occurrence of element
            if (hmap.get(arr[i]) == null)
               hmap.put(arr[i], 1);
 
            // If elements already exists in hash map
            else
              hmap.put(arr[i], ++c);
        }
 
        // Print result
        for (Map.Entry m:hmap.entrySet())
          System.out.println("Frequency of " + m.getKey() +
                             " is " + m.getValue());
    }
 
    // Driver method to test above method
    public static void main (String[] args)
    {
        int arr[] = {10, 34, 5, 10, 3, 5, 10};
        printFreq(arr);
    }
}
/*
Frequency of 34 is 1
Frequency of 3 is 1
Frequency of 5 is 2
Frequency of 10 is 3
*/

/* Java program to print frequencies of all elements using
   TreeMap */
import java.util.*;
 
class Main
{
    // This function prints frequencies of all elements
    static void printFreq(int arr[])
    {
        // Creates an empty TreeMap
        TreeMap<Integer, Integer> tmap =
                     new TreeMap<Integer, Integer>();
 
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            Integer c = tmap.get(arr[i]);
 
            // If this is first occurrence of element  
            if (tmap.get(arr[i]) == null)
               tmap.put(arr[i], 1);
 
            // If elements already exists in hash map
            else
              tmap.put(arr[i], ++c);
        }
 
        // Print result
        for (Map.Entry m:tmap.entrySet())
          System.out.println("Frequency of " + m.getKey() +
                             " is " + m.getValue());
    }
 
    // Driver method to test above method
    public static void main (String[] args)
    {
        int arr[] = {10, 34, 5, 10, 3, 5, 10};
        printFreq(arr);
    }
}
/*
Frequency of 3 is 1
Frequency of 5 is 2
Frequency of 10 is 3
Frequency of 34 is 1
*/
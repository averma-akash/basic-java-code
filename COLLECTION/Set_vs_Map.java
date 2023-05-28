/************ What are the differences between SET and MAP? *****************

Sets:-

Set does not allow duplicates. Set and all of the classes which implements Set interface should have unique elements.
Set allows single null value at most.
Set does not maintain any order; still few of its classes sort the elements in an order such as LinkedHashSet maintains the elements in insertion order.
Classes used in sets are Set: HashSet, Linked HashSet, TreeSet, SortedSet etc.

Maps:-

Map stored the elements as key & value pair. Map doesn’t allow duplicate keys while it allows duplicate values.
Map can have single null key at most and any number of null values.
The map also does not maintain any insertion order. 
Map implementation classes are HashMap, HashTable, TreeMap, ConcurrentHashMap, and LinkedHashMap.

*/


// A Java program to demonstrate a Set.
 
import java.util.*;
 
public class SetExample {
   
    public static void main(String[] args)
    {
        // Set demonstration using HashSet
        Set<String> Set = new HashSet<String>();
         
        // Adding Elements 
        Set.add("one");
        Set.add("two");
        Set.add("three");
        Set.add("four");
        Set.add("five");
         
        // Set follows unordered way.
        System.out.println(Set);
    }
}

// A sample program to demonstrate Map.
 
import java.util.*;
 
class MapExample {
 
    public static void main(String args[])
    {
 
        // Creating object for Map.
        Map<Integer, String> map
            = new HashMap<Integer, String>();
 
        // Adding Elements using Map.
        map.put(100, "Amit");
        map.put(101, "Vijay");
        map.put(102, "Rahul");
 
        // Elements can traverse in any order
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " "
                               + m.getValue());
        }
    }
}
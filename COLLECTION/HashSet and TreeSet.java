/**** HashSet vs TreeSet *****

*** HashSet***

--> For operations like search, insert, and remove HashSet takes constant time on average. 
--> The elements of a HashSet are not ordered. 
--> Null objects are allowed in HashSet.
--> HashSet compares two objects in a Set and detects duplicates using the equals() method.

*** TreeSet ***

--> For operations like search, insert, and remove TreeSet takes O(Log n) which is higher than HashSet.
--> TreeSet class keeps objects in a Sorted order defined by the Comparable or Comparator methods. By default, TreeSet components are sorted in ascending order. It has a number of methods for dealing with ordered sets, including first(), last(), headSet(), tailSet(), and so on.
--> TreeSet does not allow null objects and throws a NullPointerException. This is because TreeSet compares keys using the compareTo() method, which throws java.lang. NullPointerException.
--> TreeSet compares two objects in a Set and detects duplicates using the compareTo() method.

*/

import java.util.HashSet;
class HashSetExample { 

  public static void main(String[] args) {
     // Create a HashSet
     HashSet<String> hset = new HashSet<String>();
 
     //add elements to HashSet
     hset.add("Abhijeet");
     hset.add("Ram");
     hset.add("Kevin");
     hset.add("Singh");
     hset.add("Rick");
     // Duplicate removed
     hset.add("Ram"); 
 
     // Displaying HashSet elements
     System.out.println("HashSet contains: ");
     for(String temp : hset){
        System.out.println(temp);
     }
  }
}
Output

HashSet contains: 

Rick
Singh
Ram
Kevin
Abhijeet


import java.util.TreeSet;
class TreeSetExample { 

  public static void main(String[] args) {
     // Create a TreeSet
     TreeSet<String> tset = new TreeSet<String>();
 
     //add elements to TreeSet
     tset.add("Abhijeet");
     tset.add("Ram");
     tset.add("Kevin");
     tset.add("Singh");
     tset.add("Rick");
     // Duplicate removed
     tset.add("Ram"); 
  
     // Displaying TreeSet elements
     System.out.println("TreeSet contains: ");
     for(String temp : tset){
        System.out.println(temp);
     }
  }
}
Output: Elements are sorted in ascending order.

TreeSet contains: 

Abhijeet
Kevin
Ram
Rick
Singh
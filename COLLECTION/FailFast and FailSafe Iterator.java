/*
What is the difference between fail-fast and fail-safe iterator?

fail-fast Iterator

Iterators in java are used to iterate over the Collection objects.

Fail-Fast iterators immediately throw ConcurrentModificationException if there is structural modification of the collection like adding, removing or updating any element from collection while a thread is iterating over that collection. Iterator on ArrayList, HashMap classes are some examples of fail-fast Iterator.

*/
import java.util.ArrayList;
import java.util.Iterator;
 
public class FailFastIteratorExample 
{       
    public static void main(String[] args) {

        //Creating an ArrayList of integers
        ArrayList<Integer> list = new ArrayList<Integer>();
         
        //Adding elements to list
        list.add(1452);
        list.add(6854);
        list.add(8741);
                 
        //Getting an Iterator from list
        Iterator<Integer> it = list.iterator();
         
        while (it.hasNext()) {
            Integer integer = (Integer) it.next();
            list.add(8457);      //This will throw ConcurrentModificationException
        }
    }   
}
/*
Output

Exception in thread "main" java.util.ConcurrentModificationException
    at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    at java.util.ArrayList$Itr.next(Unknown Source)
    at pack1.MainClass.main(MainClass.java:32)
	
	
fail-safe Iterator

Fail-Safe iterators don’t throw any exceptions if a collection is structurally modified while iterating over it. This is because, they operate on the clone of the collection, not on the original collection and that’s why they are called fail-safe iterators. Iterator on CopyOnWriteArrayList, ConcurrentHashMap classes are examples of fail-safe Iterator.

*/
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
 
public class FailSafeIteratorExample 
{       
    public static void main(String[] args) {

        //Creating a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
         
        //Adding elements to map
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
         
        //Getting an Iterator from map
        Iterator<String> it = map.keySet().iterator();
         
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println(key+" : "+map.get(key));
            map.put("FOUR", 4); //This will not be reflected in the Iterator
        }
    }   
}
/*
Output

TWO : 2
FOUR : 4
ONE : 1
THREE : 3
*/
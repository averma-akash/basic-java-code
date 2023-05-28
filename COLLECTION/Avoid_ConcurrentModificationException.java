/*How to Avoid ConcurrentModificationException?

ConcurrentModificationException is the child class of RuntimeException. This exception rises when an object is tried to be modified concurrently when it is not permissible i.e when one thread is iterating over some collection class object and if some other thread tried to modify or try to make some changes on that collection object then we will get ConcurrentModificationException.

In single-threaded program we can avoid  ConcurrentModificationException by using iterator’s remove( ) function, we can remove an object from an underlying collection object without getting any exception.

n multi-threaded program we can avoid ConcurrentModificaionException by using  ConcurrentHashMap and CopyOnWriteArrayList classes. These classes help us in avoiding ConcurrentModificaionException.

/ Java Program to illustrate
// ConcurrentModificationException

*/
import java.io.*;
import java.util.*;
import java.util.Iterator;
 
class GFG {
 
    public static void main(String[] args)
    {
 
        ArrayList<Integer> list = new ArrayList<>();
 
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
 
        System.out.println("List Value Before Iteration:"
                           + list);
 
        // Creating an iterator object
        // to iterate over the ArrayList
        Iterator<Integer> itr = list.iterator();
 
        // Condition check
        // it holds true till there is single element
        // remaining in the List
        while (itr.hasNext()) {
 
            // next() method() loos out for next element in
            // the List
            Integer value = itr.next();
 
            // Here we are trying to remove the one entry of
            // ArrayList base on the given if condition and
            // hence
 
            // We will get Concurrent ModificationException
            if (value.equals(3))
                itr.remove();
        }
        // Display the value of ArrayList
        System.out.println("List Value After iteration:"
                           + list);
    }
}
/************* What are the differences between List and Set? *****************

List is an ordered collection of objects in which duplicate values are allowed to store.
List preserves the insertion order and it allows positional access and insertion of elements.
Multiple null value can be stored.

Set is an unordered collection of objects in which duplicate values cannot be stored. 
It is an interface that implements the maths set. Set interface contains the methods inherited from the Collection interface and adds a feature that restricts to insert the duplicate elements.
Only on enull value can be stored.

*/


/**
* Java Program to illustrate use of List 
* and Set in Java 
*
**/
import java.io.*;
import java.util.*;
 
class ListAndSet {
    public static void main(String[] args)
    {
        // List declaration
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(6);
        l.add(3);
        l.add(5);
        l.add(4);
 
        // Set declaration
        Set<Integer> s = new HashSet<>();
        s.add(5);
        s.add(6);
        s.add(3);
        s.add(5);
        s.add(4);
 
        // printing list
        System.out.println("List = " + l);
        // printing Set
        System.out.println("Set = " + s);
    }
}
//List = [5, 6, 3, 5, 4]
//Set = [3, 4, 5, 6]
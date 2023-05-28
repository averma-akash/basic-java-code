/************ What are the differences between ArrayList and LinkedList? *****************

1. Elements of arraylist are stored in a dynamic array an because of generics it store all types of objects.

2. ArrayList implements list interface

3. Manipulating an arraylist take longer time because of there internal implementation. the array is scanned and the memory bits are shifted whenever we remove an element.

4. ArrayList is more useful when the application requires data storage and access.

----------------------------------------------

1. Elements of LinkedList are stored in a dynamic array an because of generics it store all types of objects.

2. The List and Deque interfaces are both implemented by LinkedList As a result, it can be used as both a list and a deque.

3. Manipulating an LinkedList take less time.

4 LinkedList is more useful when the application requires data manipulation.

*/


/**
* Java Program to illustrate use of ArrayList 
* and LinkedList in Java 
*
**/
import java.io.*; 
import java.util.*; 
  
class Example
{ 
    public static void main (String[] args) { 
        // creating an ArrayList 
        ArrayList<String> arrlist = new ArrayList<String>(); 
  
        // adding object to arraylist 
        arrlist.add("One"); 
        arrlist.add("Two"); 
        arrlist.add("Three"); 
          
        // traversing elements using Iterator' 
        System.out.println("ArrayList elements are:"); 
        Iterator itr = arrlist.iterator(); 
        while (itr.hasNext()) 
            System.out.println(itr.next()); 
    } 
} 

// Java program to Demonstrate Working of a LinkedList
import java.util.*;

class LinkedListExample {
 
    public static void main(String args[])
    {
 
        // Creating an object of the
        // class linked list
        LinkedList<String> object
            = new LinkedList<String>();
 
        // Adding the elements to the object created
        // using add() and addLast() method
 
        // Custom input elements
        object.add("A");
        object.add("B");
        object.addLast("C");
 
        // Print the current LinkedList
        System.out.println(object);
 
        // Removing elements from the List object
        // using remove() and removeFirst() method
        object.remove("B");
        object.removeFirst();
 
        System.out.println("Linked list after "
                           + "deletion: " + object);
    }
}
//[A, B, C]
//Linked list after deletion: [C]
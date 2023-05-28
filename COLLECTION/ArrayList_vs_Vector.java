************* What are the differences between ArrayList and Vector? *****************

- ArrayList is not synchronized.
- ArrayList increments 50% of current array size if the number of elements exceeds from its capacity.
- ArrayList is not a legacy class. It is introduced in JDK 1.2.
- ArrayList is fast because it is non-synchronized.
- ArrayList uses the Iterator interface to traverse the elements.

- Vector is synchronized.
- Vector increments 100% means doubles the array size if the total number of elements exceeds than its capacity.
- Vector is a legacy class.
- Vector is slow because it is synchronized, i.e., in a multithreading environment, it holds the other threads in runnable or non-runnable state until current thread releases the lock of the object.
-A Vector can use the Iterator interface or Enumeration interface to traverse the elements.


/**
* Java Program to illustrate use of ArrayList 
* and Vector in Java 
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
  
        // creating Vector 
        Vector<String> vtr = new Vector<String>(); 
        vtr.addElement("Four"); 
        vtr.addElement("Five"); 
        vtr.addElement("Six"); 
  
        // traversing elements using Enumeration 
        System.out.println("\nVector elements are:"); 
        Enumeration eum = vtr.elements(); 
        while (eum.hasMoreElements()) 
            System.out.println(eum.nextElement()); 
    } 
} 
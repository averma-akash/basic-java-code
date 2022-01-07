// Java program to illustrate
// ConcurrentModificationException
 
// Importing all classes from java.util package
// Importing input output classes
import java.io.*;
import java.util.*;
 
// Main Class
class GFG {
 
    // Main driver method
    public static void main(String[] args)
    {
 
        // Creating an object of ArrayList
        // Declaring object of Integer type
        ArrayList<Integer> list = new ArrayList<>();
 
        // Adding element to ArrayList object created above
        // using the add() method
        // Custom input elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
 
        // Display all the elements of ArrayList object
        System.out.println("List Value Before Iteration:"
                           + list);
 
        // Creating an iterator object to
        // iterate over the ArrayList
        Iterator<Integer> it = list.iterator();
 
        // Condition check
        // It holds true till there is single element
        // remaining in the List
        while (it.hasNext()) {
            Integer value = it.next();
 
            // Here we are trying to remove the one entry of
            // ArrayList base on the if condition and hence
 
            // We will get Concurrent ModificationException
            if (value.equals(3))
                list.remove(value);
        }
 
        // Print and display the value of ArrayList object
        System.out.println("List Value After Iteration:"
                           + list);
    }
}
/*Class Level Lock is a mechanism where every class in java has a unique lock . If a thread wants to execute a static synchronized method then the thread requires a class level lock once the thread gets a class level lock then it is allowed to execute any static synchronized method of that class. Once method execution completes automatically thread releases the lock. While a thread executing a static synchronized method the remaining thread is not allowed to execute any static synchronized method of that class simultaneously.
*/
/ java program to illustrate Class Level Lock Concept
 
// Importing required packages
import java.io.*;
import java.util.*;
 
// Class 1
// Helper Class
// Consist of synchronized method wish
class Display {
 
    // Declaring static wish method
    public static void wish(String name)
    {
 
        // synchronizing wish method
        // and getting the lock of display class
        synchronized (Display.class)
        {
 
            for (int i = 1; i <= 10; i++) {
 
                // Display message only
                System.out.print("Good Morning: ");
 
                // Try block to check for exceptions
                try {
                    // Putting thread on sleep for specified
                    // time
                    //  using the sleep() method
                    Thread.sleep(1000);
                }
 
                // Catch block to handle the exception
                catch (InterruptedException e) {
 
                    // Throwing exception
                    System.out.println(e);
                }
                // Display message
                System.out.println(name);
            }
        }
    }
}
 
// C;asss 2
// Helper Class (extends the Thread class)
// myThread with override the run method
// as per our requirements it also consists
// of parameterised constructor
class myThread extends Thread {
    // Member variables of this class
    Display d;
    String name;
 
    // Constructor of this class
    myThread(Display d, String name)
    {
 
        // This keyword refers to current object itself
        this.d = d;
        this.name = name;
    }
 
    // run method for thread/s
    public void run()
    {
 
        // Calling wish method of display class
        d.wish(name);
    }
}
 
// Class 3
// Main Class
class GFG {
 
    // Main driver method
    public static void main(String[] args)
    {
 
        // Creating Display class(Class 1) object
        // in the main() method
        Display d = new Display();
 
        // Creating a thread objects
        myThread t1 = new myThread(d, "Dhoni");
        myThread t2 = new myThread(d, "Yuvraj");
 
        // Starting the threads using start() method
        t1.start();
        t2.start();
    }
}
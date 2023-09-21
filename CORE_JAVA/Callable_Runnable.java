/**** Callable ****

--> a callable interface that basically throws a checked exception and returns some results. In callable interface, it simply computes a result else it will throw an exception.
--> We can not create a thread by passing callable as a parameter.
--> This interface also contains a single call() method which is no-argument method.
--> It is declared in the ‘java.util.concurrent‘ package.
--> Future is an object that holds the result – it may not hold it right now, but it will do so in the future (once the Callable returns).


**** Runnable ****

--> The Runnable interface is a functional interface and has a single run() method that doesn't accept any parameters or return any values.
--> There are two ways to start a new thread using Runnable, one is by implementing the Runnable interface and another one is by subclassing the Thread class.
--> Runnable cannot return the result of computation and Runnable cannot throw checked exceptions.

*/
// Java Program to illustrate Callable interface
 
// Importing classes from java.util package
import java.util.Random; 
import java.util.concurrent.Callable; 
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
  
// Class
// Implementing the Callable interface
class CallableMessage implements Callable<String>{
  public String call() throws Exception{
      return "Hello World!";
  } 
}
 
public class CallableExample{
  static ExecutorService executor = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws Exception{
        CallableMessage task = new CallableMessage();
         Future<String> message = executor.submit(task);
         System.out.println(message.get().toString());
    }
}

//********************

// Java Program to implement Runnable interface
 
// Importing FileNotFound class from
// input output classes bundle
import java.io.FileNotFoundException;
import java.util.concurrent.*;
 
// Class
// Implementing the Runnable interface
class RunnableImpl implements Runnable {
 
  public void run()
  {
    System.out.println("Hello World from a different thread than Main");
  }
}
public class RunnableExample{
    static ExecutorService executor = Executors.newFixedThreadPool(2);
  public static void main(String[] args){
          // Creating and running runnable task using Thread class
          RunnableImpl task = new RunnableImpl();
        Thread thread = new Thread(task);
          thread.start();
          // Creating and running runnable task using Executor Service.
          executor.submit(task);
    }
}
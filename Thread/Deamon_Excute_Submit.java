/*
******** How can we create daemon threads? ********

We can create daemon threads in java using the thread class setDaemon(true). It is used to mark the current thread as daemon thread or user thread. isDaemon() method is generally used to check whether the current thread is daemon or not. If the thread is a daemon, it will return true otherwise it returns false
But one can only call the setDaemon() method before start() method otherwise it will definitely throw IllegalThreadStateException

t1 is Daemon thread 
t3 is Daemon thread 
t2 is User thread 
*/

public class DaemonThread extends Thread 
{ 
   public DaemonThread(String name){ 
       super(name); 
   } 
   public void run() 
   {  
       // Checking whether the thread is Daemon or not 
       if(Thread.currentThread().isDaemon()) 
       {  
           System.out.println(getName() + " is Daemon thread");  
       }    
       else 
       {  
           System.out.println(getName() + " is User thread");  
       }  
   }   
   public static void main(String[] args) 
   {  
       DaemonThread t1 = new DaemonThread("t1"); 
       DaemonThread t2 = new DaemonThread("t2"); 
       DaemonThread t3 = new DaemonThread("t3");  
       // Setting user thread t1 to Daemon 
       t1.setDaemon(true);       
       // starting first 2 threads  
       t1.start();  
       t2.start();   
       // Setting user thread t3 to Daemon 
       t3.setDaemon(true);  
       t3.start();         
   }  
} 

public class DaemonThread extends Thread 
{ 
   public void run() 
   { 
       System.out.println("Thread name: " + Thread.currentThread().getName()); 
       System.out.println("Check if its DaemonThread: "  
                       + Thread.currentThread().isDaemon()); 
   } 
   public static void main(String[] args) 
   { 
       DaemonThread t1 = new DaemonThread(); 
       DaemonThread t2 = new DaemonThread(); 
       t1.start();         
       // Exception as the thread is already started 
       t1.setDaemon(true); 
       t2.start(); 
   } 
} 

/*Execute Method: *****

This function executes the given command at some time in the future. The command may execute in a new thread, in a pooled thread, or in the calling thread, at the discretion of the Executor implementation. This method is a void method meaning it doesn’t return any function. Once the task is assigned in the execute() method, we won’t get any response and we can forget about the task. The following is an implementation of the execute method. */


// Java program to demonstrate
// the behavior of the
// execute() method
 
import java.util.concurrent.*;
public class GFG {
 
    public static void main(String[] args)
        throws Exception
    {
 
        // Creating the object of the
        // Executor Service
        ExecutorService executorService
            = Executors.newSingleThreadExecutor();
 
        /* execute() method cannot return
        // anything because it's return type
        // is void.
 
        // By using execute(), we are accepting
        // a Runnable task */
        executorService.execute(new Runnable() {
 
            // Override the run method
            public void run()
            {
                System.out.println(
                    "This is execute() "
                    + "method example");
            }
        });
 
        // This method performs all the
        // previouslu submitted tasks
        // before termination
        executorService.shutdown();
    }
}
/*************************

Submit Method: This function executes the given command at some time in the future. The command may execute in a new thread, in a pooled thread, or in the calling thread, at the discretion of the Executor implementation. Unlike the execute method, this method returns a future. In Java, the future represents the result of an asynchronous computation. The future object is used to handle the task after the execution has started. Therefore, when we need the result of the execution, then we can use the submit() method of the future object. In order to get the result, we can use the get() methods on the Future. The get() method returns an object if we call the get() method before the task has completed, it will block until the result is ready and may throw checked exception or if the task is completed, then the future object holds a result which is returned which can then be used later. The following is an implementation of the submit method:
*/
import java.util.concurrent.*;
public class GFG {
    public static void main(String[] args)
        throws Exception
    {
 
        // Creating the object of the
        // Executor service interface
        ExecutorService executorService
            = Executors.newFixedThreadPool(1);
 
        // submit() method can return the
        // result of the computation
        // because it has a return type of Future.
 
        // By using submit(), we are
        // accepting a Callable task
        Future obj
            = executorService.submit(new Callable() {
 
                  // Overriding the call method
                  public Object call()
                  {
                      System.out.println(
                          "This is submit() "
                          + "method example");
 
                      return "Returning Callable "
                          + "Task Result";
                  }
              });
 
        // This method will return the result
        // if the task has finished perfectly.
        // The submit() method returns a
        // Java Future object which is
        // used to check when the Runnable
        // has completed.
        // As it implements Future,
        // get() method is called
        // to get the result
        System.out.println(obj.get());
         executorService.shutdown();
    }
}
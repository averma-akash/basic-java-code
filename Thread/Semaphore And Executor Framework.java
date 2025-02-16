╔════════════════════╗
║ Executor Framework ║
╚════════════════════╝

The Executor Framework in Java was released with the JDK 5 release. The Executor Framework (java.util.concurrent.Executor) is a framework that consists of components that help us to efficiently handle multiple threads.

Using the Executor Framework, we can run objects that are Runnable by reusing the already existing threads. We need not create new threads every time when we need to run objects.

The Executor API separates or de-couples the execution of a task from the actual task using an Executor.

╔══════════╗
║ Executor ║
╚══════════╝

The executor can be defined as an interface used to represent an object that executes the tasks provided to it. Whether the task is to be run on current or new thread depends on the point from where the invocation was initiated which further depends on the implementation.

So using Executor, we can de-couple the tasks from the actual task and then run them asynchronously.

However, the execution of the task using Executor need not be asynchronous. Executors can also invoke the task instantly using invoking thread.

*********** 
Given below is an example piece of code to create Executor instance:*/

public class Invoker implements Executor {
        @Override
        public void execute (Runnable r_interface) {
            r_interface.run();
        }   
    }
/***********
Once the invoker is created, as shown above, we can use it to execute the task as follows.*/

public void execute () {
        Executor executor = new Invoker ();
        executor.execute ( () -> {
            //perform task
        });
    }

/*Note that if the task is not accepted by the Executor, then it throws RejectedExecutionException.

╔══════════════════╗
║ Executor Service ║
╚══════════════════╝

An ExecutorService (java.util.concurrent.ExecutorService) schedules the submitted tasks as per the availability of threads and also maintains a memory queue. The ExecutorService acts as a complete solution for the Asynchronous processing of tasks.

To use ExecutorService in code, we create a Runnable class. The ExecutorService maintains a thread pool and also assigns the tasks to the threads. Tasks can also queue up in case the thread is not available.

*********************************
Given below is a simple example of ExecutorService.*/

import java.util.concurrent.*;
 
public class Main {  
      public static void main(String[] args) {
        ExecutorService executor_Service = Executors.newFixedThreadPool(10);
        executor_Service.execute(new Runnable() {  
               
            @Override 
            public void run() {
                System.out.println("Simple Example of ExecutorService!!!");  
                   
            }  
        });
        executor_Service.shutdown();  
    }  
}

╔════════════╗
║ Semaphore  ║
╚════════════╝

A Semaphore is a synchronization mechanism that controls access to a shared resource by using a fixed number of counters.
It is part of java.util.concurrent.

+----------------------------+
| How Does a Semaphore Work? |
+----------------------------+

A semaphore maintains a fixed count (number of permits).
A Threads have to acquire a permit before doinng anything.
and When task completes, threads release the permit for other thread.
If no permits are available, a thread blocks until a permit is released.


Depending on what functions they perform, semaphores can be divided into two types:

#1) Binary Semaphore: A binary semaphore is used to synchronize concurrent processes and implement mutual exclusion. A binary semaphore assumes only two values i.e. 0 and 1.

#2) Counting Semaphore: The counting semaphore has a value that indicates the number of processes that can enter the critical section. At any point, the value indicates the maximum number of processes that enter the critical section.

*/
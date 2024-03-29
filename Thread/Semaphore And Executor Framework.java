/********** Executor Framework In Java ************

The Executor Framework in Java was released with the JDK 5 release. The Executor Framework (java.util.concurrent.Executor) is a framework that consists of components that help us to efficiently handle multiple threads.

Using the Executor Framework, we can run objects that are Runnable by reusing the already existing threads. We need not create new threads every time when we need to run objects.

The Executor API separates or de-couples the execution of a task from the actual task using an Executor.

*********** Executor ************

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

*********** ExecutorService ***********
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

/*********** Semaphore In Java ***********

Semaphore is regarded as a thread synchronization construct that is usually required to control and manage the access to the shared resource using counters. It simply sets the limit of the thread. The semaphore class is defined within the package java.util.concurrent and can be used to send signals between threads to avoid missed signals or to guard critical sections. It can also be used to implement resource pools or bounded collection

Depending on what functions they perform, semaphores can be divided into two types:

#1) Binary Semaphore: A binary semaphore is used to synchronize concurrent processes and implement mutual exclusion. A binary semaphore assumes only two values i.e. 0 and 1.

#2) Counting Semaphore: The counting semaphore has a value that indicates the number of processes that can enter the critical section. At any point, the value indicates the maximum number of processes that enter the critical section.

The working of a Semaphore can be summarized in the following steps:

If semaphore count > 0, it means that the thread has a permit to access critical section, and then the count is decremented.

Otherwise, the thread is blocked until the permit is acquired.

When the thread is done with accessing the shared resource, the permit is released and semaphore count is incremented so that another thread can repeat the above steps and acquire the permit.*/

package Seamaphore_Executor_Framework;

import java.util.concurrent.Semaphore;

public class Main  { 
    public static void main(String args[]) throws InterruptedException    { 
        //create Semaphore= #permits = 1
        Semaphore sem = new Semaphore(1); 
         // Create thread instances T1 &amp;amp;amp; T2
        //T1 Increments the count; T2 Decrements the count
        ThreadClass thread1 = new ThreadClass(sem, "T1"); 
        ThreadClass thread2 = new ThreadClass(sem, "T2"); 
           
        
        thread1.start(); 
        thread2.start(); 
        
        thread1.join(); 
        thread2.join(); 
        System.out.println("count: " + SharedRes.count);    // display final count.
    } 
}

package Seamaphore_Executor_Framework;

import java.util.concurrent.Semaphore;

class ThreadClass extends Thread {
	Semaphore sem;
	String threadName;

	public ThreadClass(Semaphore sem, String threadName) {
		super(threadName);
		this.sem = sem;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		// Thread T1 processing
		if (this.getName().equals("T1")) {
			System.out.println("Start: " + threadName);
			try {
				System.out.println(threadName + " :waiting for a permit.");
				// acquire the permit
				sem.acquire();
				System.out.println(threadName + ":Acquired permit");
				// access shared resource
				for (int i = 0; i < 5; i++) {
					SharedRes.count++;
					System.out.println(threadName + ": " + SharedRes.count);
					Thread.sleep(10);
				}

			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
			// Release the permit.
			System.out.println(threadName + ":Released the permit");
			sem.release();
		}
		// Thread T2 processing
		else {
			System.out.println("Start: " + threadName);
			try {
				System.out.println(threadName + ":waiting for a permit.");
				// acquire the lock
				sem.acquire();
				System.out.println(threadName + ":Acquired permit");
				// process the shared resource
				for (int i = 0; i < 5; i++) {
					SharedRes.count--;
					System.out.println(threadName + ": " + SharedRes.count);
					Thread.sleep(10);
				}
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
			// Release the permit.
			System.out.println(threadName + ":Released the permit.");
			sem.release();
		}
	}
}

class SharedRes {
	static int count = 0;
}
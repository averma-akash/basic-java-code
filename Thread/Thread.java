╔═══╦

a thread is a part of an application that shares a common memory with other threads of the same application.

******* Daemon thread ******* 
in Java is a low-priority thread that runs in the background to perform tasks such as garbage collection. Daemon thread in Java is also a service provider thread that provides services to the user thread. Its life depends on user threads i.e. when all the user threads die, JVM terminates this thread automatically.

2. ******* Different state of Thread ? *******

NEW — a new Thread instance that was not yet started via Thread.start()
RUNNABLE — a running thread. It is called runnable because at any given time it could be either running or waiting for the next quantum of time from the thread scheduler. A NEW thread enters the RUNNABLE state when you call Thread.start() on it
BLOCKED — a running thread becomes blocked if it needs to enter a synchronized section but cannot do that due to another thread holding the monitor of this section
WAITING — a thread enters this state if it waits for another thread to perform a particular action. For instance, a thread enters this state upon calling the Object.wait() method on a monitor it holds, or the Thread.join() method on another thread
TIMED_WAITING — same as the above, but a thread enters this state after calling timed versions of Thread.sleep(), Object.wait(), Thread.join() and some other methods
TERMINATED — a thread has completed the execution of its Runnable.run() method and terminated

****** What is multithreading? ******

Multithreading is a process of executing multiple threads simultaneously. Multithreading is used to obtain the multitasking. It consumes less memory and gives the fast and efficient performance.

****** wait() ******

The wait() method is provided by the Object class in Java. This method is used for inter-thread communication in Java. The java.lang.Object.wait() is used to pause the current thread, and wait until another thread does not call the notify() or notifyAll() method. public final void wait()

****** join() ******

The join() method waits for a thread to die. In other words, it causes the currently running threads to stop executing until the thread it joins with completes its task. 

**** sleep() ****
The sleep() method in java is used to block a thread for a particular time, which means it pause the execution of a thread for a specific time. 

***** Is it possible to start a thread twice? ******

No, we cannot restart the thread, as once a thread started and executed, it goes to the Dead state. Therefore, if we try to start a thread twice, it will give a runtimeException "java.lang.IllegalThreadStateException".

***** Can we call the run() method instead of start()? ******

Yes, calling run() method directly is valid, but it will not work as a thread instead it will work as a normal object. There will not be context-switching between the threads. When we call the start() method, it internally calls the run() method, which creates a new stack for a thread while directly calling the run() will not create a new stack.

***** What is shutdown hook? *****

The shutdown hook is a thread that is invoked implicitly before JVM shuts down. So we can use it to perform clean up the resource or save the state when JVM shuts down normally or abruptly. We can add shutdown hook by using the following method:*/

public void addShutdownHook(Thread hook){}    
Runtime r=Runtime.getRuntime();  
r.addShutdownHook(new MyThread());  

/*4. ***** Broken Barrier ******

A barrier breaks when any of the waiting thread leaves the barrier. This happens when one or more waiting thread is interrupted or when the waiting time is completed because the thread called the await() methods with a timeout as follows:*/

newBarrier.await(1000, TimeUnit.MILLISECONDS);
// thread calling this await() 
// methods waits for only 1000 milliseconds.
/*When the barrier breaks due to one of more participating threads, the await() methods of all the other threads throws a BrokenThreadException. Whereas, the threads that are already waiting in the barriers have their await() call terminated.

********* What happens when an Exception occurs in a thread? ***********
If not caught thread will die, if an uncaught exception handler is registered then it will get a call back.

Thread.UncaughtExceptionHandler is an interface,
defined as nested interface for handlers invoked when a Thread abruptly terminates due to an uncaught exception.

When a thread is about to terminate due to an
uncaught exception the Java Virtual Machine will query the thread for
its UncaughtExceptionHandler using Thread.getUncaughtExceptionHandler() and will invoke the handler's uncaughtException() method, passing the
thread and the exception as arguments.*/
Thread t = new Thread(new Runnable(){
	public void run() {
		throw new RuntimeException();
	}
 });
 t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
		public void uncaughtException(Thread t, Throwable e) {
		System.out.println("exception " + e + " from thread " + t);
	}
 });
 t.start(); 

/********** Thread Pool **********

A Thread pool in Java is a group of worker threads that can be reused many times and assigned jobs.

A Thread pool contains a group of fixed size threads. Each thread is pulled out from the thread pool and assigned a task by the service provider. Once the assigned job is completed, the thread is given to the thread pool again.

Thread pool is advantageous as we do not have to create a new thread every time the task is available, thereby the performance is enhanced. It is used in real-time applications that use Servlet and JSP where thread pools are used to process requests.

In multi-threaded applications, the Thread Pool saves resources and helps to contain the parallelism within predefined limits.*/

import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
class WorkerThreadClass implements Runnable {  
    private String message;  
    //thread class constructor   
    public WorkerThreadClass(String s){  
        this.message=s;  
    }  
    //run method for thread
     public void run() {  
        System.out.println(" Start: "+message);  
        processmessage();  //sleep between start and end  
        System.out.println(" End: "+ message);  
    }
    //processmessage method =&amp;amp;gt; sleeps the thread for 2 sec
    private void processmessage() {  
        try {  Thread.sleep(2000);  } catch (InterruptedException e) { e.printStackTrace(); }  
    }  
}  
 
public class Main {  
     public static void main(String[] args) { 
         //create a ExecutorService instance
        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads  
        //create thread instances and execute them
        for (int i = 0; i &amp;amp;lt; 5; i++) {  
            Runnable workerThrd = new WorkerThreadClass("Thread_" + i);  
            executor.execute(workerThrd);//calling execute method of ExecutorService  
          }  
        //shutdown ExecutorService
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
   
        System.out.println("Finished all threads");  
    }  
 }
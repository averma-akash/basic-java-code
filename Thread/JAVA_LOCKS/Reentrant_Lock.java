/*
The “Reentrant Locks” is this method in Java that provides synchronization with far greater flexibility.

The class “ReentrantLock” implements Reentrant locks and is a part of the package “import java.util.concurrent.locks”. ReentrantLock class provides the method synchronization to access shared resources. The classes also have the lock and unlock methods for locking/unlocking resources when accessed by threads.

One peculiar feature of ReentrantLock is that the thread can lock the shared resource more than once using ReentrantLock. It provides hold count which is set to one when the thread locks the resource.

The thread can re-enter and access the resource before unlocking. Every time the thread accesses the resource using the Reentrant lock, the hold count is incremented by one. For every unlock, the hold count is decremented by one.

When the hold count reaches 0, the shared resource is unlocked.

The ReentrantLock class also provides a fairness parameter which is a boolean value that can be passed with the constructor of the lock. When the fairness parameter is set to true, then whenever one thread releases the lock, the lock is passed to the longest waiting thread. This prevents starvation. */

package ReentrntLockExample;

import java.util.concurrent.*;   
import java.util.concurrent.locks.ReentrantLock;   
 //thread class that implements Runnable interface 

public class Main {
public static void main(String[] args) {
	// define ReentrantLock lock object and service pool
	ReentrantLock reentrant_lock = new ReentrantLock();
	ExecutorService pool = Executors.newFixedThreadPool(2);
	// create thread instance and pass lock and task name
	Runnable worker_thread = new ThreadClass(reentrant_lock, "ThreadJob");
	// execute the thread in exec pool
	pool.execute(worker_thread);
	// shut down the pool
	pool.shutdown();
}
}
 
class ThreadClass implements Runnable  {   
  String task_name;   
  //define ReentrantLock object 
  ReentrantLock thrd_lck;   
  //ThreadClass constructor initialized lock and task name
  public ThreadClass(ReentrantLock r_lock, String t_name)   {   
    thrd_lck = r_lock;   
    task_name = t_name;   
  }   
  //thread run () method
  public void run()    {   
    boolean bool_val = false;   
    while (!bool_val)   {   
      //check for Outer Lock   
      boolean tryLock_val = thrd_lck.tryLock();   
      //  if lock is free, do the following   
      if(tryLock_val)   {   
        try   {   
           for(int i=0;i<=6;) {  
              if(i>=2)  {  
                  thrd_lck.lock();  
                  Thread thread_one = new Thread();  
                  System.out.println("Thread Created.....");  
                  if(i==3) {  
                      thread_one.setName("Maint Thread2");  
                      System.out.println("Thread Created.....");  
                  }  
              }  
           if(i==4)  
                  thrd_lck.unlock();     break;  
          }  
          System.out.println("ReentrantLock=>Is locked after sleep(1500) : " + thrd_lck.isLocked());   
          System.out.println("Work done for task : " + task_name );   
          bool_val = true;   
        }
catch(Exception e)   
        {   
          e.printStackTrace();   
        }   
      }   
	}
}
}


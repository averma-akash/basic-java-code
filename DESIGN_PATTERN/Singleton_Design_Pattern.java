/*Definition: 
The singleton pattern is a design pattern that restricts the instantiation of a class to one object. 

Sometimes we need to have only one instance of our class for example a single DB connection shared by multiple objects as creating a separate DB connection for every object may be costly. Similarly, there can be a single configuration manager or error manager in an application that handles all problems instead of creating multiple managers.

-  We  should create a static variable so that it can hold one single instance of our class .	
		private static exampleClass  uniqueInstance ;
-  We should declare the constructor private so that  only Class itself can instantiate the object . Outside
     classes will not be able to see  the class constructor .
	 
there is possibility that two threads simultaneously try to access the method and we might end up with two different class objects , thats why method is     synchronized . In other words , By adding synchronized keyword to the method , we force every thread to wait for its turn before it can enter the method .
So that , two threads do not enter the method at the same time .

******** What would happen if we do not have a synchronized method for returning Singleton instance in a multi-threaded environment? **********

In a multi-threaded environment, if we have a non-synchronized method for returning instances, there are chances that the method can create more than one instance. Consider that we have 2 threads and both enter the condition for checking if the instance already exists. Both threads will find that the instance has not been created and hence both will create the class instances. This goes against the principle of the Singleton pattern. Hence, in a multi-threaded environment, it is recommended to use synchronized checks.

********* How can you achieve thread-safe singleton patterns in Java? ************

A thread-safe singleton class is created which helps in object initialization in the presence of multiple threads. It can be done using multiple ways:

********* Using Enums:  *********

Enums are the simplest means of creating a thread-safe singleton class in Java because the synchronization support is inherently done by Java itself. Enums are by default final and this also helps in preventing multiple initializations at the time of serialization.*/

   public enum ThreadSafeSingleton{
      SINGLETON_INSTANCE;
      public void display(){
          System.out.println("Thread-safe singleton Display");
      }
   }
   // The Singleton class methods can be invoked as below
   ThreadSafeSingleton.SINGLETON_INSTANCE.display();
   
*/******** Using Static Field Initialization:  *********

Thread-safe singleton can also be created by creating the instance at the time of class loading. This is achieved by making use of static fields as the Classloader guarantees that the instances are initialized during class loading and the instance is not visible until that has been fully created.*/

public class ThreadSafeSingleton{
      private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();
      private ThreadSafeSingleton(){ }
      public static ThreadSafeSingleton getInstance(){
          return INSTANCE;
      }
      public void display(){
          System.out.println("Thread-safe Singleon");
      }
   }
   ThreadSafeSingleton.getInstance().display();
   
/*But the disadvantage of this way is that the initialization cannot be done lazily and the getInstance() method is called even before any client can call.

********* Using synchronized keyword: *********

We can make use of the synchronized keyword upon the getInstance method as shown below.
In this method, we can achieve lazy initialization, and also since we use synchronized keywords, the object initialization is thread-safe.
The only problem is that since the whole method is synchronized, the performance is impacted in the presence of multiple threads.*/

   public class ThreadSafeSingleton
   {
    /* Creating private instance to make it accessible only by getInstance() method */
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton() {}
    /* Making constructor private so that objects cant be initialized outside the class */
	
    synchronized public static ThreadSafeSingleton getInstance(){
      if (this.instance == null)
      {
        // if instance is null, initialize
        this.instance = new ThreadSafeSingleton();
      }
      return this.instance;
    }
   }
/********* Double-check locking: *********

Here, we will be using a synchronized block of code within the getInstance method instead of making the whole method synchronized. This ensures that only a handful of threads have to wait only for the first time thereby not impacting the performance.*/

   public class ThreadSafeSingleton {
    // Creating private instance to make it accessible only by getInstance() method
	
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){
      // Making constructor private so that objects cant be initialized outside the class
    }
    public static ThreadSafeSingleton getInstance(){
      if (instance == null){
        //synchronized block of code
        synchronized (ThreadSafeSingleton.class){
          if(instance==null)
          {
            // initialize only if instance is null
            instance = new ThreadSafeSingleton();
          }
        }
      }
      return instance;
    }
   }
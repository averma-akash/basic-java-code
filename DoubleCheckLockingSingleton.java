// Double Check Locking Singleton Pattern Example

class DoubleCheckLockingSingleton {
	
	/*A static volatile field is used to hold the instance of the Singelton class. The volatile variable is key here,
	without volatile, it won't be thread-safe because volatile provides the happens-before guarantee and when a volatile
	read is happening the memory barrier is refreshed*/
	
	private static volatile DoubleCheckLockingSingleton instanceVariable = null;
	
	/*The constructor is made private to disable instance creation outside of this class,
	but you can create an instance inside the class and that's what your getInstance() method does. */
	
	private DoubleCheckLockingSingleton() { }
	
	public static DoubleCheckLockingSingleton instance() {
		if (instanceVariable == null) { // 1st check 
			synchronized (DoubleCheckLockingSingleton.class) {
				if (instanceVariable == null) { // 2nd check  
				instanceVariable = new DoubleCheckLockingSingleton();
				}
			}
		}
		return instanceVariable; 
	}
}

/*
3) There are two checks to see if the _instance member variable is initialized or not and
that's why this code idiom it's called a double-checked locking idiom.

4) The first check is non-synchronized, which may see a partially constructed
object because of instruction re-ordering by the compiler or JVM.

5) The second check is inside the synchronized block and only executes one time 
during the lifespan of Singleton. That's why you get the performance boost becuase 
locking only happens one time during the lifespan of the Singleton instance.

*/

public class Singleton{
    private static final Singleton INSTANCE = new Singleton();
 
    private Singleton(){ }

    public static Singleton getInstance(){
        return INSTANCE;
    }
    public void show(){
        System.out.println("Singleon using static initialization in Java");
    }
}

//Here is how to access this Singleton class
Singleton.getInstance().show();

/*here we are not creating Singleton instance inside getInstance() method instead it will be created by ClassLoader. Also, private constructor makes impossible to create another instance, */



public enum Singleton{
    INSTANCE;
 
    public void show(){
        System.out.println("Singleton using Enum in Java");
    }
}

//You can access this Singleton as Singleton.INSTANCE and call any method like below
Singleton.INSTANCE.show();

/*Using Enum to create Singleton is by far the most simple and effective way to create thread-safe Singleton in Java, as the thread-safety guarantee is provided by the Java programming language itself. 

You don't need to bother about the thread-safety issues. Since Enum instances are by default final in Java, it also provides safety against multiple instances due to serialization. 
*/


Read more: https://javarevisited.blogspot.com/2012/12/how-to-create-thread-safe-singleton-in-java-example.html#ixzz7DnJHxqro
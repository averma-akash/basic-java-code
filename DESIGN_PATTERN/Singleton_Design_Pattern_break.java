//Prevent Breaking a Singleton Class Pattern

public final class Singleton {

    private static volatile Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Singleton object1 = Singleton.getInstance();
        Singleton object2 = Singleton.getInstance();
        System.out.println("Hashcode of Object 1 - " + object1.hashCode());
        System.out.println("Hashcode of Object 2 - " + object2.hashCode());
    }
} 

/*
Output:
Hashcode of Object 1 - 1836019240
Hashcode of Object 2 - 1836019240

Reflection
----------
*/

import java.lang.reflect.Constructor;

public class ReflectionSingleton {
    public static void main(String[] args)  {

        Singleton objOne = Singleton.getInstance();
        Singleton objTwo = null;
        try {
            Constructor constructor = Singleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            objTwo = (Singleton) constructor.newInstance();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        System.out.println("Hashcode of Object 1 - "+objOne.hashCode());
        System.out.println("Hashcode of Object 2 - "+objTwo.hashCode());

    }
}
/*
Prevent Singleton Pattern From Reflection
There are many ways to prevent Singleton pattern from Reflection API, but one of the best solutions is to throw a run-time exception in the constructor if the instance already exists. In this, we can not able to create a second instance.

Deserialization:
----------------
*/

import java.io.*;

public class DeserializationSingleton {

    public static void main(String[] args) throws Exception {

        Singleton instanceOne = Singleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
        Singleton instanceTwo = (Singleton) in.readObject();
        in.close();

        System.out.println("hashCode of instance 1 is - " + instanceOne.hashCode());
        System.out.println("hashCode of instance 2 is - " + instanceTwo.hashCode());
    }

}

/*
ashCode of instance 1 is - 2125039532
hashCode of instance 2 is - 381259350


Prevent Singleton Pattern From Deserialization
To overcome this issue, we need to override readResolve() method in the Singleton class and return the same Singleton instance. Update Singleton.java, with below method.
*/

protected Object readResolve() { 
           return instance; 
     }  
	 
//Cloning
//---------

public class CloningSingleton {
    public static void main(String[] args) throws CloneNotSupportedException, Exception {
        Singleton instanceOne = Singleton.getInstance();
        Singleton instanceTwo = (Singleton) instanceOne.clone();
        System.out.println("hashCode of instance 1 - " + instanceOne.hashCode());
        System.out.println("hashCode of instance 2 - " + instanceTwo.hashCode());
    }
}
/*
Here is the output:

hashCode of instance 1 - 1836019240
hashCode of instance 2 - 325040804

Prevent Singleton Pattern From Cloning
--------------------------------------

we need to implement/override the clone() method and throw an exception CloneNotSupportedException from the clone method. If anyone tries to create a clone object of Singleton, it will throw an exception, as shown in the below code.
*/
@Override
protected Object clone() throws CloneNotSupportedException  {
        throw new CloneNotSupportedException();
   }
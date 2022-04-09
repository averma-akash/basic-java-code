/*1. Java Object Creation by new keyword

By using the new keyword, we can call any type of constructor of the class that is, either the parameterized constructor or non-parameterized constructor. */

public class NewKeyword
{
  String name = "TechVidvan Java Tutorial";
  public static void main(String[] args)
  {
    //Creating object using new keyword
    NewKeyword obj = new NewKeyword();
    //Accessing the class variable using the object
    System.out.println(obj.name);
  }
}

/*
2. Java Object Creation by newInstance() method of Class class

We use the newInstance() method of a Class class to create an object. This newInstance() method calls the no-arg constructor of the class to create the object.
*/

public class NewInstanceMethod
{
  String name = "TechVidvan Java Tutorial";
  public static void main(String[] args)
  {
    try
    {
      Class cls = Class.forName("com.techvidvan.objectcreation.NewInstanceMethod");
      NewInstanceMethod obj =(NewInstanceMethod) cls.newInstance();
      System.out.println(obj.name);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}

/*
3. Java Object Creation by newInstance() method of Constructor class

We can also use the newInstance() method of java.lang.reflect.Constructor class to create an object. The newInstance() method of the Constructor class is similar to the newInstance() method of the Class class.
*/

import java.lang.reflect.*;
public class NewInstanceMethod
{
  private String name;
  public void setName(String name)
  {
    this.name = name;
  }
  public static void main(String[] args)
    {
    try
    {
      Constructor<NewInstanceMethod> constructor =            
                        NewInstanceMethod.class.getDeclaredConstructor();
      NewInstanceMethod obj = constructor.newInstance();
      obj.setName("TechVidvan Java Tutorial");
      System.out.println(obj.name);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}

/*
4. Java Object Creation by clone() method
When we call the clone() method through an object, the Java compiler automatically creates a new object of that class. JVM actually copies all content of the older object into the newly created object.

To use the clone() method on an object we have to implement the Cloneable interface and override the clone() method in our class.
*/

public class CloneMethod implements Cloneable
{
  @Override
  protected Object clone() throws CloneNotSupportedException
  {
    return super.clone();
  }
  String name = "TechVidvan Java Tutorial";
  public static void main(String[] args)
  {
    CloneMethod obj1 = new CloneMethod();
    try
    {
      CloneMethod obj2 = (CloneMethod) obj1.clone();
      System.out.println(obj2.name);
    }
    catch (CloneNotSupportedException e)
    {
      e.printStackTrace();
    }
  }
}

/*
5. Java Object Creation using deserialization
When we serialize an object and then deserialize it, JVM creates a new object. To deserialize an object, we need to implement the java.io.Serializable.
*/
public class Employee implements java.io.Serializable
{
  public String name;
  public int id;
  public void mailCheck() {
  }
}

import java.io.*;
public class Serialization
{
  public static void main(String [] args)
  {
    Employee e = new Employee();
    e.name = "Ayush Verma";
    e.id=101;
    try
    {
      FileOutputStream fileOut = new       FileOutputStream("/tmp/employee.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(e);
out.close();
      fileOut.close();
      System.out.printf("Serialized data is saved in /tmp/employee.ser");
    } catch (IOException i)
    {
      i.printStackTrace();
    }
  }
}
//Code to deserialize an object:
import java.io.*;
public class Deserialization
{
  public static void main(String [] args)
  {
    Employee e = null;
    try
    {
      FileInputStream fileIn = new       FileInputStream("/tmp/employee.ser");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      e = (Employee) in.readObject();
      in.close();
      fileIn.close();
    } catch (Exception ex)
    {
      System.out.println("Employee class not found");
      ex.printStackTrace();
      return;
    }
    System.out.println("Deserialized Employee...");
    System.out.println("Name: " + e.name);
    System.out.println("Id: " + e.id);
  }
}
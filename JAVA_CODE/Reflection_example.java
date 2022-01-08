import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
class ReflectionDemo {
  private String str;
  public ReflectionDemo() {
    str = "Techvidvan Java Tutorial";
  }
  public void method1() {
    System.out.println("\nThe string is: " + str);
  }
  public void method2(int num1) {
    System.out.println("\nThe number is: " + num1);
  }
  private void method3() {
    System.out.println("\nprivate method invoked");
  }
}
public class Test {
  public static void main(String args[]) {
    ReflectionDemo obj = new ReflectionDemo();
    Class cls = obj.getClass();
    System.out.println("\nThe name of the class is: " + cls.getName());
    Constructor constructor = cls.getConstructor();
    System.out.println("\nThe name of the constructor is: " + constructor.getName());
    System.out.println("\nThe public methods of the class are: ");
    Method[] methods = cls.getMethods();
    for (Method method: methods)
    System.out.println(method.getName());
    Method methodCall1 = cls.getDeclaredMethod("method2", int.class);
    methodCall1.invoke(obj, 35);
    Field field = cls.getDeclaredField("str");
    field.setAccessible(true);
    field.set(obj, "Java");
    Method methodCall2 = cls.getDeclaredMethod("method1");
    methodCall2.invoke(obj);
    Method methodCall3 = cls.getDeclaredMethod("method3");
    methodCall3.setAccessible(true);
    methodCall3.invoke(obj);
  }
}
Output: 

The name of the class is: ReflectionDemo
The name of the constructor is: ReflectionDemo
The public methods of the class are:
method2
method1
wait
wait
wait
equals
toString
hashCode
getClass
notify
notifyAll
The number is: 35
The string is: Java
private method invoked
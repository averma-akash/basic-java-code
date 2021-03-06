/*
CyclicBarrier − 

It is a tool to synchronize threads processing using some algorithm. It enables a set of threads to wait for each other till they reach a common execution point or common barrier points, and then let them further continue execution. One can reuse the same CyclicBarrier even if the barrier is broken by setting it. 

A synchronization technique that allows a set of threads to all wait for each other to reach a common barrier point.
It maintains a count of threads
If one thread is interrupted while waiting then all other waiting threads will throw BrokenBarrierException
*/


//JAVA program to demonstrate execution on Cyclic Barrier
  
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
  
class Computation1 implements Runnable
{
    public static int product = 0;
    public void run()
    {
        product = 2 * 3;
        try
        {
            Tester.newBarrier.await();
        } 
        catch (InterruptedException | BrokenBarrierException e) 
        {
            e.printStackTrace();
        }
    }
}
  
class Computation2 implements Runnable
{
    public static int sum = 0;
    public void run()
    {
        // check if newBarrier is broken or not
        System.out.println("Is the barrier broken? - " + Tester.newBarrier.isBroken());
        sum = 10 + 20;
        try
        {
            Tester.newBarrier.await(3000, TimeUnit.MILLISECONDS);
          
            // number of parties waiting at the barrier
            System.out.println("Number of parties waiting at the barrier "+
            "at this point = " + Tester.newBarrier.getNumberWaiting());
        } 
        catch (InterruptedException | BrokenBarrierException e) 
        {
            e.printStackTrace();
        } 
        catch (TimeoutException e) 
        {
            e.printStackTrace();
        }
    }
}
  
  
public class Tester implements Runnable
{
    public static CyclicBarrier newBarrier = new CyclicBarrier(3);
      
    public static void main(String[] args)
    {
        // parent thread
        Tester test = new Tester();
          
        Thread t1 = new Thread(test);
        t1.start();
    }
    public void run()
    {
        System.out.println("Number of parties required to trip the barrier = "+
        newBarrier.getParties());
        System.out.println("Sum of product and sum = " + (Computation1.product + 
        Computation2.sum));
          
        // objects on which the child thread has to run
        Computation1 comp1 = new Computation1();
        Computation2 comp2 = new Computation2();
          
        // creation of child thread
        Thread t1 = new Thread(comp1);
        Thread t2 = new Thread(comp2);
          
        // moving child thread to runnable state
        t1.start();
        t2.start();
  
        try
        {
            Tester.newBarrier.await();
        } 
        catch (InterruptedException | BrokenBarrierException e) 
        {
            e.printStackTrace();
        }
          
        // barrier breaks as the number of thread waiting for the barrier
        // at this point = 3
        System.out.println("Sum of product and sum = " + (Computation1.product + 
        Computation2.sum));
                  
        // Resetting the newBarrier
        newBarrier.reset();
        System.out.println("Barrier reset successful");
    }
}
/*Output:

<Number of parties required to trip the barrier = 3
Sum of product and sum = 0
Is the barrier broken? - false
Number of parties waiting at the barrier at this point = 0
Sum of product and sum = 36
Barrier reset successful

Explanation: 

The value of (sum + product) = 0 is printed on the console because the child thread has’t yet ran to set the values of sum and product variable. Following this, (sum + product) = 36 is printed on the console because the child threads ran setting the values of sum and product. Furthermore, the number of waiting thread on the barrier reached 3, due to which the barrier then allowed all thread to pass and finally 36 was printed. The value of “Number of parties waiting at the barrier at this point” = 0 because all the three threads had already called await() method and hence, the barrier is no longer active. In the end, newBarrier is reset and can be used again.
*/
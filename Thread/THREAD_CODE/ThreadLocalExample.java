package interview;
/*
ThreadLocal variables are special kinds of variables created and provided by the Java ThreadLocal class. These variables are only allowed to be read and written by the same thread. Two threads cannot be able to see each other’s ThreadLocal variable, so even if they will execute the same code, then there won't be any race condition and the code will be thread-safe.  

10 
33 
10 33
*/
public class ThreadLocalExp   
{   
     public static class MyRunnable implements Runnable    
   {   
       private ThreadLocal<Integer> threadLocal =   
              new ThreadLocal<Integer>();   
      @Override   
       public void run() {   
           threadLocal.set( (int) (Math.random() * 50D) );   
           try    
           {   
               Thread.sleep(1000);   
           } catch (InterruptedException e) {   
           }   
           System.out.println(threadLocal.get());   
       }   
   }   
   public static void main(String[] args)    
   {   
       MyRunnable runnableInstance = new MyRunnable();    
       Thread t1 = new Thread(runnableInstance);   
       Thread t2 = new Thread(runnableInstance);   
      // this will call run() method    
       t1.start();   
       t2.start();   
   }   
} 

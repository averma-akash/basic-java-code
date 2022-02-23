import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
  
class CallableExample implements Callable
{
  
    public Object call() throws Exception
    {
        // Create random number generator
        Random generator = new Random();
  
        Integer randomNumber = generator.nextInt(5);
  
        // To simulate a heavy computation,
        // we delay the thread for some random time
        Thread.sleep(randomNumber * 1000);
  
        return randomNumber;
    }
}

//Here is the code for an example Callable, which will return a random number after a delay of around 0 – 4 seconds.
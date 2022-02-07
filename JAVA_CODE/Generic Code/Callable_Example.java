// Java Program to illustrate Callable interface

// Importing classes from java.util package
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// Class
// Implementing the Callable interface
class CallableExample implements Callable {
	
// Main driver method
public static void main(String args[])
{
	
	// public Object call() throws Exception
	
		
	Random generator = new Random();

	Integer randomNumber = generator.nextInt(5);

		
	Thread.sleep(randomNumber * 1000);

	return randomNumber;
	}
	
}

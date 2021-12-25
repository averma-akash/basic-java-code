// Java Program to implement Runnable interface

// Importing FileNotFound class from
// input output classes bundle
import java.io.FileNotFoundException;

// Class
// Implementing the Runnable interface
public class RunnableImpl implements Runnable {

	// Main driver method
	public static void main(String[] args)
	{

		// Run method
		public void run()
		{
			// Display message when the thread executes
			System.out.println(
				Thread.currentThread().getName()
				+ ", executing run() method!");

			// Try block to check if any exception occurs
			try {
				throw new FileNotFoundException();
			}

			// Catch block to handle the exception
			catch (FileNotFoundException e) {

				// Display message
				System.out.println("Must catch here!");

				// Print the line number
				// where exception occured
				e.printStackTrace();
			}

			// Here forcefully it
			int rem = 1 / 0;
		}
	}

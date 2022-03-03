package interview;
/*
The Java ThreadLocal class enables you to create variables that can only be read and written by the same thread. if two threads are executing the same code, and the code has a reference to the same ThreadLocal variable, the two threads cannot see each other's ThreadLocal variables. It is another way to achieve thread-safety.
*/
public class ThreadLocalExample {
	public static void main(String[] args) throws InterruptedException {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}
}

class MyRunnable implements Runnable {

	//private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	private ThreadLocal threadLocal = new ThreadLocal<String>() {
	    @Override protected String initialValue() {
	        return String.valueOf(System.currentTimeMillis());
	    }
	};

	@Override
	public void run() {
		//threadLocal.set((int) (Math.random() * 10));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		System.out.println(threadLocal.get());
	}
}

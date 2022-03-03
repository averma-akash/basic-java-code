package interview;

public class PrintThreadsSequentiallyMain {

	public static void main(String[] args) {

		PrintSequenceRunnable runnable1 = new PrintSequenceRunnable(1);
		PrintSequenceRunnable runnable2 = new PrintSequenceRunnable(2);
		PrintSequenceRunnable runnable3 = new PrintSequenceRunnable(0);

		Thread t1 = new Thread(runnable1, "Thread 1");
		Thread t2 = new Thread(runnable2, "Thread 2");
		Thread t3 = new Thread(runnable3, "Thread 3");

		t1.start();
		t2.start();
		t3.start();
	}

}

class PrintSequenceRunnable implements Runnable {

	public int PRINT_NUMBERS_UPTO = 5;
	static Object lock = new Object();
	static int number = 1;
	int remainder;

	PrintSequenceRunnable(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO - 1) {
			synchronized (lock) {
				while (number % 3 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}

	}

}

/*
Thread 1 1
Thread 2 2
Thread 3 3
Thread 1 4
Thread 2 5
*/
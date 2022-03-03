package interview;

import java.util.concurrent.Semaphore;

public class OddEvenUsingThread {

	public static void main(String[] args) {

		PrintEvenOdd sp = new PrintEvenOdd();
		Thread odd = new Thread(new Odd(sp, 20), "Odd");
		Thread even = new Thread(new Even(sp, 20), "Even");
		odd.start();
		even.start();

	}

}

class PrintEvenOdd {

	private Semaphore semEven = new Semaphore(0);
	private Semaphore semOdd = new Semaphore(1);

	void printEvenNum(int num) {
		try {
			semEven.acquire();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(Thread.currentThread().getName() + "-->"+ num);
		semOdd.release();
	}

	void printOddNum(int num) {
		try {
			semOdd.acquire();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(Thread.currentThread().getName() + "-->"+ num);
		semEven.release();

	}
}

class Even implements Runnable {
	private PrintEvenOdd sp;
	private int max;

	public Even(PrintEvenOdd sp, int max) {
		super();
		this.sp = sp;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 2; i <= max; i = i + 2) {
			sp.printEvenNum(i);
		}
	}
}

class Odd implements Runnable {
	private PrintEvenOdd sp;
	private int max;

	public Odd(PrintEvenOdd sp, int max) {
		super();
		this.sp = sp;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 1; i <= max; i = i + 2) {
			sp.printOddNum(i);
		}
	}

}

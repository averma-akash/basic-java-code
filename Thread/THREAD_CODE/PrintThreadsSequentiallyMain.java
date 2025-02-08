package interview.nagarro;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Test {

	private static final int counter = 10;

	private static Semaphore s1 = new Semaphore(1);
	private static Semaphore s2 = new Semaphore(0);
	private static Semaphore s3 = new Semaphore(0);

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < counter; i++) {
				try {
					s1.acquire();
					System.out.println("Thread 1 ");
					s2.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < counter; i++) {
				try {
					s2.acquire();
					System.out.println("Thread 2 ");
					s3.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t3 = new Thread(() -> {
			for (int i = 0; i < counter; i++) {
				try {
					s3.acquire();
					System.out.println("Thread 3 ");
					s1.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		/*
		 * Completable future example 2nd way
		 */
		
		CompletableFutureSequentialExecution();

	}

	private static void CompletableFutureSequentialExecution() {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		CompletableFuture<Void> future = CompletableFuture.completedFuture(null);
		
		for (int i = 1; i <= counter; i++) {
            final int iteration = i;
            
            future = future.thenRunAsync(() -> System.out.println("Thread 1 - " + iteration), executor)
            .thenRunAsync(() -> System.out.println("Thread 2 - " + iteration), executor)
            .thenRunAsync(() -> System.out.println("Thread 3 - " + iteration), executor);
           
		}
		future.join();
		executor.shutdown();
		
	}

}

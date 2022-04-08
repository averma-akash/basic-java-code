package practicebook.java;

public class DeadLockDemo {
	/* * This method request two locks, first String and then Integer */

	public void method1() { 
		synchronized (String.class) { 
			System.out.println("Aquired lock on String.class object"); 
			synchronized (Integer.class) {
				System.out.println("Aquired lock on Integer.class object");
			} 
		}
	}
	
	/* * This method also requests same two lock but in exactly * Opposite order i.e. first Integer and then String. * This creates potential deadlock, if one thread holds String lock * and other holds Integer lock and they wait for each other, forever. */

	public void method2() {
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println("Aquired lock on String.class object");
			}
		}
	}
}
/*
If method1() and method2() both will be called by two or many threads, there is a good chance of deadlock because if thread 1 acquires lock on Sting object while executing method1() and thread 2 acquires lock on Integer object while running method2() both will be waiting for each other to release the lock on Integer and String to proceed further which will never happen.*/



public class DeadLockFixed {
	// Both method are now requesting lock in same order, * first Integer and then String. * You could have also done reverse e.g. first //String and then Integer, * both will solve the problem, as long as both method are requesting lock * in consistent order.
	
	
	public void method1() {
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println("Aquired lock on String.class object");
				} 
			} 
		}
	public void method2() {
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println("Aquired lock on String.class object");
			} 
		} 
	}
}

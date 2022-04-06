/*Garbage collection in Java is the process by which Java programs perform automatic memory management.
Java garbage collection is an automatic process of looking at heap memory, identifying which objects are in use and which are not, and deleting the unused objects. 

Phase 1: Mark Phase 
When an object is created, its mark bit is set to 0(false). In the Mark phase, we set the marked bit for all the reachable objects (or the objects which a user can refer to) to 1(true). 

Now to perform this operation we simply need to do a graph traversal, a depth-first search approach would work for us. Here we can consider every object as a node and then all the nodes (objects) that are reachable from this node (object) are visited and it goes on till we have visited all the reachable nodes.

Phase 2: Sweep Phase 
it clears the heap memory for all the unreachable objects. All those objects whose marked value is set to false are cleared from the heap memory,

Garbage collection algorithms
	Mark and sweep
	Concurrent mark sweep (CMS) garbage collection -- It scans heap memory using multiple threads. It was modified to take advantage of faster systems and had performance enhancements.It attempts to minimize the pauses due to garbage collection by doing most of the garbage collection work concurrently with the application threads. 
	
	Serial garbage collection
	Parallel garbage collection
	G1 garbage collection 
*/


package practicebook.java;

public class GarbageCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee e1 = new Employee(null);
		Employee e2 = new Employee(null);
		
		e1= null;
		e2= null;
		
		System.gc();

	}
	
}

class Employee {
	private String id;

	public Employee(String id) {
		super();
		this.id = id;
	}
	
	/**
	 * Garbage collector internally call finalize method so we can override it and use as per our purpose
	 */
	@Override
	protected void finalize() {
		System.out.println("GARBAGE COLLECTED");
	}
}

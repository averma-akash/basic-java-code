package practicebook.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PassByValueOrReference {

	public static void main(String[] args) {
		
		List<String> fruits = new ArrayList<String>(Arrays.asList("Mango", "Guava", "Tomato"));
		
		System.out.println("List before calling method : " +fruits);
		processData(fruits);
		System.out.println("List after calling method : " +fruits);
	}

	private static void processData(List<String> fruitsRef) {
		/*
		 * “fruits” is passed to the processData function. “fruitsRef” is a copy of the “fruits” param. 
		 * Both fruits and fruitsRef are created on Stack. They are two different references. 
		 * But the interesting point is, it points to the same underlying object in Heap. 
		 * So any change that you make using one reference is going to impact the common object.
		 */
		fruitsRef.add("Papaya");
		
		/*
		 * In this case, we used the “new” operator to change the reference of the fruitsRef variable. f
		 * ruitsRef now points to a new object and hence any change that you make in this object is not going 
		 * to impact the original fruits list object.
		 */
		fruitsRef = new ArrayList<String>();
		fruitsRef.add("Grapes");
		
	}

}

public class AllOopsConcept {

	public static void main(String[] args) {
		
		ClassA a=new ClassA();

		a.display();

		ClassB b=new ClassB();

		b.display();

		System.out.println(b.add(4,2));

		System.out.println(b.add(5.,2.)); //polymorphism

		EncapTest encap = new EncapTest();

		encap.setName("Practice");

		System.out.print("Name : " + encap.getName() );

		TwoWheeler test = new Honda();

		test.run();

	}

}

public class ClassA {
	public void display() {

		System.out.println("ClassA");

		}
}

public class ClassB extends ClassA{
	
	@Override
	public void display() {

	System.out.println("ClassB");

	}
	public int add(int x, int y) {

	return x+y;

	}
	//Overload
	public double add(double x,double y) {

	return x+y;

	}

}

public class EncapTest {
	
	private String name;

	public String getName() {

	return name;

	}

	public void setName(String newName) {

	name = newName;

	}

}

public abstract class TwoWheeler {
	
	public abstract void run();

}

public class Honda extends TwoWheeler {

	@Override
	public void run() {
		System.out.println("\nbike is Running..");

	}

}
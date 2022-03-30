package InterviewQuestion;

import java.util.HashMap;
import java.util.Objects;

public class HashMapCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Customer, Customer> map = new HashMap<Customer, Customer>();
		
		Customer cust1 = new Customer("Akash", 1);
		Customer cust2 = new Customer("Akash", 1);
		
		map.put(cust1, cust1);
		map.put(cust2, cust2);
		
		System.out.println(map);
	}

}

class Customer {
	String name;
	Integer id;
	public Customer(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + "]";
	}
	@Override
	public int hashCode() {
		//return Objects.hash(id, name);
		
		Object[] a = new Object[] {id,name};
		if (a == null)
            return 0;

        int result = 1;

        for (Object element : a)
            result = 31 * result + (element == null ? 0 : element.hashCode());

        return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
	
}

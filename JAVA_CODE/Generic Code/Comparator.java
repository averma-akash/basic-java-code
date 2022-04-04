public class Customer {
 
    // member variables
    int customerId;
    String customerName;
 
    // 2-arg parameterized constructor
    public Customer(int customerId, String customerName) {
        super();
        this.customerId = customerId;
        this.customerName = customerName;
    }
 
    // override toString() method
    @Override
    public String toString() {
        return "Customer ["
                + "customerId=" + customerId 
                + ", customerName=" + customerName
                + "]";
    }
}

import java.util.Comparator;
 
public class CustomerIdComparator implements Comparator<Customer> {
 
    @Override
    public int compare(Customer o1, Customer o2) {
        return o2.customerId - o1.customerId;
    }
}


import java.util.TreeSet;
 
public class CustomerReverseOrder {
 
    // main() method
    public static void main(String[] args) {
 
        // creating TreeSet object of type String
        TreeSet<Customer> ts = 
                new TreeSet<Customer>(new CustomerIdComparator());
 
        // adding elements to TreeSet object
        ts.add(new Customer(101, "Sundar Pichai"));
        ts.add(new Customer(107, "Satya Nadella"));
        ts.add(new Customer(103, "Shiv Nadar"));
        ts.add(new Customer(102, "Shantanu Narayen"));
        ts.add(new Customer(104, "Francisco D’Souza"));
        ts.add(new Customer(106, "Vishal Sikka"));
        ts.add(new Customer(105, "Chanda Kochhar"));
 
        System.out.println("Customized sorting"
                + " on basis of CustomerId\n");
 
        // natural ordering of customer name
        for(Customer cust : ts){
            System.out.println(cust.customerId + "  "
                    + cust.customerName);
        }
    }
}
// A Java program to demonstrate use of Comparable
import java.io.*;
import java.util.*;
 
// A class 'Movie' that implements Comparable
class Movie implements Comparable<Movie>
{
    private double rating;
    private String name;
    private int year;
 
    // Used to sort movies by year
    public int compareTo(Movie m)
    {
        return this.year - m.year;
    }
 
    // Constructor
    public Movie(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }
 
    // Getter methods for accessing private data
    public double getRating() { return rating; }
    public String getName()   {  return name; }
    public int getYear()      {  return year;  }
}
 
// Driver class
class Main
{
    public static void main(String[] args)
    {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
 
        Collections.sort(list);
 
        System.out.println("Movies after sorting : ");
        for (Movie movie: list)
        {
            System.out.println(movie.getName() + " " +
                               movie.getRating() + " " +
                               movie.getYear());
        }
    }
}
/******************************************************/

package in.bench.resources.java.collection;
 
public class Customer implements Comparable<Customer> {
 
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
 
    // override compareTo() method
    @Override
    public int compareTo(Customer o) {
        return this.customerName.compareTo(o.customerName);
    }
}

package in.bench.resources.java.collection;
 
import java.util.TreeSet;
 
public class CustomerNatrualOrder {
 
    // main() method
    public static void main(String[] args) {
 
        // creating TreeSet object of type String
        TreeSet<Customer> ts = new TreeSet<Customer>();
 
        // adding elements to TreeSet object
        ts.add(new Customer(101, "Sundar Pichai"));
        ts.add(new Customer(107, "Satya Nadella"));
        ts.add(new Customer(103, "Shiv Nadar"));
        ts.add(new Customer(102, "Shantanu Narayen"));
        ts.add(new Customer(104, "Francisco D’Souza"));
        ts.add(new Customer(106, "Vishal Sikka"));
        ts.add(new Customer(105, "Chanda Kochhar"));
 
        System.out.println("Natural ordering of Customer Name\n");
 
        // natural ordering of customer name
        for(Customer cust : ts){
            System.out.println(cust.customerId + "  "
                    + cust.customerName);
        }
    }
}
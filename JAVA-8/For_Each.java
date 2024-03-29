In Java 8, forEach method is used to iterate over collections and Streams

Example 1:

import java.util.ArrayList;  
import java.util.List;  
public class ForEachExample {  
    public static void main(String[] args) {
         List<String> gamesList = new ArrayList<String>();  
        gamesList.add("Football");  
        gamesList.add("Cricket");  
        gamesList.add("Chess");  
        gamesList.add("Hocky"); 
        gamesList.add("Football");  
        gamesList.add("Cricket");  
        gamesList.add(null);  
        gamesList.add(null);
        System.out.println("------------Iterating by passing lambda expression--------------");  
        gamesList.forEach(games -> System.out.println(games)); 
        
        System.out.println("------------Each Element Frequency--------------");
        Set<String> distinctFrequency = new HashSet<String>(gamesList);
        for(String s : distinctFrequency) {
        	System.out.println(s + " : " + Collections.frequency(gamesList, s));
        }
        System.out.println("------------Each Element Frequency withot null JAVA 8 --------------");
        
		Set<String> set = new HashSet<String>(gamesList);
		set.stream().filter(Objects::nonNull).forEach(e -> System.out.println(e+" : "+Collections.frequency(gamesList, e)));
    }  
}

Example 2: 

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
 
public class MaximumUsingStreamMain {
	public static void main(String[] args) {
         List<Employee> employeeList = createEmployeeList();
        Map<String, List<Employee>> map = employeeList.stream()
                                              .collect(Collectors.groupingBy(Employee::getName));
        map.forEach((name,employeeListTemp)->System.out.println("Name: "+name+" ==>"+employeeListTemp+"\n"));
    }
    
     public static List<Employee> createEmployeeList()
    {
        List<Employee> employeeList=new ArrayList<>();
 
        Employee e1=new Employee("John",21);
        Employee e2=new Employee("Martin",19);
        Employee e3=new Employee("Mary",31);
        Employee e4=new Employee("Mary",18);
        Employee e5=new Employee("John",26);
 
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
 
        return employeeList;
    }
}

class Employee {
    private String name;
    private Integer age;
    
    public String getName() {  
    return name;  
    }  
    public void setName(String name) {  
    this.name = name;  
    } 
    public Integer getAge() {  
        return age;  
    }  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
    Employee(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    
   
    public String toString(){
        return this.name+" "+this.age;  
 }  
}

/*
Name: John ==>[John 21, John 26]
Name: Martin ==>[Martin 19]

Name: Mary ==>[Mary 31, Mary 18]
*/
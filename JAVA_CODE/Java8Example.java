package interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8Example {
	public static void main(String[] args) {
		Department account = new Department("Account", 75);
		Department hr = new Department("HR", 50);
		Department ops = new Department("OP", 25);
		Department tech = new Department("Tech", 150);

		List<Employees> employeeList = Arrays.asList(new Employees("David", 32, "Matara", account),
				new Employees("Brayan", 25, "Galle", hr), new Employees("JoAnne", 45, "Negombo", ops),
				new Employees("Jake", 65, "Galle", hr), new Employees("Brent", 55, "Matara", hr),
				new Employees("Allice", 23, "Matara", ops), new Employees("Austin", 30, "Negombo", tech),
				new Employees("Gerry", 29, "Matara", tech), new Employees("Scote", 20, "Negombo", ops),
				new Employees("Branden", 32, "Matara", account), new Employees("Iflias", 31, "Galle", hr));
				
		System.out.println("------------ -------------");
		employeeList.stream().filter(e -> e.getCity().equalsIgnoreCase("Matara"))
				.sorted(Comparator.comparing(Employees::getName)).forEach(e -> System.out.println(e.getName()));
		System.out.println("------------ -------------");
		employeeList.stream().map(e -> e.getDepartment().getDepartmentName()).distinct().forEach(System.out::println);

		System.out.println("------------ -------------");
		employeeList.stream().map(Employees::getDepartment).filter(d -> d.getNoOfEmployees() > 50).distinct()
				.forEach(d -> System.out.println(d.getDepartmentName()));

		System.out.println("------------ -------------");
		String s = employeeList.stream().map(e -> e.getDepartment().getDepartmentName()).distinct().sorted().reduce("",
				(a, b) -> (a + "," + b));
		System.out.println(s);

		System.out.println("------------ -------------");
		if (employeeList.stream().anyMatch(e -> e.getDepartment().getDepartmentName().equalsIgnoreCase("HR"))) {
			System.out.println("Found employees frm HR department");
		}
		System.out.println("------------ -------------");
		employeeList.stream().filter(e -> e.getDepartment().getDepartmentName().equalsIgnoreCase("Account"))
				.map(Employees::getName).forEach(System.out::println);

		System.out.println("------------ -------------");
		employeeList.stream().map(e -> e.getDepartment().getNoOfEmployees()).reduce(Integer::max)
				.ifPresent(System.out::print);

		System.out.println("------------ -------------");
		employeeList.stream().map(e -> e.getDepartment().getNoOfEmployees()).distinct().reduce(Integer::sum)
				.ifPresent(System.out::println);
				
		System.out.println("------------ -------------");
		employeeList.stream().filter(e -> e.getName().startsWith("A")).forEach(e -> System.out.println(e.getName()));
	}
}

class Employees {

	private String name;
	private Integer age;
	private String city;
	private Department department;

	public Employees(String name, Integer age, String city, Department department) {
		this.name = name;
		this.age = age;
		this.city = city;
		this.department = department;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}

class Department {

	private String departmentName;

	private Integer noOfEmployees;

	public Department(String departmentName, Integer noOfEmployees) {
		this.departmentName = departmentName;
		this.noOfEmployees = noOfEmployees;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(Integer noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

}
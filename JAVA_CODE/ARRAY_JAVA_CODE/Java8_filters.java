/*
 * Meeting ID: 492 438 139 850
	Passcode: tFoh4x
 */
package interview.nagarro;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import interview.pojo.Employee;

public class Java8_filters {
	public static void main(String[] args) {
		List<Employee> empList = Employee.getEmpList();

		/**
		 * Print only 2nd highest salay
		 */
		Optional<Double> findFirst = empList.stream().map(Employee::getSalary).distinct()
				.sorted(Collections.reverseOrder()).skip(1).findFirst();

		findFirst.ifPresent(e -> System.out.println("2nd higest Salary : " + e));

		/**
		 * Print all 2nd highest salary with emp Name
		 */

		findFirst.ifPresent(salary -> {
			List<Employee> employees = empList.stream().filter(emp1 -> Math.abs(emp1.getSalary() - salary) < 0.0001)
					.collect(Collectors.toList());
			employees.forEach(
					emp2 -> System.out.println("2nd higest Salary : " + emp2.getEmpName() + " - " + emp2.getSalary()));
		});

		/**
		 * Find all employees with a salary greater than 5000.
		 */
		empList.stream().filter(e -> e.getSalary() > 5000).forEach(
				emp -> System.out.println("salary Greater than 5000 : " + emp.getEmpName() + " - " + emp.getSalary()));

		/**
		 * Retrieve employees whose names start with "A".
		 */

		empList.stream().filter(e -> e.getEmpName().startsWith("A"))
				.forEach(e -> System.out.println("Name starts with A : " + e.getEmpName()));

		/**
		 * Sort employees by salary in descending order.
		 */

		empList.stream().sorted(Comparator.comparingDouble(e -> ((Employee) e).getSalary()).reversed())
				.forEach(e -> System.out.println("sorted based on salary : " + e.getEmpName() + " - " + e.getSalary()));

		/**
		 * Age Between
		 */

		empList.stream().filter(e -> e.getAge() >= 25 && e.getAge() <= 35)
				.forEach(e -> System.out.println("Age Betwwen : " + e.getEmpName() + " - " + e.getAge()));
		;

		/**
		 * Group By Department Id
		 */

		Map<Integer, List<Employee>> collect = empList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartmentId()));

		collect.forEach((deptId, eList) -> {
			System.out.println("dept : " + deptId);
			eList.forEach(emp -> System.out.println(emp.getEmpName()));
		});
		
		/*
		 * Find the count of employees in each department.
		 */
		Map<Integer, Long> collect2 = empList.stream()
		.collect(Collectors.groupingBy(e -> e.getDepartmentId(), Collectors.counting()));
		
		collect2.forEach((deptId, count) -> {
			System.out.println("dept : " + deptId + " Count : "+count);
		});

	}

}

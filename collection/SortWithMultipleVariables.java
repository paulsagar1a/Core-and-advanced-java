package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortWithMultipleVariables {
	
	public static class SortList implements Comparator<Employee> {

		@Override
		public int compare(Employee obj1, Employee obj2) {
			int result = obj1.firstName.compareTo(obj2.firstName);
			if(result != 0) return result;
			result = obj1.lastName.compareTo(obj2.lastName);
			if(result != 0) return result;
			if(obj1.department > obj2.department) return 1;
			if(obj1.department < obj2.department) return -1;
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Sukhdev", "Singh", 2));
		list.add(new Employee("Labonita", "Guha", 2));
		list.add(new Employee("Veena", "Venvenkatesh", 5));
		list.add(new Employee("Shalini", "Vasta", 3));
		list.add(new Employee("Sumana", "Mukherjee", 1));
		list.add(new Employee("Paramjit", "Chawla", 4));
		list.add(new Employee("Sumana", "Mukherjee", 6));
		list.add(new Employee("Amrutha", "Venvenkatesh", 5));
		list.add(new Employee("Laboni", "Sen", 6));
		list.add(new Employee("Labonita", "Ghosh", 2));
		
		Collections.sort(list, new SortList());
		System.out.println("-----After sorting the employee list-----");
		Iterator<Employee> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}

class Employee {
	protected String firstName;
	protected String lastName;
	protected int department;
	
	public Employee(String firstName, String lastName, int department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}
	
	@Override
	public String toString() {
		return this.firstName+" "+this.lastName+" :: dept.-> "+this.department;
	}
}

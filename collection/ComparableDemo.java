package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ComparableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<>();
		list.add(new Student(2, "Arunima"));
		list.add(new Student(4, "Vaibhab"));
		list.add(new Student(3, "Sulekha"));
		list.add(new Student(1, "Mridula"));
		list.add(new Student(5, "Niladri"));
		Collections.sort(list);
		
		Iterator<Student> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}

class Student implements Comparable<Student> {
	private int id;
	private String name;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(Student obj) {
		if(this.id > obj.id) return 1;
		if(this.id < obj.id) return -1;
		return 0;
	}
	
	@Override
	public String toString() {
		return this.id+" "+this.name;
	}
}
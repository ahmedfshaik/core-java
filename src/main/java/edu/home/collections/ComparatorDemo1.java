package edu.home.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//Provide multiple sorting techniques for both built-in and user defined classes
public class ComparatorDemo1 {
	public static void main(String[] args) {
		EmployeeComparator e1 = new EmployeeComparator(2, "xyz");
		EmployeeComparator e2 = new EmployeeComparator(1, "abc");
		EmployeeComparator e3 = new EmployeeComparator(3, "pqr");
		List<EmployeeComparator> emplist = new ArrayList<EmployeeComparator>();
		emplist.add(e1);
		emplist.add(e2);
		emplist.add(e3);
		Collections.sort(emplist, new EnoSort()); // Customized sorting
													// order based on eno
		System.out.println(emplist.toString());
		Collections.sort(emplist, new EnameSort()); // Customized sorting
													// order based on ename
		System.out.println(emplist.toString());
	}
}

class EmployeeComparator {
	private int eno;
	private String ename;

	public EmployeeComparator() {
	}

	public EmployeeComparator(int eno, String ename) {
		this.eno = eno;
		this.ename = ename;
	}

	public int getEno() {
		return this.eno;
	}

	public String getEname() {
		return this.ename;
	}

	@Override
	public String toString() {
		return this.eno + " " + this.ename + "\t";
	}
}

// sort based on employee number
class EnoSort implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		EmployeeComparator e1 = (EmployeeComparator) o1;
		EmployeeComparator e2 = (EmployeeComparator) o2;
		Integer iRef1 = e1.getEno();
		Integer iRef2 = e2.getEno();
		return iRef1.compareTo(iRef2);
	}
}

// sorting based on employee name
class EnameSort implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		EmployeeComparator e1 = (EmployeeComparator) o1;
		EmployeeComparator e2 = (EmployeeComparator) o2;
		String str1 = e1.getEname();
		String str2 = e2.getEname();
		return str1.compareTo(str2);
	}

}
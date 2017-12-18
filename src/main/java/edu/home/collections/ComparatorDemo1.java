package edu.home.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Provide multiple sorting techniques for both built-in and user defined classes
public class ComparatorDemo1 {
    public static void main(final String[] args) {
        final EmployeeComparator e1 = new EmployeeComparator(2, "xyz");
        final EmployeeComparator e2 = new EmployeeComparator(1, "abc");
        final EmployeeComparator e3 = new EmployeeComparator(3, "pqr");
        final List<EmployeeComparator> emplist = new ArrayList<>();
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
    
    public EmployeeComparator(final int eno, final String ename) {
        this.eno = eno;
        this.ename = ename;
    }
    
    public int getEno() {
        return eno;
    }
    
    public String getEname() {
        return ename;
    }
    
    @Override
    public String toString() {
        return eno + " " + ename + "\t";
    }
}

// sort based on employee number
class EnoSort implements Comparator {
    @Override
    public int compare(final Object o1, final Object o2) {
        final EmployeeComparator e1 = (EmployeeComparator) o1;
        final EmployeeComparator e2 = (EmployeeComparator) o2;
        final Integer iRef1 = e1.getEno();
        final Integer iRef2 = e2.getEno();
        return iRef1.compareTo(iRef2);
    }
}

// sorting based on employee name
class EnameSort implements Comparator {
    @Override
    public int compare(final Object o1, final Object o2) {
        final EmployeeComparator e1 = (EmployeeComparator) o1;
        final EmployeeComparator e2 = (EmployeeComparator) o2;
        final String str1 = e1.getEname();
        final String str2 = e2.getEname();
        return str1.compareTo(str2);
    }
    
}
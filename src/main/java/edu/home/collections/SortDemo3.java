package edu.home.collections;

import java.util.Arrays;
import java.util.List;

//Multiple sorting techniques at a time
class Employee {
    private final int eno;
    private final String ename;
    
    Employee(final int no, final String name) {
        eno = no;
        ename = name;
    }
    
    public Integer getEno() {
        return eno;
    }
    
    public String getEname() {
        return ename;
    }
    
    @Override
    public String toString() {
        return eno + " " + ename + ", ";
    }
}

public class SortDemo3 {
    public static void main(final String[] args) {
        final List<Employee> employees = Arrays.asList(new Employee(2, "abc"), new Employee(1, "xyz"),
                new Employee(3, "pqr"));
        
        employees.sort((e1, e2) -> e1.getEno().compareTo(e2.getEno()));
        employees.forEach(System.out::print);
        System.out.println();
        
        employees.sort((e1, e2) -> e1.getEname().compareTo(e2.getEname()));
        employees.forEach(System.out::print);
    }
}

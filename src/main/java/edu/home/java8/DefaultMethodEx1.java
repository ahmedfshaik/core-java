package edu.home.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class DefaultMethodEx1 {
    
    public static void main(final String[] args) {
        final List<Student> students = new Vector<>();
        students.add(new Student(2, "abc"));
        students.add(new Student(1, "xyz"));
        students.add(new Student(3, "pqr"));
        System.out.println(students.toString());
        
        // Using sort() in Collections class before Java 8
        // Collections.sort(students, new SnoSort());
        // System.out.println(students.toString());
        
        // Using sort() in List interface in Java 8
        students.sort(new SnoSort());
        System.out.println(students.toString());
    }
}

class Student {
    
    private final int sno;
    private final String sname;
    
    Student(final int sno, final String sname) {
        this.sno = sno;
        this.sname = sname;
    }
    
    public int getSno() {
        return sno;
    }
    
    public String getSname() {
        return sname;
    }
    
    @Override
    public String toString() {
        return sno + " " + sname;
    }
}

class SnoSort
        implements Comparator<Student> {
    
    @Override
    public int compare(final Student s1, final Student s2) {
        final Integer iRef1 = s1.getSno();
        final Integer iRef2 = s2.getSno();
        return iRef1.compareTo(iRef2);
    }
}

package edu.home.collections;

import java.util.Arrays;
import java.util.List;

class Student implements Comparable<Student> {
    private final int sno;
    private final String sname;
    
    public Student(final int sno, final String sname) {
        this.sno = sno;
        this.sname = sname;
    }
    
    @Override
    public int compareTo(final Student s) {
        /*
         * if(this.sno<s.sno){
         * return -1;
         * }else if(this.sno>s.sno){
         * return +1;
         * }else{
         * return 0;
         * }
         */
        
        /*
         * Integer iRef1 = this.sno;
         * Integer iRef2 = s.sno;
         * return iRef1.compareTo(iRef2);
         */
        
        return sname.compareTo(s.sname);
    }
    
    @Override
    public String toString() {
        return sno + " " + sname;
    }
}

public class SortDemo2 {
    public static void main(final String[] args) {
        final List<Student> students = Arrays.asList(new Student(2, "abc"), new Student(1, "xyz"), new Student(3, "pqr"));
        
        /*
         * Collections.sort(students);
         * students.forEach(student->System.out.print(student+" "));
         */
        
        students.sort(null);
        students.forEach(student -> System.out.print(student + " "));
    }
}

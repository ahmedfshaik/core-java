package edu.home.java8;

interface Vehicle {
    
    default public void disp() {
        System.out.println("I am vehicle");
    }
}

class Car
        implements Vehicle {
    
    /*
     * public void disp() {
     * System.out.println("I am car");
     * }
     */
}

public class DefaultMethodEx3 {
    
    public static void main(final String[] args) {
        final Car obj = new Car();
        obj.disp();
    }
}

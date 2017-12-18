package edu.home.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionEx3 {
    
    public static void main(final String[] args) {
        final List<Customer> custs = new ArrayList<>();
        custs.add(new Customer(2, "abc"));
        custs.add(new Customer(1, "xyz"));
        custs.add(new Customer(3, "pqr"));
        
        // annonymous comparator
        Collections.sort(custs, new Comparator<Customer>() {
            
            @Override
            public int compare(final Customer c1, final Customer c2) {
                return c1.getCid().compareTo(c2.getCid());
            }
        });
        System.out.println(custs.toString());
        
        // lambda comparator
        // Collections.sort(custs, (Customer c1, Customer c2)->
        // c1.getCname().compareTo(c2.getCname()));
        Collections.sort(custs, (c1, c2) -> c1.getCname().compareTo(c2.getCname())); // Lambda
                                                                                     // type.
        System.out.println(custs.toString());
    }
}

class Customer {
    
    private final int cid;
    private final String cname;
    
    Customer(final int cid, final String cname) {
        this.cid = cid;
        this.cname = cname;
    }
    
    public Integer getCid() {
        return cid;
    }
    
    public String getCname() {
        return cname;
    }
    
    @Override
    public String toString() {
        return cid + " " + cname;
    }
}

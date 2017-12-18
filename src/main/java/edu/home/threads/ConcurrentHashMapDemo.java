package edu.home.threads;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//use jdk1.7
public class ConcurrentHashMapDemo {
    public static void main(final String[] args) {
        final Map<String, String> map = new ConcurrentHashMap<>(); // put
        // break
        // point
        // here
        
        map.put("India", "Delhi");
        map.put("Japan", "Tokyo");
        map.put("France", "Paris");
        map.put("Russia", "Moscow");
        map.put("Pakistan", "Islamabad");
        map.put("Srilanka", "Colombo");
        
        final Iterator<String> ittr = map.keySet().iterator(); // put break
                                                               // point here
        while (ittr.hasNext()) {
            final String countryObj = ittr.next();
            map.put("abc", "xyz"); // Ok.
            final String capital = map.get(countryObj);
            System.out.println(countryObj + "----" + capital);
        }
    }
}

package edu.home.threads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SynchronizedHashMapDemo {
    public static void main(final String[] args) {
        final Map<String, String> map = new HashMap<>(); // but
                                                                       // break
        // point here
        Collections.synchronizedMap(map); // becomes synchronized hashmap
        
        map.put("India", "Delhi");
        map.put("Japan", "Tokyo");
        map.put("France", "Paris");
        map.put("Russia", "Moscow");
        map.put("Pakistan", "Islamabad");
        map.put("Srilanka", "Colombo");
        
        final Iterator<String> ittr = map.keySet().iterator();
        while (ittr.hasNext()) {
            final String countryObj = ittr.next();
            map.put("abc", "xyz"); // throws ConcurrentModificationException
            final String capital = map.get(countryObj);
            System.out.println(countryObj + "----" + capital);
        }
    }
}

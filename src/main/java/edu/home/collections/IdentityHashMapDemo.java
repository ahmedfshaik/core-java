package edu.home.collections;

import java.util.IdentityHashMap;
import java.util.Map;

class IdentityHashMapDemo {
    public static void main(final String[] args) {
        // Map<Integer, String> m = new HashMap<Integer, String>();
        final Map<Integer, String> m = new IdentityHashMap<>();
        final Integer I1 = new Integer(10);
        final Integer I2 = new Integer(10);
        m.put(I1, "aspire");
        m.put(I2, "technologies");
        System.out.println(m);
    }
}

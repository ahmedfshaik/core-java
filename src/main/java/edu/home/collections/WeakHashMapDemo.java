package edu.home.collections;

import java.util.Map;
import java.util.WeakHashMap;

class Temp {
    @Override
    public String toString() {
        return "temp";
    }
    
    @Override
    protected void finalize() {
        System.out.println("finalize method");
    }
}

public class WeakHashMapDemo {
    public static void main(final String[] args) throws Exception {
        // Map<Temp, String> m=new HashMap<Temp, String>();
        final Map<Temp, String> m = new WeakHashMap<>();
        Temp t = new Temp();
        m.put(t, "aspire");
        System.out.println(m);
        t = null;
        System.gc();
        Thread.sleep(5000);
        System.out.println(m);
    }
}

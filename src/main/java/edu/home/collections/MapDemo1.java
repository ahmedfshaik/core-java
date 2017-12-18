package edu.home.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo1 {
    public static void main(final String[] args) {
        // Map<String, String> map = new Hashtable<String, String>();
        // Map<String, String> map = new HashMap<String, String>();
        final Map<String, String> map = new TreeMap<>();
        
        map.put("driverClassName", "oracle.jdbc.driver.OracleDriver");
        map.put("url", "jdbc:oracle:thin:@localhost:1521:xe");
        map.put("username", "system");
        map.put("password", "manager");
        map.put("password", "aspire123");
        // map.put(null, null);
        // System.out.println(map.toString());
        
        // Read keys
        final Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            final String key = keys.next();
            System.out.print(key + " ");
        }
        System.out.println();
        
        // Read values
        final Iterator<String> values = map.values().iterator();
        while (values.hasNext()) {
            final String value = values.next();
            System.out.print(value + " ");
        }
    }
}

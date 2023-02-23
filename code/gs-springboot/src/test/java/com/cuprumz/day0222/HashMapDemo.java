package com.cuprumz.day0222;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class HashMapDemo {
    public static void main(String[] args) {

        Map<String, Integer> m = new HashMap();

        m.put(System.currentTimeMillis() + "a", 1);
        m.put(System.currentTimeMillis() + "b", 2);
        m.put(System.currentTimeMillis() + "c", 3);


        for (Map.Entry e : m.entrySet()) {
            System.out.print(e.getValue());
        }
        
    }
}

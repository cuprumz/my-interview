package com.cuprumz.base;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NanoApp {
    public static void main(String[] args) {
        System.out.println(System.nanoTime());

        Map h = new ConcurrentHashMap();
        h.put("null", "null");
        System.out.println(h.get("null"));
//        h.put(null, null);
//        System.out.println(h.get(null));
    }
}

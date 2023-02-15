package com.cuprumz.base;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class MapApp {
    
    @Test
    public void permitNulls() {
        Map m = new TreeMap();
        m.put(null, null);
    }
}

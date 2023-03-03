package com.cuprumz.base;

import java.util.HashSet;
import java.util.Set;

public class App {

    static class Test {
        String value;
        Test(String val) {
            this.value = val;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj instanceof Test) {
                Test t = (Test) obj;
                return value.equals(t.value);
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Set l = new HashSet<>();
        l.add(new Test("Obj"));
        System.out.println(l.contains(new Test("Obj")));
    }
}

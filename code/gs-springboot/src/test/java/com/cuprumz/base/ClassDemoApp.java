package com.cuprumz.base;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ClassDemoApp {
    
    
    @Test
    public void getMethodVSGetDeclaredMethod() throws ClassNotFoundException {

        Class clz = Class.forName("com.cuprumz.utils.TimeUtils");

        System.out.println("getDeclaredMethods:");
        Arrays.stream(clz.getDeclaredMethods()).forEach(System.out::println);
        
        System.out.println("getMethods:");
        Arrays.stream(clz.getMethods()).forEach(System.out::println);
        
    }
}

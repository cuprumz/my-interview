package com.cuprumz.base;

public class OrderApp {

    public static void main(String[] args) {
        new Z(); // yxyz
    }
}

class X {
    Y y = new Y();
    X() {
        System.out.println("x");
    }
}

class Y {
    Y() {
        System.out.println("y");
    }
}

class Z extends X {
    Y y = new Y();
    Z() {
        System.out.println("z");
    }
}

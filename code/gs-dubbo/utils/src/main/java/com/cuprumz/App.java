package com.cuprumz;

import org.apache.dubbo.samples.annotation.EmbeddedZooKeeper;

public class App {
    public static void main(String[] args) {
        new EmbeddedZooKeeper(2181, false).start();
    }
}

package com.cuprumz.thread.visibility;

/**
 * stale data
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        
        ready = true;
        Thread.sleep(1000);
        number = 42;
//        System.out.println("modified");
    }

    static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }
    
}

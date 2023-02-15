package com.cuprumz.thread;

import com.cuprumz.utils.TimeUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Sequence {
    public static void main(String[] args) throws InterruptedException {
        TimeUtils.printNow();
        Sequence s = new Sequence();

        long start = System.nanoTime();
        int num = 7;
        Thread[] ts = new Thread[num];

        for (int i = 0; i < num; i++) {
            ts[i] = new Thread(new SequenceImpl(s));
        }

        for (int i = 0; i < num; i++) {
            ts[i].start();
        }
        Thread.sleep(1000);

        for (int i = 0; i < num; i++) {
            ts[i].interrupt();
        }
        long end = System.nanoTime();
        System.out.println("finally: " + s.getValue()/10000 + "w. with " + ((end-start) / 1000000) + "millis");
    }
    
    
    private int value;
    
    public   int getNext() {
//    public synchronized  int getNext() {
        return value++;
    }

    public int getValue() {
        return value;
    }
    
    static class SequenceImpl implements Runnable {

        Sequence sequence;

        Map<Integer, Integer> m = new ConcurrentHashMap<>();
        
        SequenceImpl(Sequence s) {
            sequence = s;
        }
        @Override
        public void run() {
            try {
                while (true) {
                    if (!Thread.currentThread().isInterrupted()) {
                        int i = sequence.getNext();
                        if (m.containsKey(i)) {
//                            System.out.println(i);
                            m.put(i, m.get(i) + 1);
                        } else {
                            m.put(i, 1);
                        }
//                    Thread.sleep(1000);
                    } else {
                        throw new InterruptedException();
                    }
                   
                }
            } catch (InterruptedException e) {
//                e.printStackTrace();
            } 
            finally {
//                System.out.println(sequence.getNext());
            }
        }
    }
}


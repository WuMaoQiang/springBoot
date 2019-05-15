package com.cc.demo.lesson2_web;

import ch.qos.logback.core.util.TimeUtil;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class TestEnum {

    public static void main(String args[]) {
        BlockingQueue blockingQueue = new SynchronousQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    blockingQueue.put("a");
                    System.out.println("a");
                    blockingQueue.put("b");
                    System.out.println("b");
                    blockingQueue.put("c");
                    System.out.println("c");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            blockingQueue.take();
            Thread.sleep(3000);
            blockingQueue.take();
            Thread.sleep(3000);
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}

package com.cc.demo.lesson2_web;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.*;

public class TestEnum {


    public static void main(String args[]) {
        new Thread(new HoldLockThread("lockAAA", "lockBBB")).start();
        new Thread(new HoldLockThread("lockBBB", "lockAAA")).start();
    }
}


class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(lockA+"想去獲取"+lockB+"..."+Thread.currentThread().getName());
            try {
                //让他等一会再去试图获取lockB，在这个时间线程2拿到了lockB
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(lockB+" 想去獲取"+lockA+"..."+Thread.currentThread().getName());
            }
        }

    }
}

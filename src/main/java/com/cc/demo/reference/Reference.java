package com.cc.demo.reference;

import com.cc.demo.lesson1.bean.Person;

public class Reference {


    public static void main(String[] args) {
        String aa = "1230";
        String bb = "1230";
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));




//        Person p = new Person();
//        WeakReference<Person> softReference = new WeakReference<Person>(p);
//        p=null;
//        System.gc();
//        Person person = softReference.get();
//        System.out.println(p + "..." + person);


//        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
//
//        PhantomReference<Person> personPhantomReference = new PhantomReference<>(p, referenceQueue);
//        personPhantomReference.get();
//        System.out.println(p + "..." + ".." + referenceQueue.poll());
//
//        p = null;
//        System.gc();
//        System.out.println(p + "..." + ".." + referenceQueue.poll());


    }
}

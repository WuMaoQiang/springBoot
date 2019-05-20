package com.cc.demo.reference;

import com.cc.demo.lesson1.bean.Person;
import sun.misc.GC;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class Reference {


    public static void main(String args[]) {

        Person p = new Person();
        WeakReference<Person> softReference = new WeakReference<Person>(p);
        p=null;
        System.gc();
        Person person = softReference.get();
        System.out.println(p + "..." + person);

    }
}

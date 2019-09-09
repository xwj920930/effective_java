package com.xwj.chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/***
 * 消除过期的对象引用
 * WeakHashMap的特点是，当除了自身有对key的引用外，
 * 此key没有其他引用那么此map会自动丢弃此值(只有自己持有)
 */
public class Sixth {
    //测试weakHashMap与hashMap的区别
    private Map<String,String> map=new HashMap<>();
    private Map<String,String> wMap=new WeakHashMap<>();
    private void init(){
        //必须用new String，如果用""会进入字符串常量池，不会回收对象
        String ref1= new String("obejct1");
        String ref2 = new String("obejct2");
        String ref3 = new String ("obejct3");
        String ref4 = new String ("obejct4");
        wMap.put(ref1, "chaheObject1");
        wMap.put(ref2, "chaheObject2");
        map.put(ref3, "chaheObject3");
        map.put(ref4, "chaheObject4");
        //因为ref1，ref2，ref3，ref4是方法内定义的变量，方法结束就消失
        System.out.println("String引用ref1，ref2，ref3，ref4 消失");
    }
    private void testHashMap(){
        System.out.println("HashMap GC之前");
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
        try {
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
        }
        System.out.println("HashMap GC之后");
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
    }
    private void testWeakHashMap(){
        System.out.println("WeakHashMap GC之前");
        for (Object o : wMap.entrySet()) {
            System.out.println(o);
        }
        try {
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WeakHashMap GC之后");
        for (Object o : wMap.entrySet()) {
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        Sixth sixth=new Sixth();
        sixth.init();
        sixth.testWeakHashMap();
        sixth.testHashMap();
    }
}

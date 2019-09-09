package com.xwj.chapter2;

import java.util.concurrent.TimeUnit;

/**
 * 避免使用终结方法
 */
public class Seventh {
    public static void main(String[] args) throws InterruptedException {
       Sun sun=new Sun();
        sun=null;
        System.gc();
//       Father father = new Father();
//        father = null;
//        System.gc();
        TimeUnit.SECONDS.sleep(1);
    }
}
class Father{
    //终结方法守护者,匿名内部类(object的子类)
    private final Object finalizerGuardian=new Object(){
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Father finalize by the finalizerGuardian1");
        }
    };
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Father finalize by the finalize method2");
    }
}
class Sun extends Father{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Sun finalize by the finalize method");
//        super.finalize();
    }
}

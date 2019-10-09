package com.xwj.chapter3;

import java.util.Date;

/**
 * 谨慎地覆盖clone
 * 1.注意浅克隆和深克隆
 * 2.拷贝构造器
 * 3.拷贝静态工厂
 */
class Student implements Cloneable{//必须实现cloneable接口
    String name;
    Integer age;
    Date date;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student clone = (Student) super.clone();
        //深克隆
        clone.date= (Date) date.clone();
        return clone;
    }
    @Override
    public String toString() {
        return name+";"+age+";"+date;
    }
}
//拷贝构造器
class CloneConstructor{
    String filed1;
    Date date;
    CloneConstructor(){}
    CloneConstructor(CloneConstructor cloneConstructor){
        filed1=cloneConstructor.filed1;
        date= (Date) cloneConstructor.date.clone();
    }
    @Override
    public String toString() {
        return filed1+";"+date;
    }
}
//拷贝静态工厂
class CloneFactory{
    String filed1;
    Date date;
    CloneFactory(){}
    static CloneFactory newInstance(CloneFactory cloneFactory){
        CloneFactory factory = new CloneFactory();
        factory.filed1=cloneFactory.filed1;
        factory.date= (Date) cloneFactory.date.clone();
        return factory;
    }
    @Override
    public String toString() {
        return filed1+";"+date;
    }
}
public class Eleventh implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {
        //测试深克隆
//        Date date = new Date();
//        date.setTime(1000);
//        Student student1 = new Student();
//        student1.name="stu";
//        student1.age=1;
//        student1.date=date;
//        Student student2 = (Student) student1.clone();
//        System.out.println("克隆："+student2.toString());
//        student1.name="stu1";
//        student1.date.setTime(2000);
//        System.out.println("修改："+student2.toString());
        //测试拷贝构造器
//        CloneConstructor constructor1 = new CloneConstructor();
//        Date date = new Date();
//        date.setTime(1000);
//        constructor1.filed1="1";
//        constructor1.date=date;
//        CloneConstructor constructor2 = new CloneConstructor(constructor1);
//        System.out.println("克隆："+constructor2);
//        constructor1.filed1="2";
//        constructor1.date.setTime(2000);
//        System.out.println("修改："+constructor2);
        //测试拷贝静态工厂
        CloneFactory cloneFactory = new CloneFactory();
        Date date = new Date();
        date.setTime(1000);
        cloneFactory.filed1="1";
        cloneFactory.date=date;
        CloneFactory cloneFactory2 = CloneFactory.newInstance(cloneFactory);
        System.out.println("克隆："+cloneFactory2);
        cloneFactory.filed1="2";
        cloneFactory.date.setTime(2000);
        System.out.println("修改："+cloneFactory2);
    }
}

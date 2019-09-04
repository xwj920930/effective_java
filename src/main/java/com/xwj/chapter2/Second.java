package com.xwj.chapter2;

/**
 * 遇到多个构造参数时考虑用构建器
 */
class Person{
    private final String name;//必要项
    private final int age;//必要项
    private final String address;//可选项
    private final String phone;//可选项
    private Person(Builder builder){
        this.name=builder.name;
        this.age=builder.age;
        this.address=builder.address;
        this.phone=builder.phone;
    }
    @Override
    public String toString() {
        return "name:"+name+" age:"+age+" address:"+address+" phone:"+phone;
    }
    public static class Builder{
        private final String name;
        private final int age;
        private String address=null;
        private String phone=null;
        Builder(String name,int age){
            this.name=name;
            this.age=age;
        }
        Builder address(String address){
            this.address=address;
            return this;
        }
        Builder phone(String phone){
            this.phone=phone;
            return this;
        }
        Person builder(){
            return new Person(this);
        }
    }
}
public class Second {
    public static void main(String[] args) {
        Person person=new Person.Builder("xwj",26).phone("13550007429").builder();
        System.out.println(person);
    }
}

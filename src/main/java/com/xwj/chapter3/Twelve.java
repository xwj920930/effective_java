package com.xwj.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 考虑实现comparable接口
 * 1.主要用于排序
 * 2.Collections.sort(Ts)，T必须实现Comparable接口,重写compareTo方法
 */
class Person implements Comparable<Person>{
    private int age;
    private String name;
    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return age+";"+name;
    }
    @Override
    public int compareTo(Person o) {
        if (this.age > o.age){
            return 1;
        }
        else if (this.age < o.age){
            return -1;
        }
        else {
            return this.name.compareTo(o.name);
        }
    }
}
public class Twelve {
    public static void main(String[] args) {
        Person person1 = new Person(2, "a");
        Person person2 = new Person(4, "a");
        Person person3 = new Person(3, "a");
        Person person4 = new Person(1, "b");
        Person person5 = new Person(1, "a");
        List<Person> personList = new ArrayList<>(Arrays.asList(person1, person2, person3, person4, person5));
        System.out.println(personList);
        Collections.sort(personList);
        System.out.println(personList);
    }
}

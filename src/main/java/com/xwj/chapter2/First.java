package com.xwj.chapter2;

/**
 * 考虑用静态工厂方法代替构造器
 */
//使用构造函数的重载，不直观，不看注释不知所云
class RandomIntGenerator{
    private int min=Integer.MIN_VALUE;//最小值
    private int max=Integer.MAX_VALUE;//最大值
    //大于min，小于max
    RandomIntGenerator(int min,int max){
        this.min=min;
        this.max=max;
    }
    //大于min，小于integer.max
    RandomIntGenerator(int min){
        this.min=min;
    }
    //大于integer.min，小于max
}
//使用静态工厂方法代替构造器
class NewRandomIntGenerator{
    private int min=Integer.MIN_VALUE;//最小值
    private int max=Integer.MAX_VALUE;//最大值
    //大于min，小于max
    private NewRandomIntGenerator(int min,int max){
        this.min=min;
        this.max=max;
    }
    //大于min，小于max
    public static NewRandomIntGenerator between(int min,int max){
        return new NewRandomIntGenerator(min,max);
    }
    //大于min，小于integer.max
    public static NewRandomIntGenerator biggerThan(int min){
        return new NewRandomIntGenerator(min,Integer.MAX_VALUE);
    }
    //大于integer.min，小于max
    public static NewRandomIntGenerator smallThan(int max){
        return new NewRandomIntGenerator(Integer.MIN_VALUE,max);
    }
}
public class First {
    public static void main(String[] args) {
        RandomIntGenerator RandomIntGenerator=new RandomIntGenerator(1,20);
        NewRandomIntGenerator between = NewRandomIntGenerator.between(1, 20);
    }
}

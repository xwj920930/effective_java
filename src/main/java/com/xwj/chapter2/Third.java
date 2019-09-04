package com.xwj.chapter2;

class SingletonHungary{
    private static final SingletonHungary singletonHungary=new SingletonHungary();
    private SingletonHungary(){}
    public static SingletonHungary getInstance(){
        return singletonHungary;
    }
}
class SingletonLazy{
    private static SingletonLazy singletonLazy;
    private SingletonLazy(){}
    public static SingletonLazy getInstance(){//高并发下错误
        if (singletonLazy==null){
            singletonLazy=new SingletonLazy();
        }
        return singletonLazy;
    }
}
class SingletonDCL{//双校验
    private static volatile SingletonDCL singletonDCL;
    private SingletonDCL(){}
    public static SingletonDCL getInstance(){
        if (singletonDCL==null){
            synchronized (SingletonDCL.class){
                if (singletonDCL==null){
                    singletonDCL=new SingletonDCL();
                }
            }
        }
        return singletonDCL;
    }
}
class SingletonByEnum{//需要实现的单例类
    private enum SingletonEnum{//使用枚举
        SINGLETON_INSTANCE;//实例
        private SingletonByEnum singletonByEnum;//需要实现的单例类
        SingletonEnum(){
            singletonByEnum=new SingletonByEnum();
        }
        public SingletonByEnum getInstance(){
            return singletonByEnum;
        }
    }
    public static SingletonByEnum getInstance(){
        return SingletonEnum.SINGLETON_INSTANCE.getInstance();//用枚举实例获取
    }
}
public class Third {
    public static void main(String[] args) {
        SingletonByEnum instance1 = SingletonByEnum.getInstance();
        SingletonByEnum instance2 = SingletonByEnum.getInstance();
        System.out.println(instance1==instance2);
    }
}

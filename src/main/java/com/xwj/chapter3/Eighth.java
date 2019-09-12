package com.xwj.chapter3;

import java.util.Objects;

/**
 * 覆盖equals须遵循通用约定
 */
final class CaseInsensitiveString{
    private final String s;
    CaseInsensitiveString(String s){
        this.s=s;
    }
//    @Override//违反对称性的写法，虽然此处可以判断obj为string的情况，但是string的
//    //equals无法判断CaseInsensitiveString的情况，所以返回false
//    public boolean equals(Object obj) {
//        if (obj instanceof CaseInsensitiveString){
//            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
//        }
//        if (obj instanceof String){//多余
//            return s.equalsIgnoreCase((String) obj);
//        }
//        return false;
//    }

    @Override//不违反对称性的正确写法，不考虑CaseInsensitiveString以外的情况
    public boolean equals(Object obj) {
        return obj instanceof CaseInsensitiveString &&
                s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
    }
}
class Point{
    private final int x;
    private final int y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point))
            return false;
        Point p= (Point) obj;
        return p.x==x && p.y==y;
    }
}
class ColorPoint extends Point{//无法在扩展时既增加组件又保留equals约定
    private final String color;
    ColorPoint(int x, int y,String color) {
        super(x, y);
        this.color=color;
    }
//    @Override//对称性都不满足
//    public boolean equals(Object obj) {
//        if (!(obj instanceof ColorPoint))//Point不是ColorPoint
//            return false;
//        ColorPoint p= (ColorPoint) obj;
//        return super.equals(obj) && p.color.equals(color);
//    }
    @Override//传递性不满足
    public boolean equals(Object obj) {
        if (!(obj instanceof Point))//不是Point返回
            return false;
        if (!(obj instanceof ColorPoint))//是Point不是ColorPoint进入
            return obj.equals(this);
        ColorPoint p= (ColorPoint) obj;
        return super.equals(obj) && p.color.equals(color);//是ColorPoint
    }
}
//用复合代替继承
class ColorPoint2{
    private final Point point;
    private final String color;
    ColorPoint2(int x,int y,String color){
        this.point=new Point(x, y);
        this.color=color;
    }
    Point asPoint(){
        return point;
    }
    @Override
    public boolean equals(Object obj) {
        //因为ColorPoint2不再继承自Point，所以无法匹配Point与ColorPoint2
        if (!(obj instanceof ColorPoint2))
            return false;
        ColorPoint2 c= (ColorPoint2) obj;
        return c.point.equals(point) && c.color.equals(color);
    }
}
public class Eighth {
    public static void main(String[] args) {
        //对称性验证
//        CaseInsensitiveString cis=new CaseInsensitiveString("Polish");
//        String s="polish";
//        System.out.println(cis.equals(s));
//        System.out.println(s.equals(cis));
        //传递性验证1，ColorPoint对称性都不满足的情况
//        Point p=new Point(1,2);
//        ColorPoint c=new ColorPoint(1,2,"red");
//        System.out.println(p.equals(c));
//        System.out.println(c.equals(p));
        //传递性验证2，ColorPoint传递性不满足的情况
//        ColorPoint c1=new ColorPoint(1,2,"red");
//        Point p=new Point(1,2);
//        ColorPoint c2=new ColorPoint(1,2,"blue");
//        System.out.println(c1.equals(p));//Point与ColorPoint比较忽略了颜色信息
//        System.out.println(p.equals(c2));
//        System.out.println(c1.equals(c2));//ColorPoint相互比较不会忽略颜色信息
    }
}
class EqualsDemo{
    private int id;
    private String name;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//判断是否相同对象
        if (!(o instanceof EqualsDemo)) return false;//判断是否正确类型，也可考虑getClass
        EqualsDemo that = (EqualsDemo) o;//类型转换
        return id == that.id &&//具体比较逻辑
                Objects.equals(name, that.name);
    }
}

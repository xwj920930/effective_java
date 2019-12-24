package com.xwj.chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 覆盖equals总是覆盖hashcode
 * 复写equals之所以还要复写hashcode是因为被复写的类可能会被map或者set当做key，此时需要hashcode作为评判标准
 */
class PhoneNumber{
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;
    PhoneNumber(int areaCode,int prefix,int lineNumber){
        this.areaCode= (short) areaCode;
        this.prefix= (short) prefix;
        this.lineNumber= (short) lineNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode &&
                prefix == that.prefix &&
                lineNumber == that.lineNumber;
    }
    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNumber);
    }
}
public class Ninth {
    public static void main(String[] args) {
        //测试有/无hashcode情况下map
        PhoneNumber number1 = new PhoneNumber(1, 1, 1);
        PhoneNumber number2 = new PhoneNumber(1, 1, 1);
        Map map=new HashMap();
        map.put(number1,"xwj");
        System.out.println(map.get(number2));
    }
}

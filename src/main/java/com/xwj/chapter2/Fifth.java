package com.xwj.chapter2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/***
 * 避免创建不必要的对象
 *
 * map的keySet方法只返回一个set公共实例，当从key1中删除一个数，
 * 其他也会受影响（set删除，map也会相应删除，反之亦然，但是set无法add）
 */
public class Fifth {
    public static void main(String[] args) {
        //测试keySet
        Map<String,Object> map=new HashMap<>();
        map.put("A","A");
        map.put("B","B");
        map.put("C","C");
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()+"@");
        }
        System.out.println("--------------");
        map.put("D","D");
        while (iterator.hasNext()){//此时iterator还指向最后一项，未重置，所以无法输出
            System.out.println(iterator.next()+"#");
        }
        System.out.println("--------------");
        keySet = map.keySet();
        iterator = keySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()+"#");
        }
    }
}

package com.snowwave.concurrency.reflectionDemo;

import sun.management.MethodInfo;

import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by zhangfuqiang on 2019/5/19.
 */
public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        //获取类
        Class clazz = Class.forName("com.snowwave.concurrency.reflectionDemo.Robot");

        System.out.println("类名是 " + clazz.getName());

        Robot robot = (Robot) clazz.newInstance();

        //获取私有方法 sayHello 参数是String类型
        Method priavteMethod = clazz.getDeclaredMethod("sayHello",String.class);
        priavteMethod.setAccessible(true);
        //调用私有方法
        Object str = priavteMethod.invoke(robot,"Bob");
        System.out.println("私有方法返回值是" + str);
        //获取公共方法
        Method publicMethod = clazz.getMethod("sayHi",String.class);
        publicMethod.invoke(robot,"welcome");
        //获取私有属性
        Field privateFiled = clazz.getDeclaredField("name");
        privateFiled.setAccessible(true);
        privateFiled.set(robot,"Alice");

        publicMethod.invoke(robot,"welcome");


        String str1 = new String("aaa");//强引用
        SoftReference<String> softRef = new SoftReference<String>(str1);//软引用
        PriorityQueue<Integer> properties = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = set.stream().map(Integer::new).collect(toList());
        Object[] set1 =  set.toArray();
        int c = (Integer) set1[1];
        String s = "aa";
        LinkedList<Integer> list11 = new LinkedList<Integer>();
//        list11.contains()
    }

}

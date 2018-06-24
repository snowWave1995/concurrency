package com.snowwave.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhangfuqiang on 2018/6/24.
 * 用来标记线程安全的类
 */
@Target(ElementType.TYPE) //该注解可以加在什么地方，如类，方法等等
@Retention(RetentionPolicy.SOURCE)//该注解的保存策略
public @interface ThreadSafe {

    String value() default "";
}

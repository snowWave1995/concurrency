package com.snowwave.concurrency.aopdemo;

import java.lang.annotation.*;

/**
 * Created by zhangfuqiang on 2018/10/19.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Mu {
}

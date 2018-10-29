package com.snowwave.concurrency;

import com.snowwave.concurrency.aopdemo.Mu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangfuqiang on 2018/6/24.
 */
@RestController
@Slf4j
public class TestController {

    @Mu
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("3");
        return "test";
    }
}

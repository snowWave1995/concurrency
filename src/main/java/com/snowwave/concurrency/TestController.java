package com.snowwave.concurrency;

import com.snowwave.concurrency.aopdemo.Mu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("Alen", "Hebe", "Zebe", "张成瑶", "钟其林");
//        // 通过判断人名称的首字母是否为英文字母，将其分为两个不同流
//        //在JDK8中，可以对流进行方便的自定义分块，通常是根据某种过滤条件将流一分为二
//        final Map<Boolean, List<String>> map = stream.collect(Collectors.partitioningBy(s -> {
//            // 如果是英文字母，则将其划分到英文人名，否则划分到中文人名
//            int code = s.codePointAt(0);
//            return (code >= 65 && code <= 90) || (code >= 97 && code <= 122);
//        }));
//        map.forEach((isEnglishName, names) -> {
//            if (isEnglishName) {
//                System.out.println("英文名称如下：");
//            } else {
//                System.out.println("中文名称如下：");
//            }
//            names.forEach(name -> System.out.println("\t" + name));
//        });
//
//        // 创建一个包含人名称的流
//        Stream<String> stringStream = Stream.of("Alen", "Hebe", "Zebe", "Helen", "Alex");
//        // 通过人名称的首字母进行分组
//        final Map<Character, List<String>> collect = stringStream.collect(Collectors.groupingBy(s -> s.charAt(0)));
//        // 输出分组结果
//        collect.forEach((letter, groups) -> {
//            System.out.println("以字母 " + letter + " 开头的名字如下：");
//            groups.forEach(name -> System.out.println("\t" + name));
//        });
//
//        // 创建一个Map
//        Map<String, Object> infoMap = new HashMap<>();
//        infoMap.put("name", "Zebe");
//        infoMap.put("site", "www.zebe.me");
//        // 传统的Map迭代方式
//        for (Map.Entry<String, Object> entry : infoMap.entrySet()) {
//            System.out.println(entry.getKey() + "：" + entry.getValue());
//        }
//        // JDK8的迭代方式
//        infoMap.forEach((key, value) -> {
//            System.out.println(key + "：" + value);
//        });


        // 创建一个比较器，取名为 byHeight （通过高度来比较）
//        Comparator<Person> byHeight = Comparator.comparingInt(Person::getHeight);
//        // 创建一个归一收集器
//        Map<City, Optional<Person>> tallestByCity = personList.stream().
//                collect(groupingBy(Person::getCity, reducing(BinaryOperator.maxBy(Comparator.comparingInt(Person::getHeight)))));
//        tallestByCity.forEach((city, person) -> {
//            person.ifPresent(p -> System.out.println(city.getName() + " -> " + p.getHeight()));
//        });
//
//        IntSummaryStatistics statistics = Stream.of(1L, 2L, 3L, 4L).mapToInt(Long::intValue).summaryStatistics();
//        System.out.println("最大值：" + statistics.getMax());
//        System.out.println("最小值：" + statistics.getMin());
//        System.out.println("平均值：" + statistics.getAverage());
//        System.out.println("求和：" + statistics.getSum());
//        System.out.println("计数：" + statistics.getCount());
//
//        LongSummaryStatistics statistics1 = Stream.of(1L, 2L, 3L, 4000000000000000000L).mapToLong(Long::longValue).summaryStatistics();
//        System.out.println("最大值：" + statistics1.getMax());
//        System.out.println("最小值：" + statistics1.getMin());
//        System.out.println("平均值：" + statistics1.getAverage());
//        System.out.println("求和：" + statistics1.getSum());
//        System.out.println("计数：" + statistics1.getCount());
//
//        DoubleSummaryStatistics statistics2 = Stream.of(1, 2, 3.0, 5.2).mapToDouble(Number::doubleValue).summaryStatistics();
//        System.out.println("最大值：" + statistics2.getMax());
//        System.out.println("最小值：" + statistics2.getMin());
//        System.out.println("平均值：" + statistics2.getAverage());
//        System.out.println("求和：" + statistics2.getSum());
//        System.out.println("计数：" + statistics2.getCount());

        //断言接口
        Predicate<Integer> predicate = i -> i > 0;
        System.out.println(predicate.test(19));

        //消费函数
        Consumer<String> consumer = System.out::println;
        consumer.accept("哈哈");
    }
}

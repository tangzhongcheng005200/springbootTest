package com.demo;

import com.domain.TabUser;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //1.求和
        Integer reduce = numbers.stream().reduce(0, Integer::sum);
        System.out.println("求和:"+reduce);

        //2.统计
        IntSummaryStatistics stats = numbers.stream().mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("总和:"+stats.getSum());
        System.out.println("平均值:"+stats.getAverage());

        //3.分组
        List<TabUser> users = Arrays.asList(
                new TabUser(1, "Alice", "20"),
                new TabUser(2, "Bob", "25"),
                new TabUser(3, "Charlie", "20")
        );
        Map<String, List<TabUser>> collect = users.stream().collect(Collectors.groupingBy(TabUser::getAddress));
        System.out.println("分组："+collect);

        List<String> words = Arrays.asList("hello", "world", "java", "stream");
        List<String> result = words.stream()
                .filter(s -> s.length() >= 5)
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("过滤输出："+result);
    }
}

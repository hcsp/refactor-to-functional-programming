package com.github.hcsp.functional;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RefactorToConsumer {
    public static void main(String[] args) {
        Map<String, String> map1 =
                Stream.of("a", "b", "c").collect(Collectors.toMap(k -> k, v -> v));
        Map<String, String> map2 =
                Stream.of("d", "e", "f").collect(Collectors.toMap(k -> k, v -> v));

        printWithConsumer(map1, map2, (x, y) -> System.out.println(x + ',' + y));
        printWithConsumer(map1, map2, (x, y) -> System.out.println(x + '-' + y));
        printWithConsumer(map1, map2, (x, y) -> System.out.println(x + ':' + y));
    }

    // 请尝试使用BiConsumer函数式接口重构下列三个方法，消除重复代码，提高可读性
    // 提示：你可以使用Map.forEach方法
    // 加分项：如果你能编写一个返回BiConsumer的高阶函数（即"返回函数的函数"），那就更好了
    public static void printWithConsumer(
            Map<String, String> map1,
            Map<String, String> map2,
            BiConsumer<String, String> consumer) {
        looperMap(map1, consumer);
        looperMap(map2, consumer);
    }

    private static void looperMap(Map<String, String> map1, BiConsumer<String, String> consumer) {
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            consumer.accept(key, value);
        }
    }
}

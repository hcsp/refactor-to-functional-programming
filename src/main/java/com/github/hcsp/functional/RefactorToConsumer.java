package com.github.hcsp.functional;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RefactorToConsumer {
    static final String WITH_COMMA = "WITH_COMMA";
    static final String WITH_DASH = "WITH_DASH";
    static final String WITH_COLON = "WITH_COLON";

    public static void main(String[] args) {
        Map<String, String> map1 =
                Stream.of("a", "b", "c").collect(Collectors.toMap(k -> k, v -> v));
        Map<String, String> map2 =
                Stream.of("d", "e", "f").collect(Collectors.toMap(k -> k, v -> v));

        printWithComma(map1, map2);
        printWithDash(map1, map2);
        printWithColon(map1, map2);
    }

    // 请尝试使用BiConsumer函数式接口重构下列三个方法，消除重复代码，提高可读性
    // 提示：你可以使用Map.forEach方法
    // 加分项：如果你能编写一个返回BiConsumer的高阶函数（即"返回函数的函数"），那就更好了
    public static void printWithConsumer(
            Map<String, String> map1,
            Map<String, String> map2,
            BiConsumer<String, String> consumer) {
        map1.forEach(consumer);
        map2.forEach(consumer);
    }

    public static BiConsumer<String, String> getBiConsumer(String type) {
        String separator = null;
        if (type.equals(WITH_COMMA)) {
            separator = ",";
        }
        if (type.equals(WITH_DASH)) {
            separator = "-";
        }
        if (type.equals(WITH_COLON)) {
            separator = ":";
        }

        if (separator == null) {
            throw new RuntimeException("type must been one of [WITH_COMMA, WITH_DASH, WITH_COLON]!");
        }

        String finalSeparator = separator;
        return (s, s2) -> System.out.println(s + finalSeparator + s2);
    }

    public static void printWithComma(Map<String, String> map1, Map<String, String> map2) {
        printWithConsumer(map1, map2, getBiConsumer(WITH_COMMA));
    }

    public static void printWithDash(Map<String, String> map1, Map<String, String> map2) {
        printWithConsumer(map1, map2, getBiConsumer(WITH_DASH));
    }

    public static void printWithColon(Map<String, String> map1, Map<String, String> map2) {
        printWithConsumer(map1, map2, getBiConsumer(WITH_COLON));
    }
}

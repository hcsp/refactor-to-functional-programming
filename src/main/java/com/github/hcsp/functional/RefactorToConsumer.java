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
        String[] separators = {",", "-", ":"};
        for (String separator : separators) {
            printWithConsumer(map1, map2, generateBiConsumer(separator));
        }
    }

    public static void printWithConsumer(
            Map<String, String> map1,
            Map<String, String> map2,
            BiConsumer<String, String> consumer) {
        map1.forEach(consumer);
        map2.forEach(consumer);
    }

    public static BiConsumer<String, String> generateBiConsumer(String separator) {
        return (key, value) -> System.out.println(key + separator + value);
    }
}

package com.github.hcsp.functional;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RefactorToSupplier {
    private static int randomInt() {
        return new Random().nextInt();
    }

    public static void main(String[] args) {
        System.out.println(createObjects());
        System.out.println(createStrings());
        System.out.println(createRandomIntegers());
    }

    // 请尝试使用函数式接口Supplier对三个方法进行重构，消除冗余代码
    // 并尽量尝试使用lambda表达式和方法引用来传递参数
    public static List<Object> create(Supplier<Object> supplier) {
        return IntStream.range(0, 10).mapToObj(i -> supplier.get()).collect(Collectors.toList());
    }

    public static List<Object> createObjects() {
        return create(Object::new);
    }

    public static List<Object> createStrings() {
        return create(String::new);
    }

    public static List<Object> createRandomIntegers() {
        return create(RefactorToSupplier::randomInt);
    }
}

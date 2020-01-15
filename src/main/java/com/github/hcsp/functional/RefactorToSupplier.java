package com.github.hcsp.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RefactorToSupplier {
    private static int init = 0;

    private static int randomInt() {
        return new Random().nextInt();
    }

    public static void main(String[] args) {
        System.out.println(create(Object::new));
        System.out.println(create(() -> "" + (init++)));
        System.out.println(create(RefactorToSupplier::randomInt));
    }

    // 请尝试使用函数式接口Supplier对三个方法进行重构，消除冗余代码
    // 并尽量尝试使用lambda表达式和方法引用来传递参数
    public static List<Object> create(Supplier<Object> supplier) {
        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(supplier.get());
        }
        return objects;
    }
}

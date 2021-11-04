package com.github.hcsp.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

public class RefactorToSupplier {
    private static int randomInt() {
        return new Random().nextInt();
    }

    public static void main(String[] args) {
        System.out.println(create(getSupplier(CreateType.OBJECT)));
        System.out.println(create(getSupplier(CreateType.STRING)));
        System.out.println(create(getSupplier(CreateType.RANDOM_INTEGER)));
    }

    // 请尝试使用函数式接口Supplier对三个方法进行重构，消除冗余代码
    // 并尽量尝试使用lambda表达式和方法引用来传递参数
    public static List<Object> create(Supplier<Object> supplier) {
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(supplier.get());
        }
        return result;
    }

    public static <T> Supplier getSupplier(CreateType type) {
        if (type == CreateType.OBJECT) {
            return Object::new;
        } else if (type == CreateType.STRING) {
            return String::new;
        } else if (type == CreateType.RANDOM_INTEGER) {
            return RefactorToSupplier::randomInt;
        }
        return null;
    }


    public enum CreateType {
        OBJECT, STRING, RANDOM_INTEGER
    }
}

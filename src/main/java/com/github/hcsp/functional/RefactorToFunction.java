package com.github.hcsp.functional;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class RefactorToFunction {
    public static void main(String[] args) {
        int[] a = {4, 5, 6};
        int[] b = {1, 2, 3};

        System.out.println(Arrays.toString(calculate(a, b, Integer::sum)));
        System.out.println(Arrays.toString(calculate(a, b, (x1, x2) -> x1 - x2)));
        System.out.println(Arrays.toString(calculate(a, b, (x1, x2) -> x1 * x2)));
        System.out.println(Arrays.toString(calculate(a, b, (x1, x2) -> x1 / x2)));
    }

    // 请尝试将下列四个方法使用IntBinaryOperator进行重构，减少重复代码
    public static int[] calculate(int[] a, int[] b, IntBinaryOperator operator) {
        int[] results = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            results[i] = operator.applyAsInt(a[i], b[i]);
        }
        return results;
    }

    // 将两个数组中的每个数字分别相加，然后返回相加后的数组。你可以假定传入的数组都是等长的
    // 下列minus/multiply/divide方法同理
    // 例如，a=[1, 2, 3], b=[4, 5, 6]
    // 返回 [5 (1+4), 7 (2+5), 9 (3+6)]

}

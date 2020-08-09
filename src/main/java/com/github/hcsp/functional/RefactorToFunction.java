package com.github.hcsp.functional;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class RefactorToFunction {
    public static void main(String[] args) {
        int[] a = {4, 5, 6};
        int[] b = {1, 2, 3};

        System.out.println(Arrays.toString(add(a, b)));
        System.out.println(Arrays.toString(minus(a, b)));
        System.out.println(Arrays.toString(multiply(a, b)));
        System.out.println(Arrays.toString(divide(a, b)));
    }

    public static int[] calculate(int[] a, int[] b, IntBinaryOperator operator) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            result[i] = operator.applyAsInt(a[i], b[i]);
        }
        return result;
    }

    public static int[] add(int[] a, int[] b) {
        return calculate(a, b, Integer::sum);
    }

    public static int[] minus(int[] a, int[] b) {
        return calculate(a, b, (x, y) -> x-y);
    }

    public static int[] multiply(int[] a, int[] b) {
        return calculate(a, b, (x, y) -> x*y);
    }

    public static int[] divide(int[] a, int[] b) {
        return calculate(a, b, (x, y) -> x/y);
    }
}

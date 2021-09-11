package com.github.hcsp.functional;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class RefactorToFunction {
    public static void main(String[] args) {
        int[] a = {4, 5, 6};
        int[] b = {1, 2, 3};

        System.out.println(Arrays.toString(calculate(a, b, getOperator(Character.ADD))));
        System.out.println(Arrays.toString(calculate(a, b, getOperator(Character.MINUS))));
        System.out.println(Arrays.toString(calculate(a, b, getOperator(Character.MULTIPLY))));
        System.out.println(Arrays.toString(calculate(a, b, getOperator(Character.DIVIDE))));
    }

    // 请尝试将下列四个方法使用IntBinaryOperator进行重构，减少重复代码
    public static int[] calculate(int[] a, int[] b, IntBinaryOperator operator) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            result[i] = operator.applyAsInt(a[i], b[i]);
        }
        return result;
    }

    public static IntBinaryOperator getOperator(Character character) {
        if (character == Character.ADD) {
            return (o, o2) -> o + o2;
        }
        if (character == Character.MINUS) {
            return (o, o2) -> o - o2;
        }
        if (character == Character.MULTIPLY) {
            return (o, o2) -> o * o2;
        }
        if (character == Character.DIVIDE) {
            return (o, o2) -> o / o2;
        }
        return null;
    }

    public enum Character {
        ADD, MINUS, MULTIPLY, DIVIDE
    }
}

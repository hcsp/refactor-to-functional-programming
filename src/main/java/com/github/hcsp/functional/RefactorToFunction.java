package com.github.hcsp.functional;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class RefactorToFunction {
    public static void main(String[] args) {
        int[] a = {4, 5, 6};
        int[] b = {1, 2, 3};

        System.out.println(Arrays.toString(calculate(a, b, getOperate(OperateType.ADD))));
        System.out.println(Arrays.toString(calculate(a, b, getOperate(OperateType.MINUS))));
        System.out.println(Arrays.toString(calculate(a, b, getOperate(OperateType.MULTIPLY))));
        System.out.println(Arrays.toString(calculate(a, b, getOperate(OperateType.DIVIDE))));
    }

    // 请尝试将下列四个方法使用IntBinaryOperator进行重构，减少重复代码
    public static int[] calculate(int[] a, int[] b, IntBinaryOperator operator) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            result[i] = operator.applyAsInt(a[i], b[i]);
        }
        return result;
    }

    public static IntBinaryOperator getOperate(OperateType type) {
        if (type == OperateType.ADD) {
            return (a1, a2) -> a1 + a2;
        } else if (type == OperateType.MINUS) {
            return (a1, a2) -> a1 - a2;
        } else if (type == OperateType.MULTIPLY) {
            return (a1, a2) -> a1 * a2;
        } else if (type == OperateType.DIVIDE) {
            return (a1, a2) -> a1 / a2;
        }
        return null;
    }


    public enum OperateType {
        ADD, MINUS, MULTIPLY, DIVIDE
    }
}

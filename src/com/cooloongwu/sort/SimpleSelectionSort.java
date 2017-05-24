package com.cooloongwu.sort;

/**
 * 简单选择排序
 * Created by Dragon on 2017-5-24.
 */
public class SimpleSelectionSort {

    public static void sort(int[] args) {

        System.out.print("原始数据：");
        for (int x = 0; x < args.length; x++) {
            System.out.print(args[x] + "、");
        }
        System.out.println("");

        for (int i = 0; i < args.length; i++) {
            int index = i;

            for (int j = i + 1; j < args.length; j++) {
                if (args[j] < args[index]) {
                    index = j;
                }
            }

            if (index != i) {
                int temp = args[i];
                args[i] = args[index];
                args[index] = temp;
            }
            System.out.print("第" + (i + 1) + "次排序结果：");
            for (int x = 0; x < args.length; x++) {
                System.out.print(args[x] + "、");
            }
            System.out.println("");
        }
    }
}

package com.cooloongwu.sort;

/**
 * 冒泡排序
 * Created by Dragon on 2017-5-19.
 */
public class BubbleSort {

    public static void paint(int[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print((9 - i) + " ");

            if (i == 9) {
                for (int j = 1; j < 10; j++) {
                    System.out.print(j + " ");
                }
                break;
            }

            for (int k = 0; k < args.length - 1; k++) {
                if (args[k] == i) {
                    System.out.print(args[k] + " ");
                    break;
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static int[] sort(int[] args) {

        print("原始数据：", args);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < args.length - 1; i++) {
            for (int j = 0; j < args.length - 1 - i; j++) {
                if (args[j] < args[j + 1]) {
                    int temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }
            }
            print("第" + (i + 1) + "次排序后的结果：", args);
            paint(args);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("排序耗时（毫秒）：" + (endTime - startTime));

        return args;
    }

    private static void print(String msg, int[] args) {
        System.out.print(msg);
        for (int x : args) {
            System.out.print(x + "，");
        }
        System.out.println("");
    }
}

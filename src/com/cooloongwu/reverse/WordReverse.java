package com.cooloongwu.reverse;

/**
 * 2017 年 4 月美团 Android 面试题：单词翻转
 * Created by CooLoongWu on 2017-5-18.
 */
public class WordReverse {

    /**
     * 思路就是：按照空格来分隔字符串，然后将分割后的字符串倒序拼接起来
     *
     * @param word 要翻转的字符串
     * @return 翻转后的字符串
     */
    public static String reverse(String word) {
        String[] arr = word.split(" ");
        StringBuilder sb = new StringBuilder();
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        String result = sb.toString();
        System.out.println("源字符串：" + word + "；反转后为：" + result);
        return result;
    }
}

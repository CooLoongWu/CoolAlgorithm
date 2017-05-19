package com.cooloongwu;


import com.cooloongwu.prime.Prime;
import com.cooloongwu.prime.Prime233;
import com.cooloongwu.reverse.WordReverse;
import com.cooloongwu.sort.BubbleSort;

/**
 * 入口程序
 * Created by Dragon on 2017-5-11.
 */
public class Main {

    public static void main(String[] args) {
//        new Prime(1, 100000);
//        new Prime233();
//        WordReverse.reverse("This is just a test");
        BubbleSort.sort(new int[]{2, 3, 4, 6, 1, 2});
    }
}

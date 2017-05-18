package com.cooloongwu.prime;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 2017 年 4 月美团 Android 面试题：求猫扑素数；1到n，求1的个数；
 * <p>
 * 形如以 2 开头, 之后跟任意多个 3 的十进制整数如果是个素数, 则它是猫扑素数.
 * 如 2, 23, 233, 2333, 23333 都是猫扑素数, 而 233333 则不是, 它可以分解为 353 x 661.
 * <p>
 * Created by CooLoongWu on 2017-5-15.
 */
public class Prime233 {

    public Prime233() {

        long num = 2;
        isPrime(num);

        //产生猫扑素数，位数超过19位就无法计算了，超过了long能存储的最大值
        for (int i = 0; i < 19; i++) {
            num = num * 10 + 3;
            isPrime(num);
        }
    }

    private void isPrime(long num) {
        long startTime = System.currentTimeMillis();
        long temp = (long) Math.sqrt(num);
        for (long j = 3; j <= temp; j = j + 2) {
            if (num % j == 0) {
                long endTime = System.currentTimeMillis();
                printNotPrime(num, j, endTime - startTime);
                return;
            }
        }
        long endTime = System.currentTimeMillis();
        printIsPrime(num, endTime - startTime);
    }

    private void printIsPrime(long primeNum, long time) {
        System.out.println(primeNum + "是素数，耗时(毫秒)：" + time);
    }

    private void printNotPrime(long primeNum, long i, long time) {
        System.out.println(primeNum + "不是素数，因子为：" + i + "，耗时(毫秒)：" + time);
    }

}

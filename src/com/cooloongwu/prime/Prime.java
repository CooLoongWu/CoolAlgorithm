package com.cooloongwu.prime;

/**
 * 求某区域内素数个数的算法（也可以打印素数）
 * Created by CooLoongWu on 2017-5-11.
 */
public class Prime {
    private long startNum;
    private long endNum;
    private boolean isContain2 = false;

    public Prime(long startNum, long endNum) {
        this.startNum = startNum;
        this.endNum = endNum;

        doIt();
    }

    private void doIt() {
        if (!checkInput()) {
            System.out.println("输入有误，请检查后在执行");
            return;
        }
        doIt1();
        doIt2();
        doIt3();
        doIt4();
        doIt5();

        doIt6();
    }

    private void printPrime(long prime) {
        //System.out.print(prime + "、");
    }

    private void printResult(long primeNum, long time) {
        System.out.println("找到素数" + (primeNum + (isContain2 ? 1 : 0)) + "个，耗时(毫秒)：" + time);
    }

    /**
     * ！！！！！注意1、2是特殊情况，所以单独提出来，从3开始考虑！！！！！
     *
     * @return 输入是否合法
     */
    private boolean checkInput() {
        if (endNum < startNum) {
            return false;
        }

        if (startNum <= 3) {
            startNum = 3;
            isContain2 = true;
            //print(2);
        }
        return true;
    }

    //1、试除法：就从 2 一直尝试到 N-1，若均无法整除，N则为素数。
    private void doIt1() {
        long startTime = System.currentTimeMillis();
        long primeNum = 0;
        boolean isPrime = true;    //默认该数是素数（对2的判断有效）
        for (long i = startNum; i <= endNum; i++) {
            for (long j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
                isPrime = true;
            }
            if (isPrime) {
                primeNum++;
                printPrime(i);      //打印素数的实现方法，可以自己去实现
            }
        }

        long endTime = System.currentTimeMillis();
        printResult(primeNum, endTime - startTime); //打印某区间素数个数，以及所消耗的时间，可以自己去实现
    }

    //2、试除法：N 如果有（除了自身以外的）质因数，那么其中一个肯定会小于等于 N/2，若均无法整除，N则为素数。
    private void doIt2() {
        long startTime = System.currentTimeMillis();
        long primeNum = 0;
        boolean isPrime = true;    //默认该数是素数（对2的判断有效）
        for (long i = startNum; i <= endNum; i++) {
            long x = i / 2;
            for (long j = 2; j <= x; j++) { //如果直接写 j<=i/2 ，那么时间消耗会比第一种还大
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
                isPrime = true;
            }
            if (isPrime) {
                primeNum++;
                printPrime(i);
            }
        }

        long endTime = System.currentTimeMillis();
        printResult(primeNum, endTime - startTime);
    }

    //3、试除法：除了 2 以外，所有可能的质因数都是奇数。所以先尝试 2，然后再尝试从 3 开始一直到 N/2 的所有奇数。
    private void doIt3() {
        long startTime = System.currentTimeMillis();
        long primeNum = 0;
        boolean isPrime = true;    //默认该数是素数（对2的判断有效）
        for (long i = startNum; i <= endNum; i++) {
            if (i % 2 == 0) {
                continue;
            }
            long temp = i / 2;
            for (long j = 3; j <= temp; j = j + 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
                isPrime = true;
            }
            if (isPrime) {
                primeNum++;
                printPrime(i);
            }
        }

        long endTime = System.currentTimeMillis();
        printResult(primeNum, endTime - startTime);
    }

    //4、试除法：从 2 一直尝试到 根号N，若均无法整除，N则为素数。
    private void doIt4() {
        long startTime = System.currentTimeMillis();
        long primeNum = 0;
        boolean isPrime = true;    //默认该数是素数（对2的判断有效）
        for (long i = startNum; i <= endNum; i++) {
            long temp = (long) Math.sqrt(i);
            for (long j = 2; j <= temp; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
                isPrime = true;
            }
            if (isPrime) {
                primeNum++;
                printPrime(i);
            }
        }

        long endTime = System.currentTimeMillis();
        printResult(primeNum, endTime - startTime);
    }

    //5、试除法：除了 2 以外，所有可能的质因数都是奇数。所以先尝试 2，然后再尝试从 3 开始一直到 根号N 的所有奇数。
    private void doIt5() {
        long startTime = System.currentTimeMillis();
        long primeNum = 0;
        boolean isPrime = true;    //默认该数是素数（对2的判断有效）
        for (long i = startNum; i <= endNum; i++) {
            if (i % 2 == 0) {
                continue;
            }
            long temp = (long) Math.sqrt(i);
            for (long j = 3; j <= temp; j = j + 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
                isPrime = true;
            }
            if (isPrime) {
                primeNum++;
                printPrime(i);
            }
        }

        long endTime = System.currentTimeMillis();
        printResult(primeNum, endTime - startTime);
    }

    //6、筛选法：构造一个定长的布尔型数组，把所有元素都初始化为 true，在筛的过程中，一旦发现某个自然数是合数，就以该自然数为下标，把对应的布尔值改为 false。
    private void doIt6() {
        long startTime = System.currentTimeMillis();
        boolean[] primes = new boolean[(int) (endNum + 1)];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i <= endNum / i; i++) {
            if (primes[i]) {
                for (int j = i; j <= endNum / i; j++) {
                    primes[i * j] = false;
                }
            }
        }

        long primeNum = 0;
        for (long i = startNum; i <= endNum; i++) {
            if (primes[(int) i]) {
                primeNum++;
                printPrime(i);
            }
        }
        long endTime = System.currentTimeMillis();
        printResult(primeNum, endTime - startTime);
    }
}

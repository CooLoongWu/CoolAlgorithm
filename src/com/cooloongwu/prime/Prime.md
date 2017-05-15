> 声明：本文算法思想参考自网友“编程随想”的博客，代码为本人亲自实践而来。原文地址（貌似已无法访问）：http://program-think.blogspot.com/2011/12/prime-algorithm-1.htmls

# 打印某一区间的素数（质数）
## 1、试除法
  不断地尝试能否整除，例如要判断自然数 N 是否素数，就不断尝试小于 N 且大于1的自然数（这里就是优化的地方，尝试的越少那么这个算法的性能越强），只要有一个能整除，则 N 是合数；否则，N 是素数。
### 1.1、从 2 一直尝试到 N-1，若均无法整除，N则为素数。
代码如下：
```java
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
```
### 1.2、N 如果有（除了自身以外的）质因数，那么其中一个肯定会小于等于 N/2，若均无法整除，N则为素数。
代码如下：
```java
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
```

### 1.3、除了 2 以外，所有可能的质因数都是奇数。所以先尝试 2，然后再尝试从 3 开始一直到 N/2 的所有奇数。
代码如下：
```java
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
```

### 1.4、从 2 一直尝试到 根号N，若均无法整除，N则为素数。
代码如下：
```java
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
```
### 1.5、除了 2 以外，所有可能的质因数都是奇数。所以先尝试 2，然后再尝试从 3 开始一直到 根号N 的所有奇数。
代码如下：
```java
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
```

## 2、筛选法
#### 2.1、构造一个定长的布尔型数组，把所有元素都初始化为 true，在筛的过程中，一旦发现某个自然数是合数，就以该自然数为下标，把对应的布尔值改为 false。
代码如下：
```java
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
```

## 6种方法最终性能对比差异

> 找到素数9592个，耗时(毫秒)：4535

找到素数9592个，耗时(毫秒)：1999

找到素数9592个，耗时(毫秒)：1033

找到素数9592个，耗时(毫秒)：27

找到素数9592个，耗时(毫秒)：16

找到素数9592个，耗时(毫秒)：2


所有算法完整代码见GitHub：https://github.com/CooLoongWu/CoolAlgorithm
该算法类路径：com.cooloongwu.prime.Prime

# 猫扑素数

2017 年 4 月美团 Android 面试题：求猫扑素数

> 形如以 2 开头， 之后跟任意多个 3 的十进制整数如果是个素数， 则它是猫扑素数。
如 2、 23、 233、2333、23333 都是猫扑素数， 而 233333 则不是，
它可以分解为 353 x 661。

其实这道题也就是判断某一组有规律的数字是否是素数的问题了，具体判断素数可以简单修改下我们之前写过的求素数算法。详情见之前的文章[打印某一区间的素数（质数）](http://blog.csdn.net/u010976213/article/details/72146299),然后选择一种最优的算法来计算该数是否是素数即可。

然后还有一个问题就是如果使用*long*类型的整数来计算，那么当这个整数的长度超过19位后就无法再进行计算了。所以如果想实现更大的数值的判断那么这种方法就不适用了。

### 实现代码如下：
```java
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
```

### 打印结果一览
> 2是素数，耗时(毫秒)：0

> 23是素数，耗时(毫秒)：0

> 233是素数，耗时(毫秒)：0

> 2333是素数，耗时(毫秒)：0

> 23333是素数，耗时(毫秒)：0

> 233333不是素数，因子为：353，耗时(毫秒)：0

> 2333333不是素数，因子为：19，耗时(毫秒)：0

> 23333333不是素数，因子为：17，耗时(毫秒)：0

> 233333333不是素数，因子为：29，耗时(毫秒)：0

> 2333333333不是素数，因子为：10163，耗时(毫秒)：1

> 23333333333是素数，耗时(毫秒)：5

> 233333333333不是素数，因子为：569，耗时(毫秒)：0

> 2333333333333不是素数，因子为：1091，耗时(毫秒)：0

> 23333333333333不是素数，因子为：31，耗时(毫秒)：0

> 233333333333333不是素数，因子为：59，耗时(毫秒)：0

> 2333333333333333不是素数，因子为：311，耗时(毫秒)：0

> 23333333333333333是素数，耗时(毫秒)：1267

> 233333333333333333不是素数，因子为：58119797，耗时(毫秒)：287

> 2333333333333333333不是素数，因子为：337，耗时(毫秒)：0

> 4886589259623781717不是素数，因子为：7，耗时(毫秒)：0


------
所有算法完整代码见GitHub：https://github.com/CooLoongWu/CoolAlgorithm

该算法类路径：com.cooloongwu.prime.Prime233
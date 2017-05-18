# 单词翻转

2017 年 4 月美团 Android 面试题：单词翻转

总体思路就是将字符串以“空格”进行分隔，然后将分隔好的单词再连接空格拼接起来。

### 实现代码如下：
```java
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
```

### 打印结果一览
> 源字符串：This is just a test；反转后为：test a just is This


------
所有算法完整代码见GitHub：https://github.com/CooLoongWu/CoolAlgorithm

该算法类路径：com.cooloongwu.reverse.WordReverse

## 简单快速排序（Simple Selection Sort）
> 每一次遍历时选取关键字最小的记录作为有序序列的第i个记录。

### 算法原理
- 比较相邻的元素。如果第一个比第二个小，就记下第一个的索引。
- 在将第一个和第三个比较，如果第三个小就记下第三个的索引。每次将最小的数字与之后的进行比较。
- 循环完一次后第一个数就是最小的数字。
- 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

### 代码实现
```java
public static void sort(int[] args) {
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
        }
    }
```


------
所有算法完整代码见GitHub：https://github.com/CooLoongWu/CoolAlgorithm

该算法类路径：com.cooloongwu.sort.SimpleSelectionSort
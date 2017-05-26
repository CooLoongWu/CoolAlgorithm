# 排序算法
毕业后再也没有看过这些排序算法类的题目，上学学到的也差不多都被时间偷走了，那么是时候展（xue）现（xi）真正的技术了！

## 冒泡排序（Bubble Sort）
> 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。

### 算法原理
- 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
- 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。当最后一对结束后，最后的元素会是最大的数。
- 针对所有的元素重复以上的步骤，除了最后一个。
- 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

动态示例图如下所示（采用ECharts实现，代码见src/com/cooloongwu/sort/BubbleSort.html。此处展示的是每趟排序的结果，目前还不完善，无法展现每次排序的结果）：

![冒泡排序动态示例](http://img.blog.csdn.net/20170523151904537?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMDk3NjIxMw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### 代码实现
```java
public static int[] sort(int[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            for (int j = 0; j < args.length - 1 - i; j++) {
                if (args[j] < args[j + 1]) {
                    int temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }
            }
        }
        return args;
    }
```


------
所有算法完整代码见GitHub：https://github.com/CooLoongWu/CoolAlgorithm

该算法类路径：com.cooloongwu.sort.BubbleSort

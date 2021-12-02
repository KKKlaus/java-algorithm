public class 海量数据中寻找中位数 {
    // 假设磁盘10G， 内存2G，如何找到中位数 （类似还有如何找到第k大的数）

    // -------------------------------方法1： 外排序 + 归并-------------------------------
    // 先将这10G的数据等分成5份存储到硬盘中，然后依次读入一份到内存里面，进行排序，然后将这5份数据进行归并得到最后的排序结果，然后找出中位数第5G大
    // 归并过程 ： 每次将5个文件中的第一个数存入内存比较大小，所以需要很多I/O消耗
    //假定现在有20个数据的文件A：{5 11 0 18 4 14 9 7 6 8 12 17 16 13 19 10 2 1 3 15}，但一次只能使用仅装4个数据的内容，所以，我们可以每趟对4个数据进行排序，即5路归并，具体方法如下述步骤：
    //
    //我们先把“大”文件A，分割为a1，a2，a3，a4，a5等5个小文件，每个小文件4个数据
    //a1文件为：5 11 0 18
    //a2文件为：4 14 9 7
    //a3文件为：6 8 12 17
    //a4文件为：16 13 19 10
    //a5文件为：2 1 3 15
    //然后依次对5个小文件分别进行排序
    //a1文件完成排序后：0 5 11 18
    //a2文件完成排序后：4 7 9 14
    //a3文件完成排序后：6 8 12 17
    //a4文件完成排序后：10 13 16 19
    //a5文件完成排序后：1 2 3 15
    //最终多路归并，完成整个排序
    //整个大文件A文件完成排序后：0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19



    // -------------------------------方法2： 堆排序-------------------------------
    //对于10G的数据，它的中位数就是第5G个元素，按常理来说我们需要构建一个5G大小的堆，但是允许的内存只有两个G，
    // 所以我们先构建一个2G大小的大顶堆，然后求出第2G个元素（根节点），然后利用该元素构建一个新的2G大小的堆，求出第2G大的元素，依次类推，求出第5G大的元素
    //
    //每次构建一个堆求第几G大的元素，都需要重新遍历完所有10G的数据，相当于要遍历3 * 10G次，这需要频繁的IO操作，需要不断的从硬盘中读取数据


    // 方法3： bitmap  不懂  对于10G的数据我们只需要1G的内存就能够表示出来所有的数据，可见bitmap的压缩性之强
}

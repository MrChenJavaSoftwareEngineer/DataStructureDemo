package com.chenze.DataStructure.arry.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        System.out.println("this is InsertSort");
        //确定数据
         int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
             arr[i] = (int) (Math.random() * 10);
        }

        System.out.println("排序前的数据  "+Arrays.toString(arr));
        //准备执行方法的时间
         Date current = new Date();
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         String currentDate = simpleDateFormat.format(current);
        System.out.println("当前的时间  "+currentDate);
         insertSort(arr);
         Date end = new Date();
        String endDate = simpleDateFormat.format(end);
        System.out.println("结束的时间  "+endDate);
        System.out.println("排序后的数据  "+Arrays.toString(arr));
    }

    /**
     * 插入排序
     * 大体的思路：
     *进行arr.length次循环，总共操作两个数，最开始是从第一个和第二个进行比较交换，随着i的增大，那么小的那个数会放在这两个的前面，然后
     * 这个小的数会和他的前面的数进行比较，若还是该数小，则会放在前面，依次执行，直到insertIndex小于0了，表示该值为最小值，若是while
     * 的判断的第二个条件不满足了，则表示该数比当前的insertIndex之前的数要大，则指向该位置，那么就会进行判断，然后进行
     * 最后一次的交换，把该位置的数用insertValue进行覆盖。
     * @param arr 传入的数组
     */
    private static void insertSort(int[] arr) {
        for (int i = 1;i < arr.length ; i++) {
            //定义待定插入的辅助变量
           int insertValue=arr[i];
           int insertIndex=i-1;
           //找到需要进行插入排序的两个数值
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                //由当前的索引进行往前进行交换，知道第一个位置，直到insertIndex的值小于0，表示就只有第一个值和第二个值是相等的，所以只剩最后一步交换了
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            //这个表示找到了要进行插入的数值，进行最后一步，完成这次全部的交换
            if (insertIndex+1!=i){
                arr[insertIndex+1]=insertValue;
            }
        }
    }
}

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

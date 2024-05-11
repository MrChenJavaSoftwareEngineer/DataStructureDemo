package com.chenze.DataStructure.arry.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        System.out.println("this is SelectSort");
        //第一步实现数组的数据的准备
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*10);

        }
        System.out.println("排序前"+ Arrays.toString(arr));
        //第二步存储当前的时间
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String curDate = simpleDateFormat.format(currentDate);
        System.out.println("排序前的时间是="+curDate);
        //第三步执行selectSortSort方法
        selectSort(arr);
        //第四步存储当前的时间
        Date afterDate = new Date();
        String endDate = simpleDateFormat.format(afterDate);
        System.out.println("排序后的时间是="+endDate);
        System.out.println("排序后"+Arrays.toString(arr));
    }

    /**
     * 选择排序
     * 大体思路：
     * 通过两层for循环进行查找到最小值，并进行储存最小值，及其下标
     * 然后在第一层中进行if判断minIndex是否为当前的i，若不是，则进行交换位置
     * 以此类推，直到排序完毕
     * @param arr 传入的数组
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex=i;
            int min=arr[i];
            //i+1表示i之前的数已经排序好了，所以只需从i+1之后的数据中找到第i+1个最小值即可
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min=arr[j];
                    minIndex=j;
                }
            }
            //进行判断minIndex是否为当前的i值,若是就不进行交换，若不是就进行交换
            if (minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
}

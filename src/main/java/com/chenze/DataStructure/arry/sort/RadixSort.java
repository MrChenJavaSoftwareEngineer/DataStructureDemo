package com.chenze.DataStructure.arry.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        System.out.println("this is RadixSort");
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
        //第三步执行radixSort方法
        radixSort(arr);
        //第四步存储当前的时间
        Date afterDate = new Date();
        String endDate = simpleDateFormat.format(afterDate);
        System.out.println("排序后的时间是="+endDate);
        System.out.println("排序后"+Arrays.toString(arr));
    }

    /**
     * 基数排序
     * 大体思路：
     * 先是把数组中最大值找出来，并且得出这个最大值的位数，有多少位数，就要进行多少次排序
     * 先是个位按照的顺序进行个位数值与之相对应的桶的下标进行对应，把只进行放入到该桶中
     * 然后就是以十位，百位...以此类推
     * 最大数值的位数是多少，就进行这样的循环多少次
     * @param arr 传入的数组
     */
    private static void radixSort(int[] arr) {
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]){
                max=arr[i];
            }
        }
        //最大数的个数
       int maxLength=(max+"").length();
        //设置桶
        int[][] bucket= new int[10][arr.length];
        //每个桶有多少个元素
        int[] bucketElementCounts=new int[10];
        //进行radixSort
        for (int i = 0,n=1;i < maxLength; i++,n*=10) {
            //把值放入bucket中
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement=arr[j]/n%10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //开始把值放入arr中
            int index=0;
            for (int j = 0; j < bucketElementCounts.length; j++) {
                if (bucketElementCounts[j]!=0){
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++]=bucket[j][k];
                    }
                }
                bucketElementCounts[j]=0;
            }
        }
    }

}

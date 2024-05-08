package com.chenze.DataStructure.arry.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("this is BubbleSort");
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
        //第三步执行BubbleSort方法
        bubbleSort(arr);
        //第四步存储当前的时间
        Date afterDate = new Date();
        String endDate = simpleDateFormat.format(afterDate);
        System.out.println("排序后的时间是="+endDate);
        System.out.println("排序后"+Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int temp;//设置一个辅助变量
        boolean flag=false;//表示交换过，作用：提升效率
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                //如果前面的大于后面的，则交换
                if (arr[j]>arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=true;
                }
            }
            if (!flag){
                break;//表示一次都没有交换过，说明已经排好
            }else {
                flag=false;
            }
        }

    }

}

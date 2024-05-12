package com.chenze.DataStructure.arry.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        System.out.println("this is ShellSort");
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
        //第三步执行shellSortSort方法
        shellSort(arr);
        //第四步存储当前的时间
        Date afterDate = new Date();
        String endDate = simpleDateFormat.format(afterDate);
        System.out.println("排序后的时间是="+endDate);
        System.out.println("排序后"+Arrays.toString(arr));
    }

    /**
     *希尔排序（插入排序的升级版）
     * 大体思路：
     * 不再像插入排序那样步长为1或者是一个定值了，而是以arr.length除以2的规律进行步长的设置，
     * 步长为多少就表示有多少组，有多少组就进行至少多少次交换，为什么是至少，因为j=i-gab，有
     * 时j符合条件时，会进行下一次的交换，还有每组的交换次数不是有组（因为有些组是有5元素，
     * 但是步长为2）决定的，所以是至少
     * @param arr 传入的数组
     */
    private static void shellSort(int[] arr) {
        //定义一个辅助变量
        int temp = 0;
        //gab表示为步长
        for (int gab = arr.length/2; gab > 0 ;gab/=2) {
            for (int i = gab; i < arr.length; i++) {
                //进行每组的比较和交换
                for (int j = i-gab; j > 0 ; j-=gab) {
                    if (arr[j]>arr[j+gab]){
                        temp=arr[j];
                        arr[j]=arr[j+gab];
                        arr[j+gab]=temp;
                    }
                }
            }
        }
    }
}

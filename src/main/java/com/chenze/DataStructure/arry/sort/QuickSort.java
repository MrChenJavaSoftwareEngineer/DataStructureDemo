package com.chenze.DataStructure.arry.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("this is QuickSort");
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
        //第三步执行quickSortSort方法
        quickSort(arr,0,arr.length-1);
        //第四步存储当前的时间
        Date afterDate = new Date();
        String endDate = simpleDateFormat.format(afterDate);
        System.out.println("排序后的时间是="+endDate);
        System.out.println("排序后"+Arrays.toString(arr));
    }

    /**插入排序
     * 具体的逻辑：
     *
     * 第一部分表示循环进行交换本次
     * 第二部分表示递归循环进行交换
     *
     * @param arr 传入的数组
     * @param left 左下标
     * @param right 右下标
     */
    public static void quickSort(int[] arr, int left, int right) {
        /*
        第一部分
         */
        int l=left;//设置左下标
        int r=right;//设置右下标
        int pivot=arr[(right+left)/2];//设置中轴值
        int temp=0;//设置辅助变量
        //如果左下标小于右下标则继续，否则停止
        while(r>l){
            //以中轴到left之间的范围进行查找到符合的值
            while (arr[l]<pivot){
                l++;
            }
            //以中轴到right之间的范围进行查找到符合的值
            while(arr[r]>pivot){
                r--;
            }
            //若right小于left，则表示已经本次已经循环交换完了
            if (r<=l){
                break;
            }
            //符合的值进行交换
            temp=arr[r];
            arr[r]=arr[l];
            arr[l]=temp;
            //若arr[l]等于pivot，则r向左移动，通过循环到arr[r]是表示符合的值为止，然后进行交换
            if (arr[l]==pivot){
                r--;
            }
            //若arr[r]等于pivot，则l向右移动，通过循环到arr[l]是表示符合的值为止，然后进行交换
            if (arr[r]==pivot){
                l++;
            }
        }
        /*
        第二部分
         */
        //当l和r相等时，若不进行r--,l++就会出现溢栈
        if (l==r){
            r--;
            l++;
        }
        //向左递归
        if (r>left){
            quickSort(arr, left, r);
        }
        //向右递归
        if (l<right){
            quickSort(arr, l, right);
        }
    }
}

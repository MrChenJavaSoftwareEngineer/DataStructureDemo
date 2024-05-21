package com.chenze.DataStructure.arry.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static com.sun.deploy.net.MessageHeader.merge;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("this is MergeSort");
        //确定数据
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }

        System.out.println("排序前的数据  "+ Arrays.toString(arr));
        //准备执行方法的时间
        Date current = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentDate = simpleDateFormat.format(current);
        System.out.println("当前的时间  "+currentDate);
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        Date end = new Date();
        String endDate = simpleDateFormat.format(end);
        System.out.println("结束的时间  "+endDate);
        System.out.println("排序后的数据  "+Arrays.toString(arr));
    }

    /**
     * 归并排序
     * 大体思路：
     * 先把数组进行分治，就是分成以二为除数，进行分治，直到不能再分为止，就进行合并且排序
     * @param arr 传入的数组
     * @param left 传入的数组左初始索引
     * @param right 传入的数组最大右索引
     * @param temp 作为一个临时存储的数组
     */
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left<right){
            int mid=(left+right)/2;
            //左分治
            mergeSort(arr, left, mid, temp);
            //右分治
            mergeSort(arr, mid+1, right, temp);
            //合并
            merge(arr,left,mid,right,temp);

        }
    }

    /**
     * 合并
     * 先进行左合并再通过temp把原来的数组的相应的值进行覆盖，在进行右合并也是如此，直到最后一次进行原数组的全部进行覆盖，则
     * 表示排序完成。
     * @param arr 传入的数组
     * @param left 传入的数组左初始索引
     * @param mid 传入的数组的中间索引
     * @param right 传入的数组最大右索引
     * @param temp 作为一个临时存储的数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i=left;//左边的初始索引
        int j=mid + 1;//右边的初始索引
        int t=0;//temp的索引
        while(i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                t++;
                i++;
            }else {
                temp[t]=arr[j];
                t++;
                j++;
            }
        }

        //左边剩余的都放在temp下
        while(i<=mid){
            temp[t]=arr[i];
            t++;
            i++;
        }

        //右边剩余的都放在temp下
        while (j<=right){
            temp[t]=arr[j];
            t++;
            j++;
        }

        //把temp的值进行覆盖到arr中
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            tempLeft++;
            t++;
        }
    }

}

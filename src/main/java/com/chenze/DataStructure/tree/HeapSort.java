package com.chenze.DataStructure.tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr={4, 6, 8, 5, 9};
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        int temp=0;
        System.out.println("堆排序~~");
        //先搞成堆的形式，次数是叶子节点的数量
        for(int i = arr.length / 2 -1; i >=0; i--) {
            adjustHeapSort(arr, i, arr.length);
        }
        //再以堆的形式进行首尾互换，然后再进行调整为堆，然后依次类推，直至完成排序~
        for (int i= arr.length-1;i>=0;i--){
            temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            adjustHeapSort(arr,0,i);
        }
        System.out.println("堆排序后的数组："+ Arrays.toString(arr));
    }

    /**
     * 堆排序
     * 大体思路：
     * 先是以一个树进行分析，以小推出大的堆的一些规律，然后进行运用，然后把数组（二叉树）变成堆
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    private static void adjustHeapSort(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2*i+1; j <length ; j=j*2+1) {
            if (j+1<length&&arr[j]<arr[j+1]){
                j++;
            }
            if (arr[j]>temp){
                arr[i]=arr[j];
                i=j;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
}

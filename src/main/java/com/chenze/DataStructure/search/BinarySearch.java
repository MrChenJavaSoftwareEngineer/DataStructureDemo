package com.chenze.DataStructure.search;

import com.chenze.DataStructure.arry.sort.QuickSort;

import java.text.SimpleDateFormat;
import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("this is BinarySearch");
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*10);

        }
        QuickSort.quickSort(arr,0, arr.length-1);
        System.out.println("查找前"+ Arrays.toString(arr));
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String curDate = simpleDateFormat.format(currentDate);
        System.out.println("查找前的时间是="+curDate);
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        binarySearch(arr,0,arr.length-1, value,list);
        Date afterDate = new Date();
        String endDate = simpleDateFormat.format(afterDate);
        System.out.println("查找后的时间是="+endDate);
        System.out.println("查找后"+list);
    }

    /**
     * 二分查找
     * 大体的逻辑：
     * 通过对数组进行除以2的形式，以数组中间值为判断条件，若大于这个值则向右递归，若小于这个值则向左递归，若相等，则进行
     * 左右的循环查找是否还有这样的值，若有则一并添加到list集合中
     * @param arr 传入的数组
     * @param left 传入的数组左初始下标
     * @param right 传入的数组右初始下标
     * @param value 查找的值
     * @param list 储存传入的数组查找的值的下标
     */
    private static void binarySearch(int[] arr, int left, int right, int value,List<Integer> list) {
            if (left>right||arr[arr.length-1]<value||arr[0]>value) {
                return;
            }
            int midIndex = (left + right) / 2;
            if (arr[midIndex] < value) {
                binarySearch(arr, midIndex + 1, right, value, list);
            } else if (arr[midIndex] > value) {
                binarySearch(arr, left, midIndex - 1, value, list);
            } else {
                int temp=midIndex-1;
                while (temp >= 0 && arr[temp] == value ) {
                    list.add(temp);
                    temp--;
                }
                list.add(midIndex);
                temp=midIndex+1;
                while (temp <= arr.length - 1 && arr[temp] == value) {
                    list.add(temp);
                    temp++;
                }
            }
        }
}

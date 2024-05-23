package com.chenze.DataStructure.search;

import com.chenze.DataStructure.arry.sort.QuickSort;

import java.text.SimpleDateFormat;
import java.util.*;

public class InsertValueSearch {
    public static void main(String[] args) {
        System.out.println("this is InsertValueSearch");
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
        insertValueSearch(arr,0,arr.length-1, value,list);
        Date afterDate = new Date();
        String endDate = simpleDateFormat.format(afterDate);
        System.out.println("查找后的时间是="+endDate);
        System.out.println("查找后"+list);
    }

    /**
     * 插值查找
     * 大体逻辑：
     * 先是运用left + (right - left) * (value - arr[left]) / (arr[right] - arr[left])这个公式，找到一个midValue
     * 这个midValue是自适应是。其他和二分查找一样。
     * 若是数组中的值是分不均匀的情况用插值查找更快
     * 若不均匀，则插值查找和二分查找一样，二分查找更好，因为插值查找还要比二分查找运算更复杂些。
     * @param arr 传入的数组
     * @param left 传入的数组左初始下标
     * @param right 传入的数组右初始下标
     * @param value 查找的值
     * @param list 储存传入的数组查找的值的下标
     */
    private static void insertValueSearch(int[] arr, int left, int right, int value, List<Integer> list) {
        if (left>right||arr[arr.length-1]<value||arr[0]>value){
            return;
        }
        //找到自适应式的mid值
        int midIndex = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (arr[midIndex] < value) {
            insertValueSearch(arr, midIndex + 1, right, value, list);
        } else if (arr[midIndex] > value) {
            insertValueSearch(arr, left, midIndex - 1, value, list);
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

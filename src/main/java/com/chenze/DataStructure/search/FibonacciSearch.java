package com.chenze.DataStructure.search;

import com.chenze.DataStructure.arry.sort.QuickSort;

import java.text.SimpleDateFormat;
import java.util.*;

public class FibonacciSearch {
    public static void main(String[] args) {
        System.out.println("this is FibonacciSearch");
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
        System.out.println("请输入一个要查找的值：");
        int value = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        fibonacciSearch(arr,0,arr.length-1, value,list);
        Date afterDate = new Date();
        String endDate = simpleDateFormat.format(afterDate);
        System.out.println("查找后的时间是="+endDate);
        System.out.println("查找后"+list);
    }

    /**
     * 斐波那契查找
     * 大体逻辑：
     * 先是创建一个斐波那契数列进行预备，然后运用斐波那契数列进行确定传入的数组的长度，只能是斐波那契数列的当下的值要大于或者等于
     * 传入的数组的长度，然后进行Arrays.copyOf(arr,f[k])得到一个temp数组，把temp多余的数组空间设置为0.但是我们需要的是
     * 原来的数组的最大值进行设置到temp数组多余的空间中，所以进行temp多余的数组位数都是设置为最大值，然后运用
     * mid=mid+f[k-1]-1进行确定中间索引，进行temp[mid]进行Value比较，从而类似于前面的二分查找
     * 进行找到所需要的值
     * @param arr 传入的数组
     * @param left 传入的数组左初始下标
     * @param right 传入的数组右初始下标
     * @param value 查找的值
     * @param list 储存传入的数组查找的值的下标
     */
    private static void fibonacciSearch(int[] arr, int left, int right, int value, List<Integer> list) {
        int mid=0;
        int low=left;
        int high=right;
        int k=0;
        int[] f=fib();
        while(high>f[k]-1){
            k++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);//第一个参数是指对应的数组，第二个参数是指这个数组的新的长度
        for (int i = high+1; i <temp.length ; i++) {
            temp[i]=arr[high];
        }
        while (low<=high){
            mid=low+f[k-1]-1;
            if (value<temp[mid]){
                high=mid-1;
                k--;
            }else if (value>temp[mid]){
                low=mid+1;
                k-=2;
            }else {
                if (mid<high){
                    int temp1=mid-1;
                    while (temp1 >= 0 && arr[temp1] == value ) {
                        list.add(temp1);
                        temp1--;
                    }
                    list.add(mid);
                    temp1=mid+1;
                    while (temp1 <= arr.length - 1 && arr[temp1] == value) {
                        list.add(temp1);
                        temp1++;
                    }
                }else {
                    int temp1=high-1;
                    while (temp1 >= 0 && arr[temp1] == value ) {
                        list.add(temp1);
                        temp1--;
                    }
                    list.add(high);
                }
                return;
            }
        }
    }

    private static int[] fib() {
        int maxValue=20;
         int[] ints = new int[maxValue];
         ints[0]=1;
         ints[1]=1;
        for (int i = 2; i <20 ; i++) {
            ints[i]=ints[i-1]+ints[i-2];
        }
        return ints;
    }
}

package com.chenze.DataStructure.search;

import java.text.SimpleDateFormat;
import java.util.*;

public class SeqSearch {
    public static void main(String[] args) {
        System.out.println("this is SeqSearch");
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*10);

        }
        System.out.println("查找前"+ Arrays.toString(arr));
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String curDate = simpleDateFormat.format(currentDate);
        System.out.println("查找前的时间是="+curDate);
         Scanner scanner = new Scanner(System.in);
         int value = scanner.nextInt();
        List<Integer> list = seqSearch(arr, value);
        Date afterDate = new Date();
        String endDate = simpleDateFormat.format(afterDate);
        System.out.println("查找后的时间是="+endDate);
        System.out.println("查找后"+list);
    }

    /**
     * 有序查找
     * 大体逻辑：
     * 通过循环遍历进行查找到相应的值，并储存到list集合中
     * @param arr 传入的数组
     * @param value 查找的值
     * @return 储存传入的数组查找的值的下标的list集合
     */
    private static List<Integer> seqSearch(int[] arr, int value) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (value==arr[i]){
                list.add(i);
            }
        }
        return list;
    }

}

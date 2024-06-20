package com.chenze.Algorithm.binarysearchnorecursion;

//二分查找，不用递归
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        //测试
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 100);
        System.out.println("index=" + index);//
    }

    private static int binarySearch(int[] arr, int target) {
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (arr[mid]==target){
                return mid;
            } else if (arr[mid]<target) {
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }

}

package com.chenze.DataStructure.tree;

import com.sun.deploy.util.StringUtils;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
         ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
         arrBinaryTree.preOrder();
    }
    //正确答案是1,2,4,5,3,6,7
}
class ArrBinaryTree{
    int[] arr;
    public ArrBinaryTree(int[] arr){
        this.arr=arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }

    private void preOrder(int index) {
        if (arr.length==0||arr==null){
            System.out.println("该数组为空，无法进行遍历~");
        }
        System.out.println(index+1);
        //向左进行遍历
        if ((index*2+1)< arr.length){
            preOrder(index*2+1);
        }
        //向右进行遍历
        if ((index*2+2)< arr.length){
            preOrder(index*2+2);
        }
    }
}

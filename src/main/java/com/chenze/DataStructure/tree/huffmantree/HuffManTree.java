package com.chenze.DataStructure.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffManTree {

    public static void main(String[] args) {
         int[] arr = { 13, 7, 8, 3, 29, 6, 1 };

         HuffManNode huffManTree = createHuffManTree(arr);
         preOrder(huffManTree);
    }

    private static void preOrder(HuffManNode root) {
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("该树是空树~");
        }
    }
    /**
     * 创建赫夫曼树
     * 大体思路：
     * 先是从一个小树中获得规律进行推广的到全局，先是进行一个Collections.sort(list)进行List的从小到大的排序，然后进行
     * 最前面两个数进行设置到新创建的节点的左右节点中...依次类推就能得到一个赫夫曼树了
     * 注意赫夫曼树节点中要实现一个Comparable接口，其中的类型是赫夫曼树节点类型的，然后实现其中一个CompareTo的方法，
     * this.value-o.value表示从小到大的排序规则。
     * @param arr 需要创建成哈夫曼树的数组
     * @return 创建好后的赫夫曼树的root结点
     */
    public static HuffManNode createHuffManTree(int[] arr){
         List<HuffManNode> list = new ArrayList<>();
        for (int value:arr) {
             HuffManNode huffManNode = new HuffManNode(value);
             list.add(huffManNode);
        }
       while(list.size()>1){
           //进行从小到大排序
           Collections.sort(list);
           System.out.println("list="+list);
            HuffManNode leftNode = list.get(0);//list.get(0)返回的是一个E类型的泛型，所以会报ArrayList的错误
            HuffManNode rightNode = list.get(1);
           HuffManNode huffManNode = new HuffManNode(leftNode.value + rightNode.value);
           huffManNode.leftNode=leftNode;
           huffManNode.rightNode=rightNode;
           list.remove(leftNode);
           list.remove(rightNode);
           list.add(huffManNode);
       }
       return list.get(0);
    }
}
class HuffManNode implements Comparable<HuffManNode> {
    int value;
    HuffManNode leftNode;
    HuffManNode rightNode;
    public HuffManNode(int value){
        this.value=value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.leftNode!=null){
            this.leftNode.preOrder();
        }
        if (this.rightNode!=null){
            this.rightNode.preOrder();
        }
    }

    @Override
    public String toString() {
        return "HuffManNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuffManNode o) {
        //从小到大进行排序
        return this.value-o.value;
    }
}
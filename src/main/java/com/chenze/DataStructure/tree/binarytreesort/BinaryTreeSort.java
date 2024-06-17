package com.chenze.DataStructure.tree.binarytreesort;

public class BinaryTreeSort {
    public static void main(String[] args) {
        int[] arr={7, 3, 10, 12, 5, 1, 9, 2};
        BinaryTree binaryTree = new BinaryTree();
        for (int value:arr) {
            binaryTree.add(new Node(value));
        }
        System.out.println("中序遍历~");// 1, 2, 3, 5, 7, 9, 10, 12
        binaryTree.infixOrder();
    }
}
class BinaryTree{
    Node root;
    public Node getRoot(){
        return this.root;
    }
    //添加结点
    public void add(Node node){
        if (this.root==null){
            this.root=node;
        }else{
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("该数为空~");
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value=value;
    }

    //添加结点
    public void add(Node node){
        if (node.value<this.value){
            if (this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder(){
      if (this.left!=null){
          this.left.infixOrder();
      }
        System.out.println(this.value);
      if (this.right!=null){
          this.right.infixOrder();
      }
    }

}


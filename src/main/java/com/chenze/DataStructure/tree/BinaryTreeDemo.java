package com.chenze.DataStructure.tree;

import java.util.Objects;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, "宋江");
        TreeNode node2 = new TreeNode(2, "吴用");
        TreeNode node3 = new TreeNode(3, "卢俊义");
        TreeNode node4 = new TreeNode(4, "林冲");
        TreeNode node5 = new TreeNode(5, "关胜");
        root.setLeftNode(node2);
        root.setRightNode(node3);
        node3.setRightNode(node4);
        node3.setLeftNode(node5);
         BinaryTree binaryTree = new BinaryTree(root);
         //二叉树遍历
         binaryTree.preOrder();
         //二叉树遍历查找
         Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要找到人的编号：");
         int index= scanner.nextInt();
        TreeNode treeNode = binaryTree.preOrderSearch(index);
         System.out.println(treeNode+" ^_^找到了~");
    }

}

/**
 * 创建一个二叉树
 */
class  BinaryTree{
    TreeNode treeNode;

    public BinaryTree(TreeNode treeNode) {
        this.treeNode = treeNode;
    }
    //==================二叉树遍历=======================
    //前序遍历
    public void preOrder(){
        if (this.treeNode!=null){
            this.treeNode.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.treeNode!=null){
            this.treeNode.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.treeNode!=null){
            this.treeNode.postOrder();
        }
    }
    //==================二叉树查找=================
    //前序遍历查找
    public TreeNode preOrderSearch(Integer no){
        if (this.treeNode!=null){
            return this.treeNode.preOrderSearch(no);
        }else {
            return null;
        }
    }

    //中序遍历查找
    public TreeNode infixOrderSearch(Integer no){
        if (this.treeNode!=null){
            return this.treeNode.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    //后序遍历查找
    public TreeNode postOrderSearch(Integer no){
        if (this.treeNode!=null){
            return this.treeNode.postOrderSearch(no);
        }else {
            return null;
        }
    }
}

/**
 * 创建一个树节点
 */
class TreeNode{
   private Integer userNo;
   private String userName;
   private TreeNode leftNode;
   private TreeNode rightNode;

    public TreeNode(Integer userNo, String userName) {
        this.userNo = userNo;
        this.userName = userName;
    }
//=====================二叉树遍历=====================================
    public void preOrder(){
        System.out.println(this);
        if (this.leftNode!=null){
            this.leftNode.preOrder();
        }

        if (this.rightNode!=null){
            this.rightNode.preOrder();
        }
    }

    public void infixOrder(){
        if (this.leftNode!=null){
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        if (this.rightNode!=null){
            this.rightNode.infixOrder();
        }
    }

    public void postOrder(){
        if (this.leftNode!=null) {
            this.leftNode.infixOrder();
        }
        if (this.rightNode!=null){
            this.rightNode.infixOrder();
        }
        System.out.println(this);
    }
//============================二叉树查找==================================
    public TreeNode preOrderSearch(Integer no){
        if (Objects.equals(this.userNo, no)){
            return this;
        }
        TreeNode treeNode=null;
        if (this.leftNode!=null){
            treeNode=this.leftNode.preOrderSearch(no);
        }
        if (treeNode!=null){
            return treeNode;
        }
        if (this.rightNode!=null){
            treeNode=this.rightNode.preOrderSearch(no);
        }
        return treeNode;
    }

    public TreeNode infixOrderSearch(Integer no){
        TreeNode treeNode=null;
        if (this.leftNode!=null){
            treeNode=this.leftNode.infixOrderSearch(no);
        }
        if (treeNode!=null){
            return treeNode;
        }
        if (Objects.equals(this.userNo, no)){
            return this;
        }
        if (this.rightNode!=null){
            treeNode=this.rightNode.infixOrderSearch(no);
        }
        return treeNode;
    }

    public TreeNode postOrderSearch(Integer no){
        TreeNode treeNode=null;
        if (this.leftNode!=null){
            treeNode=this.leftNode.postOrderSearch(no);
        }
        if (treeNode!=null){
            return treeNode;
        }
        if (this.rightNode!=null){
            treeNode=this.rightNode.postOrderSearch(no);
        }
        if (treeNode!=null){
            return treeNode;
        }
        if (Objects.equals(this.userNo, no)){
            return this;
        }
        return treeNode;
    }
    @Override
    public String toString() {
        return "TreeNode{" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                '}';
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
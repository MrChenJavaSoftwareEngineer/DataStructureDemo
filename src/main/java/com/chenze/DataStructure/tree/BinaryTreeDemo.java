package com.chenze.DataStructure.tree;

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
         binaryTree.preOrder();
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
package com.chenze.DataStructure.tree.threadedbianrytree;

import java.util.Objects;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeftNode(node2);
        root.setRightNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);
        node3.setLeftNode(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeftNode();
        HeroNode rightNode = node5.getRightNode();
        System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("10号结点的后继结点是="  + rightNode); //1
    }
}

class ThreadedBinaryTree{
    private HeroNode root;
    private HeroNode pre;
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    public void threadedNodes(){
        this.threadedBinaryTree(root);
    }
    public void threadedBinaryTree(HeroNode node){
        if (node==null){
            return;
        }
        //进行向左进行遍历
        threadedBinaryTree(node.getLeftNode());
        //向左进行判断
        if (node.getLeftNode()==null){
            node.setLeftNode(pre);
            node.setLeftType(1);//1表示是该节点的前驱节点
        }
        //向右进行遍历
        if (pre!=null&&pre.getRightNode()==null){
            pre.setRightNode(node);
            pre.setRightType(1);
        }
        pre=node;
        //进行向右进行遍历
        threadedBinaryTree(node.getRightNode());
    }
}

class HeroNode{
        private Integer userNo;
        private String userName;
        private HeroNode leftNode;
        private HeroNode rightNode;
        private Integer leftType;
        private Integer rightType;

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLeftNode(HeroNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(HeroNode rightNode) {
        this.rightNode = rightNode;
    }

    public void setLeftType(Integer leftType) {
        this.leftType = leftType;
    }

    public void setRightType(Integer rightType) {
        this.rightType = rightType;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public String getUserName() {
        return userName;
    }

    public HeroNode getLeftNode() {
        return leftNode;
    }

    public HeroNode getRightNode() {
        return rightNode;
    }

    public Integer getLeftType() {
        return leftType;
    }

    public Integer getRightType() {
        return rightType;
    }
        public HeroNode(Integer userNo, String userName) {
            this.userNo = userNo;
            this.userName = userName;
        }
        //=====================二叉树遍历=====================================

        @Override
        public String toString() {
            return "TreeNode{" +
                    "userNo=" + userNo +
                    ", userName='" + userName + '\'' +
                    '}';
        }

    }


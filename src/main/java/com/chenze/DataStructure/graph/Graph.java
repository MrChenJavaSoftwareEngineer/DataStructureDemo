package com.chenze.DataStructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Boolean和boolean的区别，Boolean默认值是null，注意空指针异常，boolean默认值是false
 * 所有首字母大写的数据类型，可以理解为一个类（该类型的一个包，就是该类型的总称），所以默认值为null
 * 而首字母小写的数据类型则是正常的数据类型，所以默认值为该类型的数值的最小值。
 */

public class Graph {
    private ArrayList<String> vertexList;//储存结点
    private int[][] edges;//结点之间的边
    private int numOfEdges;//边的数量
    private boolean[] isVisited;//是否进行访问

    public static void main(String[] args) {
        int vertexNum=5;
        String[] vertexS={"A", "B", "C", "D", "E"};
         Graph graph = new Graph(vertexNum);
        for (String vertex:vertexS) {
            graph.insertVertex(vertex);
        }

        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); //
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1); //
        graph.insertEdge(1, 4, 1); //

        //显示一把邻结矩阵
        graph.showGraph();

        graph.dfs();
    }

    //展示图的矩阵
    public void showGraph(){
        for (int[] link:edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //获得当前结点的相邻的第一个结点
    public int getFirstNeighbor(int index){
        for (int i=0;i<vertexList.size();i++){
            if(edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //获得当前结点的相邻的第二个结点
    public int getNextNeighbor(int v1,int v2){
        for (int i=v2+1;i<vertexList.size();i++){
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }

    //进行dfs算法（深度优先算法）,isVisited是非常重要的，因为是否要进行的是回溯还是深入，都要看这个isVisited的值。
    private void dfs(boolean[] isVisited,int index){
        System.out.print(getValueByIndex(index)+"->");
        isVisited[index]=true;
        int w = getFirstNeighbor(index);
        while(w !=-1){
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(index, w);
        }
    }

    //避免遗漏，写一个重载
    public void dfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    //返回指定结点之间的边的数值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //返回边的数量
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

    //添加结点
    private void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //构建图
    public Graph(int num){
        edges=new int[num][num];
        vertexList=new ArrayList<>(num);
        numOfEdges=0;
        isVisited=new boolean[num];
    }

    //

}

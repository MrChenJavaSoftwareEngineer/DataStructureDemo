package com.chenze.DataStructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;//储存结点
    private int[][] edges;//结点之间的边
    private int numOfEdges;//边的数量

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
    }

    //展示图的矩阵
    public void showGraph(){
        for (int[] link:edges) {
            System.out.println(Arrays.toString(link));
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
    }

    //

}

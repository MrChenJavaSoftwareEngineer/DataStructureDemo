package com.chenze.Algorithm.prim;

import java.util.Arrays;

//普里姆算法
public class PrimAlgorithm {
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verXs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        //创建MGraph对象
        MGraph graph = new MGraph(verXs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verXs, data, weight);
        //输出
        minTree.showGraph(graph);
        //测试普利姆算法
        minTree.prim(graph, 1);//
    }
}
class MinTree{

    public void createGraph(MGraph graph, int verXs, char[] data, int[][] weight) {
        graph.verXs=verXs;
        for (int i = 0; i < graph.verXs; i++) {
            graph.data[i]=data[i];
            for (int j = 0; j < graph.verXs; j++) {
                graph.weight[i][j]=weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int[] link:graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph graph, int v) {
        int[] visited=new int[graph.verXs];
        visited[v]=1;//1表示访问过了
        int h1=-1;
        int h2=-1;
        int minWeight=10000;
        for (int k = 1; k < graph.verXs; k++) {//因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边
            for (int i = 0; i < graph.verXs ; i++) {
                for (int j = 0; j < graph.verXs; j++) {
                    if (visited[i]==1&&visited[j]==0&&graph.weight[i][j]<minWeight){
                        minWeight=graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }
            }
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            visited[h2]=1;
            minWeight=10000;
        }
    }
}
class MGraph{
    int verXs;
    char[] data;
    int[][] weight;
    public MGraph(int verXs){
        this.verXs=verXs;
        this.data=new char[verXs];
        this.weight=new int[verXs][verXs];
    }
}
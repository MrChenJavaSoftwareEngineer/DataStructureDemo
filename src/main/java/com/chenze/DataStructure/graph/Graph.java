package com.chenze.DataStructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//储存结点
    private int[][] edges;//结点之间的边
    private int numOfEdges;//边的数量

    //定义给数组boolean[], 记录某个结点是否被访问
    private boolean[] isVisited;

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

        //测试一把，我们的dfs遍历是否ok
//        System.out.println("深度遍历");
//        graph.dfs(); // A->B->C->D->E [1->2->4->8->5->3->6->7]
        System.out.println("广度优先遍历");
        graph.bfs();//A->B->C->D-E [1->2->3->4->5->6->7->8]
    }

    //对dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行dfs[回溯]
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //得到第一个邻接结点的下标 w
    /**
     *
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for(int j = 0; j < vertexList.size(); j++) {
            if(edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for(int j = v2 + 1; j < vertexList.size(); j++) {
            if(edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //广度优先
    private void bfs(boolean[] isVisited,int i){
        int u;//头结点
        int w;//邻结点
        System.out.println(getValueByIndex(i)+"=>");
        isVisited[i]=true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(i);
        while(!queue.isEmpty()){
            u = queue.removeFirst();
            w=getFirstNeighbor(u);
            while(w!=-1){
                if (!isVisited[w]){
                    System.out.println(getValueByIndex(w)+"=>");
                    isVisited[w]=true;
                    queue.addLast(w);
                }
                 w = getNextNeighbor(u, w);
            }
        }
    }

    //广度优先
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }


    //深度优先遍历算法
    //i 第一次就是 0
    private void dfs(boolean[] isVisited, int i) {
        //首先我们访问该结点,输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while(w != -1) {//说明有
            if(!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }

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

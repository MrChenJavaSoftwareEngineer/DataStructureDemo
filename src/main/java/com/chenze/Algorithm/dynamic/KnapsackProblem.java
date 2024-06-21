package com.chenze.Algorithm.dynamic;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] val={1500, 3000, 2000};//物品的价格
        int[] w={1, 4, 3};//物品的重量
        int n=val.length;//物品的个数
        int m=4;//背包的容积（能承受的重量）
        int[][] v = new int[n + 1][m + 1];//最大的放入量
        int[][] path = new int[n+1][m+1];//放入的路径

        //先进行第一列设置为零
        for (int i = 0; i < v.length; i++) {
            v[i][0]=0;
        }
        //然后进行设置第一行进行设置为零
        for (int i = 0; i < v[0].length; i++) {
            v[0][i]=0;
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j <v[i].length ; j++) {
                //评判依据是重量
                if (w[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else {
                    if (v[i-1][j]>val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=v[i-1][j];
                    }else {
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }
                }
            }
        }

        //进行遍历背包规划表
        for (int[] ints : v) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println("============================");

        //输出背包规划的最好的方案
        int i=path.length-1;
        int j=path[0].length-1;
        while(i>0&&j>0){
            if (path[i][j]==1){
                System.out.printf("第%d个商品放入到背包\n", i);
                j-=w[i-1];
            }
            i--;
        }
    }
}

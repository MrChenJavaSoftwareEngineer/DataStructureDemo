package com.chenze.Algorithm.kmp;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        //String str2 = "BBC";

        int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0]
        System.out.println("next=" + Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index); // 15了
    }

    //写出我们的kmp搜索算法
    /**
     *
     * @param str1 源字符串
     * @param str2 子串
     * @param next 部分匹配表, 是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    private static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0,j=0; i < str1.length(); i++) {
            while(j>0&&str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    //获取到一个字符串(子串) 的部分匹配值表
    private static int[] kmpNext(String dest) {
        int[] intNext = new int[dest.length()];
        intNext[0]=0;
        for (int i = 1, j=0; i <dest.length() ; i++) {
            while (j>0 &&dest.charAt(i)!=dest.charAt(j)){
                j=intNext[j-1];
            }
            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            intNext[i]=j;
        }
        return intNext;
    }
}

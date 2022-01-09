package com.super404.Week8.LeeCode684;

public class Solution {
    private int[] fa;
    public int[] findRedundantConnection(int[][] edges) {
        //并查集解法
        //如果遍历到一条边的两个点没有共同的father，则合并；
        //如果遍历到一条边的两个点有共同的father，说明再加上这条边出现了环
        int n = edges.length; //树有n个点，n-1条边；这里加了一条边，n条边
        //MakeSet
        //根节点数组
        fa = new int[n+1];
        for(int i=1; i<=n; i++){
            fa[i] = i;
        }

        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            if(find(x) != find(y)){
                unionSet(x,y);
            } else {
                return edge;
            }
        }
        return new int[]{};
    }

    private int find(int x){
        if(x == fa[x]){
            return x;
        }
        return fa[x] = find(fa[x]);
    }

    private void unionSet(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            fa[x] = y;
        }
    }
}

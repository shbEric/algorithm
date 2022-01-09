package com.super404.Week8.LeeCode200;

import java.util.Arrays;

public class Solution {
    private int m=0, n=0;
    private int[] fa; //根节点数组
    //方向数组
    private int[] dx = {-1,0,0,1};
    private int[] dy = {0,-1,1,0};

    int count=0; //计数连通块数量，初始为n*m,去掉为0的单位，其他的单位为1时每做一次实际的合并，count减1
    //并查集解法
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        //MakeSet
        fa = new int[m*n];
        for(int i=0; i<m*n; i++){
            fa[i] = i;
        }
        count = m*n;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //为0的位置，fa[]标为-1
                if(grid[i][j] == '0'){
                    fa[num(i,j)] = -1;
                    count--;
                    continue;
                }
                //为1的位置，和四周为1的点合并
                for(int k=0; k<4; k++){
                    int ni = i+dx[k];
                    int nj = j+dy[k];
                    if(ni<0 || nj<0 || ni>=m || nj >=n){
                        //四周出界了
                        continue;
                    } else {
                        if(grid[ni][nj] == '1'){
                            unionSet(num(i,j), num(ni,nj));
                        }
                    }
                }
                //因为可以合并的话，已经和四周的点合并了，所以可以标为0，不用再次访问，提高速度
                grid[i][j] = '0';
            }
        }
        return count;

    }

    //二维坐标转换为一维
    private int num(int i, int j){
        return i*n +j;
    }

    private int find(int x){
        if(x == fa[x]) {
            return x;
        }
        return fa[x] = find(fa[x]);
    }

    private void unionSet(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            fa[x] = y;
            count--;
        }
    }
}

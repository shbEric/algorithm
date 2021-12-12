package com.super404.Week4.LeeCode130;

public class Solution {
    int m = 0, n = 0;
    private boolean[][] visited;
    private char[][] board;
    //方向数组
    int[] dx = {-1,0,0,1};
    int[] dy = {0,-1,1,0};
    public void solve(char[][] board) {
        //边上为O的肯定不算，即长宽都得大于2才有不是边的区域
        m = board.length;
        n = board[0].length;
        if(m-2<=0 || n-2<=0){
            return;
        }
        //从边上为O的点开始向四周扩展，这些O都是没有被包围的，改成A
        //剩下的O都是被包围的，改为X

        //dfs做法
        this.board = board;
        for(int i=0; i<m; i++){
            dfs(i,0);
            dfs(i,n-1);
        }
        for(int j=0; j<n; j++){
            dfs(0, j);
            dfs(m-1, j);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(int x, int y){
        if(x<0 || x>=m || y<0 || y>=n || board[x][y] != 'O'){
            return;
        }
        board[x][y] = 'A';
        for(int i=0; i<4; i++){
            dfs(x+dx[i], y+dy[i]);
        }
    }
}

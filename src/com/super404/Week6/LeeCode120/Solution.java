package com.super404.Week6.LeeCode120;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);
        if(m<=1){
            return dp[0][0];
        }
        for(int i=1; i<m; i++){
            for(int j=0; j<=i; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j]+triangle.get(i).get(j);
                } else if(j==i){
                    dp[i][j] = dp[i-1][j-1]+triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1])+triangle.get(i).get(j);
                }
            }
        }
        int ans=dp[m-1][0];
        for(int i=1; i<m; i++){
            ans = Math.min(dp[m-1][i], ans);
        }
        return ans;
    }
}

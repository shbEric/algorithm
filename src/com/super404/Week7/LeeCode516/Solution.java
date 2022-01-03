package com.super404.Week7.LeeCode516;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        //区间动归
        int n = s.length();
        int[][] dp = new int[n][n]; //dp[i][j]表示从i~j位置字符串中回文子序列的长度
        for(int i=0; i<n; i++){
            dp[i][i] = 1; //一个字母肯定是回文子序列，长度为1
        }
        for(int len=2; len<=n; len++){ //区间长度从2~n
            for(int l=0; l<n-len+1; l++){ //左端点
                int r = l + len -1; //右端点
                if(s.charAt(l) == s.charAt(r)){ //左右端点一致
                    dp[l][r] = dp[l+1][r-1] +2;
                } else { //左右端点不一致，取最大长度的那个
                    dp[l][r] = Math.max(dp[l][r-1], dp[l+1][r]);
                }
            }
        }
        return dp[0][n-1];

    }
}

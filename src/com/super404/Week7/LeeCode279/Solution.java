package com.super404.Week7.LeeCode279;

public class Solution {
    //完全背包问题
    public int numSquares(int n) {
        //构造一个完全平方数数组，因为n<=10000，所以只要长度100的数组就够了
        int[] nums = new int[101];
        for(int i=1; i<=100; i++){
            nums[i] = i*i;
        }
        //dp[j]表示总数为j时用的完全平方数的个数
        int[] dp = new int[n+1];
        dp[0] = 0; //总数0不需要其他数构建
        for(int i=1; i<=n; i++){
            dp[i] = 1000000000; //赋不可能的初值
        }
        for(int i=1; i<=100; i++){
            for(int j=nums[i]; j<=n; j++){
                //dp[i][j]可以从dp[i-1][j]过来，也可以从dp[i][j-nums[i]]过来（这样第i个完全平方数可以用0~无数次）
                dp[j] = Math.min(dp[j], dp[j-nums[i]]+1);
            }
        }

        return dp[n];

    }
}

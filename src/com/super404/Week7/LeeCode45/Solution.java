package com.super404.Week7.LeeCode45;

public class Solution {
    public int jump(int[] nums) {
        //动归
        int n = nums.length;
        int[] dp = new int[n]; //dp[j]表示到达j需要的最少跳跃数
        dp[0] = 0;
        for(int i=1; i<n; i++){
            dp[i] = Integer.MAX_VALUE;//赋不可能的值
            for(int j=0; j<i; j++){
                if(j+nums[j] >= i){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }
}

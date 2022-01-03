package com.super404.Week7.LeeCode55;

public class SolutionDp {
    //动归
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n]; //dp[j]表示j是否可以到达
        dp[0] = true;
        for(int i=0; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(dp[j]==true && j+nums[j] >= i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];

    }
}

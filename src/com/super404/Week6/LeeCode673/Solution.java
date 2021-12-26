package com.super404.Week6.LeeCode673;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        //动归，只要知道之前满足的子序列长度和最后一位的大小
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n]; //记录以nums[i]结尾子序列最大长度情况下的个数
        dp[0] = 1;
        cnt[0] = 1;
        int maxLen=1;
        for(int i=1; i<n; i++){
            dp[i] = 1;//每个数可以以本身开始，初始长度为1
            cnt[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        cnt[i] = cnt[j];//重新开始计数
                    } else if(dp[j]+1 == dp[i]) {
                        cnt[i] += cnt[j]; //长度一致，累加
                    }
                    //长度小的，直接不要
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int ans=0;
        //累加等于最大长度的个数
        for(int i=0; i<n; i++){
            if(dp[i] == maxLen){
                ans += cnt[i];
            }
        }

        return ans;

    }
}

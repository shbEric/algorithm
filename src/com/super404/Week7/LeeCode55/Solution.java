package com.super404.Week7.LeeCode55;

public class Solution {
    public boolean canJump(int[] nums) {
        //贪心
        int n = nums.length;
        int rightMost = 0; //可以到达的最右边的位置
        for(int i=0; i<n; i++){
            if(i<=rightMost){ //当前位置在可以到达的最右边的位置之前，所以当前位置可达到
                rightMost = Math.max(rightMost, i+nums[i]); // 将rightMost更新的更远
            }
            if(rightMost >= n-1){
                return true;
            }
        }
        return false;

    }
}

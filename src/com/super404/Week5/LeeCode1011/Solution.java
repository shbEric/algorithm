package com.super404.Week5.LeeCode1011;

public class Solution {
    private int[] weights;
    public int shipWithinDays(int[] weights, int days) {
        this.weights =weights;
        //二分答案
        //船的最大运载重量
        long left=0, right = 0;
        for(int weight : weights){
            left = Math.max(left,weight);
            right += weight;
        }
        while(left<right){
            long mid = (left+right)>>1;
            if(cal(mid, days)){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return (int)left;
    }

    public boolean cal(long speed, int days){
        int ans=0;
        int sum=0;
        for(int i=0; i<weights.length; i++){
            sum += weights[i];
            if(sum>speed){
                sum = weights[i];
                ans++;
            }
        }
        //最后一次没有统计进来
        ans++;
        return ans<=days;
    }
}

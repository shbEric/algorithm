package com.super404.Week5.LeeCode875;

public class Solution {
    int[] piles;
    public int minEatingSpeed(int[] piles, int h) {
        //二分答案
        this.piles = piles;
        //最慢:1根/小时
        //最快:每堆中的最大值
        int left = 1;
        int right = 0;
        for(int pile : piles){
            right = Math.max(right, pile);
        }
        while(left<right){
            int mid = left+(right-left)/2;
            if(cal(mid,h)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //统计以speed速度吃，可以吃完吗
    public boolean cal(int speed, int h){
        int ans = 0;
        for(int pile : piles){
            ans += (pile/speed + (pile%speed>0 ? 1:0));
            if(ans > h){
                return false;
            }
        }
        return true;
    }
}

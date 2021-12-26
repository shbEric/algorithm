package com.super404.Week6.LeeCode70;

public class Solution {
    public int climbStairs(int n) {
        //到第x阶，可以1步或者2步
        //f(x) = f(x-1) + f(x-2)
        //优化空间
        int p = 1; //f(x-2)
        int q = 1; //f(x-1)
        int r = 1; //f(x)
        if(n<=1){
            return r;
        }
        for(int i=2; i<=n; i++){
            r = p + q;
            p=q;
            q=r;
        }
        return r;

    }
}

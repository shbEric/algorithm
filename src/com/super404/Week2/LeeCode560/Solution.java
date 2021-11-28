package com.super404.Week2.LeeCode560;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        //前缀和+hash
        //前缀和sum[right] - sum[left-1] = k;说明sum[left-1] = sum[right] - k
        int ans=0;
        int n = nums.length;
        int[] sum = new int[n+1];
        sum[0] = 0;
        //记录前缀和的值出现的次数，即sum[right] - k出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum[0],1);

        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1]+nums[i-1];
            ans += map.getOrDefault(sum[i]-k,0);
            map.put(sum[i], map.getOrDefault(sum[i],0)+1);
        }

        return ans;

    }
}

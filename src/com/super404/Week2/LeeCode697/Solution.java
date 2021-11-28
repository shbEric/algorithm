package com.super404.Week2.LeeCode697;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        int minLength=0; //最小长度（结果）
        int maxNum=0; //最多数量
        //度最大的子数组，必然包含度最大的数；用map记录该信息
        //key为nums[i]
        //value为数组,第一位记录出现次数，第二位记录首次出现位置，第三位记录最后出现位置
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2]=i;
            } else {
                map.put(nums[i], new int[] {1,i,i});
            }
        }
        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            int[] arr = entry.getValue();
            //先比较度，取度大的
            if(maxNum < arr[0]){
                minLength = arr[2] - arr[1] +1;
                maxNum = arr[0];
            } else if(maxNum == arr[0]){
                //度一样，取长度短的
                minLength = Math.min(minLength, arr[2] - arr[1] +1);
            }
        }



        return minLength;

    }
}

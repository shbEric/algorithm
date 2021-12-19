package com.super404.Week5.LeeCode154;

public class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right)>>1;
            if(nums[mid] < nums[right]){
                //必然在[left,mid]
                right = mid;
            } else if(nums[mid] > nums[right]){
                //必然在[mid+1,right]
                left = mid+1;
            } else {
                //nums[mid] == nums[right]的情况，没法判断取左边还是右边
                //因为这个值mid已经有了，可以right--
                right--;
            }
        }
        return nums[right];
    }
}

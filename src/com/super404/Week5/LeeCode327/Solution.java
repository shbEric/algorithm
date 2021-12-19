package com.super404.Week5.LeeCode327;

public class Solution {
    private int lower=0, upper=0;
    private int ans = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        //先求前缀和数组
        int n = nums.length;
        long sums[] = new long[n+1];
        for(int i=0; i<n; i++){
            sums[i+1] = sums[i] + nums[i];
        }
        mergeSort(sums, 0, n);
        return ans;
    }

    public void mergeSort(long[] arr, int l, int r){
        if(l>=r) return;
        int mid = (l+r)>>1;
        mergeSort(arr, l, mid);
        mergeSort(arr,mid+1, r);
        //统计左边内部的数量+右边内部的数量+左右跨区的数量
        //因为最后会分为每个数一组，前缀和只有一个数没有用，可以不考虑
        //所有只要算跨区的即可,区域内的已经在之前的分治中统计好了
        cal(arr, l, mid, r);
        merge(arr, l, mid, r);
    }

    public void cal(long[] arr, int left, int mid, int right){
        //左边[left,mid]，右边[mid+1,right]
        //只要算跨区的即可,区域内的已经在之前的分治中统计好了
        //所以起始点要<=mid，结束点要>mid
        int l = mid+1;
        int r = mid+1;
        for(int i=left; i<=mid; i++){
            while(l<=right && arr[l] - arr[i] < lower){
                l++;
            }//第一个满足条件的l
            while(r<=right && arr[r] - arr[i] <= upper){
                r++;
            }//第一个不满足条件的r
            ans += (r-l);
        }
    }

    public void merge(long[] arr, int l, int mid, int r){
        long[] tmp = new long[r-l+1]; //中间数组，用于记录
        int i=l, j=mid+1, k=0;
        while(i<=mid && j<=r){
            if(arr[i]<=arr[j]){
                tmp[k] = arr[i];
                k++;
                i++;
            } else {
                tmp[k] = arr[j];
                k++;
                j++;
            }
        }
        while(i<=mid){
            tmp[k] = arr[i];
            k++;
            i++;
        }
        while(j<=r){
            tmp[k] = arr[j];
            k++;
            j++;
        }
        System.arraycopy(tmp, 0, arr, l , tmp.length);
    }
}

package com.super404.Week5.LeeCode74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left=0, right= m*n-1;
        while(left<=right){
            int mid = (left+right)>>1;
            //二维数组可以用一维表示 i*n+j
            if(matrix[mid/n][mid%n] == target){
                return true;
            } else if(matrix[mid/n][mid%n] < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}

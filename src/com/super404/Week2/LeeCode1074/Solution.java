package com.super404.Week2.LeeCode1074;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //本来要遍历上下左右边界，共四次，现在只遍历上下右，利用hash，O(1)的找到左边界
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] sum = new int[row+1][col+1];
        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] -sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        int ans=0;
        for(int top=1; top<=row; top++){
            for(int bot=top; bot<=row; bot++){
                int current=0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0,1);
                for(int right=1; right<=col; right++){
                    current = sum[bot][right] - sum[top-1][right];
                    ans += map.getOrDefault((current-target),0);
                    map.put(current, map.getOrDefault(current,0)+1);

                }
            }
        }
        return ans;

    }
}

package com.super404.Week7.LeeCode124;

public class SolutionBetter {
    //可以优化空间，因为当前节点只和它的左右节点有关，不需要全部记录下来
    int ans = -1000000000;
    public int maxPathSum(TreeNode root) {
        //树形动态规划
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if(root == null) {
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        //当前节点的值直接加上，因为如果不要当前节点，其父节点对当前节点只能取0；如果加上当前节点为负数，其父节点最终还是对当前节点取0；所以统一加上当前节点，还能处理只有一个点情况
        int rootSum = root.val + Math.max(leftSum, 0) + Math.max(rightSum, 0);
        ans = Math.max(ans, rootSum);
        //左右只能取一个最大的，不然root就在路径中重复出现两次了
        return root.val + Math.max(Math.max(leftSum, 0), Math.max(rightSum, 0));

    }
}
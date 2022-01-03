package com.super404.Week7.LeeCode124;

import java.util.HashMap;

public class Solution {
    //这里int[0]表示这个点没有纳入路径，int[1]表示这个点纳入路径
    private HashMap<TreeNode, int[]> dp = new HashMap<>();
    int ans = -1000000000;
    public int maxPathSum(TreeNode root) {
        //树形动态规划
        dp.put(null, new int[]{-1000000000,-1000000000}); //对于空的节点，直接赋不可能的初始值
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if(root == null) {
            return;
        }
        dp.put(root, new int[2]);
        dfs(root.left);
        dfs(root.right);
        //这个点不纳入路径，子节点在不在路径都没关系，取最大值即可
        dp.get(root)[0] =
                Math.max(Math.max(dp.get(root.left)[0],dp.get(root.left)[1]),
                        Math.max(dp.get(root.right)[0],dp.get(root.right)[1]));
        //这个点纳入路径，子节点必须在路径中才行, 当前子树最大值为根、根+左、根+右、根+左+右取最大值即可
        dp.get(root)[1] =
                Math.max(dp.get(root.left)[1] + dp.get(root.right)[1] + root.val,
                        Math.max(Math.max(dp.get(root.left)[1] + root.val,
                                dp.get(root.right)[1] + root.val), root.val));
        ans = Math.max(ans, Math.max(dp.get(root)[0], dp.get(root)[1]));

        //这个点纳入路径，子节点必须在路径中才行, 由于当前子树要被父节点用，根+左+右会导致重复，所以只能从根、根+左、根+右取最大值即可
        dp.get(root)[1] =
                Math.max(Math.max(dp.get(root.left)[1] + root.val,
                        dp.get(root.right)[1] + root.val), root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

package com.super404.Week4.LeeCode538;

public class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        //二叉搜索树反中序遍历
        //累加前面的值即可
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
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

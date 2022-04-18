package com.leetcode.DailyChallenge._2021_10;

import java.util.Arrays;

public class _17_230二叉搜索树中第K小的元素 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
    int N = 10010;
    int[] a = new int[N];
    int idx = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        Arrays.sort(a, 0, idx);
        return a[k - 1];
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        a[idx++] = root.val;
        dfs(root.right);
    }
}

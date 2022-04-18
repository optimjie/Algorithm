package com.leetcode.problem._671二叉树中第二小的节点;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public class TreeNode {
        TreeNode left, right;
        int val;
    }
    public List<Integer> l = new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        Collections.sort(l);
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) > l.get(0)) {
                return l.get(i);
            }
        }
        return -1;
    }
    public void dfs(TreeNode r) {
        if (r == null) return;
        dfs(r.left);
        l.add(r.val);
        dfs(r.right);
    }
}

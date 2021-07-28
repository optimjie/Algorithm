package com.leetcode.problem._863二叉树中所有距离为K的结点;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left, right;
    }

    Map<TreeNode, List<TreeNode>> g = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    public void dfs(TreeNode root) { // 建邻接表
        if (root == null) return;
        if (root.left != null) {
            List<TreeNode> l1 = g.getOrDefault(root, new ArrayList<>());
            l1.add(root.left);
            g.put(root, l1);
            List<TreeNode> l2 = g.getOrDefault(root.left, new ArrayList<>());
            l2.add(root);
            g.put(root.left, l2);
            dfs(root.left);
        }
        if (root.right != null) {
            List<TreeNode> l1 = g.getOrDefault(root, new ArrayList<>());
            l1.add(root.right);
            g.put(root, l1);
            List<TreeNode> l2 = g.getOrDefault(root.right, new ArrayList<>());
            l2.add(root);
            g.put(root.right, l2);
            dfs(root.right);
        }
    }

    public void dfs1(TreeNode root, TreeNode fa, int k) {
        if (k == 0) ans.add(root.val);
        else {
            List<TreeNode> l = g.getOrDefault(root, new ArrayList<>());
            for (int i = 0; i < l.size(); i++) {
                TreeNode t = l.get(i);
                if (t == fa) continue;
                dfs1(t, root, k - 1);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root);
        dfs1(target, null, k);
        return ans;
    }

}

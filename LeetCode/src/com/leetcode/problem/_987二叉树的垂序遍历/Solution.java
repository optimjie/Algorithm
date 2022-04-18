package com.leetcode.problem._987二叉树的垂序遍历;

import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>((a, b) -> a - b);
        map.put(3, 1);
        map.put(2, 2);
        for (Map.Entry<Integer, Integer> v : map.entrySet()) {
            System.out.println(v.getKey() + " " + v.getValue());
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     就是要用三个关键字进行排序。先按照y，再按照，x最后按照val。
     用一个map去存每一个结点的这三个变量:y->[x, val],
     使用TreeMap先将key也就是这里的y进行排序，然后将value也就是这里的[x, val]
     进行自定义排序即可。
     */

    public void dfs(TreeNode root, int x, int y) {
        if (root == null) return;
        List<int[]> l = map.getOrDefault(y, new ArrayList<>());
        l.add(new int[]{x, root.val});
        map.put(y, l);
        dfs(root.left, x + 1, y - 1);
        dfs(root.right, x + 1, y + 1);
    }

    Map<Integer, List<int[]>> map = new TreeMap<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        for (Map.Entry<Integer, List<int[]>> v : map.entrySet()) {
            List<int[]> l = v.getValue();
            Collections.sort(l, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) return o1[1] - o2[1];
                    return o1[0] - o2[0];
                }
            });
            List<Integer> t = new ArrayList<>();
            for (int[] i : l) {
                t.add(i[1]);
            }
            ans.add(t);
        }
        return ans;
    }
}

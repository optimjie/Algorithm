package com.leetcode.DailyChallenge._2021_9;

import java.util.ArrayList;
import java.util.List;

public class _09_68文本左右对齐 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int l = 0; l < n; ) {
            int len = words[l].length() + 1, r = l + 1;
            while (r < n && len + words[r].length() + 1 <= maxWidth + 1) {
                len += words[r].length() + 1;
                r++;
            }
            if (r == n) { // 特判最后一行
                StringBuilder t = new StringBuilder("");
                for (int i = l; i < r; i++) {
                    t.append(words[i]);
                    if (i != r - 1) t.append(" ");
                }
                int kk = maxWidth - t.length();
                while (kk-- > 0) {
                    t.append(" ");
                }
                ans.add(t.toString());
                break;
            }
            int cnt = r - l; // 字符串数量
            int len1 = 0;
            for (int i = l; i < r; i++) len1 += words[i].length();
            int sub = maxWidth - len1;
            int[] blankNo = new int[cnt - 1];
            if (cnt == 1) { // 特判一行只有一个单词的情况
                StringBuilder t = new StringBuilder(words[l]);
                int kk = maxWidth - words[l].length();
                while (kk-- > 0) {
                    t.append(" ");
                }
                ans.add(t.toString());
            } else {
                calculateBlank(blankNo, sub, cnt - 1);
                StringBuilder t = new StringBuilder("");
                for (int i = l, j = 0; i < r; i++, j++) {
                    t.append(words[i]);
                    if (i != r - 1) {
                        int sum = blankNo[j];
                        while (sum -- > 0) {
                            t.append(" ");
                        }
                    }
                }
                ans.add(t.toString());
            }
            l = r;
        }
        return ans;
    }
    public void calculateBlank(int[] blankNo, int sub, int cnt) { // 计算空格
        if (sub % cnt == 0) {
            for (int i = 0; i < cnt; i++) blankNo[i] = sub / cnt;
        } else {
            int t = sub / cnt;
            for (int i = 0; i < cnt; i++) blankNo[i] = t;
            int k = sub - t * cnt;
            int u = 0;
            while (k-- > 0) {
                if (u == cnt) u = 0;
                blankNo[u]++;
                u++;
            }
        }
    }
}

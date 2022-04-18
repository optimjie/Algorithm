package com.leetcode.DailyChallenge._2021_10;

import com.leetcode.problem._981基于时间的键值存储.TimeMapSummary;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _09_352将数据流变为多个不相交区间 {

    final int N = 10010;
    Boolean[] state = new Boolean[N];
    int idx = -1;
    int[] st = new int[N];
    int[] ed = new int[N];

    Pair<Integer, Integer>[] m = new Pair[N];

    public _09_352将数据流变为多个不相交区间() {
        for (int i = 0; i < N; i++) {
            st[i] = -1;
            ed[i] = -1;
        }
    }

    public void addNum(int val) {
        int l = 0, r = idx;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (st[mid] <= val) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (st[l] > val) {
            if (val == st[l] - 1) {
                st[l]--;
            } else {
                idx++;
                st[idx] = val;
                ed[idx] = val;
            }
        } else if (st[l] < val) {
            if (ed[l] >= val) {
                // 不用操作
            } else {
                if (val == ed[l] + 1) {
                    ed[l]++;
                    if (l < idx && st[l + 1] == val + 1) {
                        ed[l] = ed[l + 1];
                        st[l + 1] = -1;
                        ed[l + 1] = -1;
                    }
                } else { // 已经多出来了
                    if (l == idx) {
                        idx++;
                        st[idx] = val;
                        ed[idx] = val;
                    } else {
                        if (val == st[l + 1] - 1) {
                            st[l + 1]--;
                        } else {
                            idx++;
                            st[idx] = val;
                            ed[idx] = val;
                        }
                    }
                }
            }
        }
        for (int i = 0; i <= idx; i++) {
            m[i] = new Pair<Integer, Integer>(st[i], ed[i]);
        }
        Arrays.sort(m);
    }

    public int[][] getIntervals() {
        int cnt = 0;
        for (int i = 0; i <= idx; i++) if (st[i] != - 1) cnt++;
        int[][] ans = new int[cnt][2];
        for (int i = 0, k = 0; i <= idx; i++) {
            if (st[i] != -1) {
                ans[k][0] = st[i];
                ans[k][1] = ed[i];
                k++;
            }
        }
        return ans;
    }
}

package com.leetcode.DailyChallenge._2021_10;

import java.util.*;

public class _16_282给表达式添加运算符 {
    int n;
    Stack<Character> stk = new Stack<>();
    String s = "";
    List<String> ans = new ArrayList<>();
    int target;
    char[] ch = new char[]{'+', '-', '*'};

    public List<String> addOperators(String num, int _target) {
        n = num.length();
        target = _target;
        dfs(num, 0);
        return ans;
    }

    public void dfs(String num, int u) {
        if (u == n) {
            s = "";
            Iterator<Character> it = stk.iterator();
            while (it.hasNext()) {
                char c = it.next();
                s = s + c;
            }
            if (!containsZero(s) && check(s)) {
                ans.add(s);
            }
            return;
        }
        if (u == 0) {
            stk.push(num.charAt(u));
            dfs(num, u + 1);
        } else {
            // 不加运算符
            stk.push(num.charAt(u));
            dfs(num, u + 1);
            stk.pop();
            // 加运算符
            for (int i = 0; i < 3; i++) {
                stk.push(ch[i]);
                stk.push(num.charAt(u));
                dfs(num, u + 1);
                stk.pop();
                stk.pop();
            }
        }
    }

    public boolean containsZero(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) continue;
            // 遇到数字了
            int j = i;
            while (j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                j++;
            }
            if (s.charAt(i) == '0' && j - i > 1) return true;
            i = j - 1;
        }
        return false;
    }

    public int getPri(char c) {
        if (c == '*') return 2;
        return 1;
    }

    public long cal(long a, long b, char t) {
        if (t == '+') return a + b;
        if (t == '-') return a - b;
        return a * b;
    }

    public boolean check(String num) {
        Stack<Long> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            if (num.charAt(i) >= '0' && num.charAt(i) <= '9') {
                int j = i;
                long a = 0;
                while (j < len && num.charAt(j) >= '0' && num.charAt(j) <= '9') {
                    int t = num.charAt(j) - '0';
                    a = a * 10 + t;
                    j++;
                }
                s1.push(a);
                i = j - 1;
            } else {
                char t = num.charAt(i); // 运算符
                if (s2.empty()) {
                    s2.push(t);
                } else {
                    char top = s2.peek();
                    if (getPri(top) < getPri(t)) {
                        s2.push(t);
                    } else {
                        while (!s2.empty() && getPri(s2.peek()) >= getPri(t)) {
                            long b = s1.pop();
                            long a = s1.pop();
                            char tt = s2.pop();
                            long ans = cal(a, b, tt);
                            s1.push(ans);
                        }
                        s2.push(t);
                    }
                }
            }
        }
        while (!s2.empty()) {
            long b = s1.pop();
            long a = s1.pop();
            char t = s2.pop();
            s1.push(cal(a, b, t));
        }
        return s1.peek() == target;
    }
}

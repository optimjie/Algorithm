package com.leetcode.DailyChallenge._2022_5;

import java.util.Stack;

public class _02_591标签验证器 {
    public static void main(String[] args) {
        System.out.println(isValid("<A></A>"));
    }
    public static boolean isValid(String code) {
        Stack<String> stk = new Stack<>();
        int n = code.length();
        if (n == 0) return true;
        // 先特判最外面是不是一个TAG_NAME标签
        if (!check(code)) return false;
        int right = 0;
        for (int i = 0; i < n;) {
            if (code.charAt(i) == '<') {
                if (!stk.empty() && stk.peek().equals("CONTENT")) {  // TAG_CONTENT的内容
                    while (i + 3 <= n && !code.substring(i, i + 3).equals("]]>")) i++;
                    if (i + 3 == n + 1) return false;
                    stk.pop();
                    i += 3;
                    right = i;
                } else if (i + 9 <= n && code.substring(i, i + 9).equals("<![CDATA[")) {  // TAG_CONTENT
                    stk.push("CONTENT");
                    i += 9;
                    while (i + 3 < n && !code.substring(i, i + 3).equals("]]>")) i++;
                    if (i + 3 == n) return false;
                    i += 3;
                    right = i;
                    stk.pop();
                } else {  // TAG_NAME
                    if (i + 1 < n && code.charAt(i + 1) == '/') i++;
                    else {
                        int len = 1, j = 0;
                        while (len <= 9) {
                            j = i + len + 1;
                            if (code.charAt(j) == '>') break;
                            len++;
                        }
                        if (len > 9) return false;
                        for (int u = i + 1; u < j; u++) {
                            if (!(code.charAt(u) >= 'A' && code.charAt(u) <= 'Z')) return false;
                        }
                        stk.push(code.substring(i + 1, j));
                        i = j + 1;
                    }
                }
            } else if (code.charAt(i) == '>') {
                if (!stk.empty() && !stk.peek().equals("CONTENT")) {
                    if (i == 0) return false;
                    String name = stk.peek();
                    int len = name.length();
                    int j = i - 1;
                    while (j >= right && !code.substring(j, j + 2).equals("</")) j--;
                    if (j < right) i++;
                    else {
                        if (!code.substring(j + 2, i).equals(name)) return false;
                        stk.pop();
                        i++;
                        right = i;
                    }
                } else if (stk.empty()){
                    return false;
                }
            } else {
                i++;
            }
        }
        return stk.empty();
    }
    public static boolean check(String code) {
        int n = code.length();
        if (code.charAt(0) != '<') return false;
        int len = 1;
        while (len < n && len <= 9) {
            if (code.charAt(len) == '>') break;
            len++;
        }
        if (len == n || len > 9) return false;
        for (int i = 1; i < len; i++) {
            if (!(code.charAt(i) >= 'A' && code.charAt(i) <= 'Z')) return false;
        }
        if (code.charAt(n - 1) != '>') return false;
        String name = code.substring(1, len);
        len = name.length();
        if (n - 1 - len - 2 <= len || !code.substring(n - 1 - len - 2, n - 1).equals("</" + name)) return false;
        return true;
    }
}

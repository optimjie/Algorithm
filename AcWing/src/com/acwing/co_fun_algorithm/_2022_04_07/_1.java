package com.acwing.co_fun_algorithm._2022_04_07;

import java.io.*;
import java.util.*;

public class _1 {
    static int N = (int)2e5 + 10;
    static int l, m, n;
    static int[] lan = new int[N];
    static int[] co = new int[N];
    static Map<Integer, Integer> mp = new HashMap<>();  // 记录了每一种语言有多少人知道。
    static class Node {
        int a, b;
        Node(int _a, int _b) {
            a = _a;
            b = _b;
        }
    }
    static Node[] nodes = new Node[N];
    public static void solve() throws IOException {
        l = nextInt(); m = nextInt(); n = nextInt();
        for (int i = 0; i < l; i++) lan[i] = nextInt();
        for (int i = 0; i < m; i++) co[i] = nextInt();
        for (int i = 0; i < n; i++) {
            int x = nextInt(), y = nextInt();
            nodes[i] = new Node(x, y);
        }
        Arrays.sort(lan, 0, l);
        for (int v : lan) mp.put(v, 0);
        for (int v : co) {
            int x = 0, y = l - 1;
            while (x < y) {
                int mid = x + y + 1 >> 1;
                if (lan[mid] > v) y = mid - 1;
                else x = mid;
            }
            if (lan[x] == v) {
                mp.put(lan[x], mp.getOrDefault(lan[x], 0) + 1);
                if (x > 0) mp.put(lan[x - 1], mp.getOrDefault(lan[x - 1], 0) + 1);
                if (x < l - 1) mp.put(lan[x + 1], mp.getOrDefault(lan[x + 1], 0) + 1);
            }
        }
        Arrays.sort(nodes, 0, n, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (mp.get(o1.a) == mp.get(o2.a)) return mp.get(o2.b) - mp.get(o1.b);
                return mp.get(o2.a) - mp.get(o1.a);
            }
        });
        out.println(mp.get(nodes[0].a) + " " + mp.get(nodes[0].b));
        out.flush();
    }

    static int TT = 1;
    public static void main(String[] args) throws IOException { while (TT-- > 0) solve(); }
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // 这个类有些问题，解决方案：https://tothefor.com/DragonOne/ff2ca664.html and https://blog.csdn.net/m0_56052256/article/details/121193785
    // 总结：读纯数字与纯大小写的字符串时用，其他的用BufferedReader即可。
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    public static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    public static String next() throws IOException { in.nextToken(); return (String) in.sval; }
    public static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
}

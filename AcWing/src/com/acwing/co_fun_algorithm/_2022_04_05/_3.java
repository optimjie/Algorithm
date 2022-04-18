package com.acwing.co_fun_algorithm._2022_04_05;

import java.io.*;

public class _3 {

    static int N = 510;
    static int n, m;
    static int[][] a = new int[N][N];
    static boolean[][] vis = new boolean[N][N];

    public static void main(String[] args) throws IOException {

        n = nextInt(); m = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = nextInt();
            }
        }
        int x = 1, y = 0;
        int dx[] = new int[]{0, 1, 0, -1};
        int dy[] = new int[]{1, 0, -1, 0};
        int cnt = 0, d = 0;  // d代表方向
        while (cnt < n * m) {
            cnt++;
            int xx = x + dx[d], yy = y + dy[d];
            if (xx < 1 || xx > n || yy < 1 || yy > m || vis[xx][yy]) {
                d = (d + 1) % 4;
                xx = x + dx[d];
                yy = y + dy[d];
            }
            vis[xx][yy] = true;
            out.print(a[xx][yy] + " ");
            x = xx;
            y = yy;

        }
        out.flush();

    }








    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /*String[] str = reader.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int m = Integer.parseInt(str[1]);*/

    // 使用这个在读数字与字符的字符串时会有问题
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    public static String next() throws IOException {
        in.nextToken();
        return (String) in.sval;
    }

    public static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }
}

package com.leetcode.contest._d058;

public class _2检查操作是否合法 {
    public boolean checkMove(char[][] board, int x, int y, char color) {
        board[x][y] = color;
        int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        char[] t = new char[20];
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int k = 0;
            t[k++] = board[x][y];
            for (int xx = x + dx[i], yy = y + dy[i]; ; xx += dx[i], yy += dy[i]) {
                if (xx < 0 || xx >= 8 || yy < 0 || yy >= 8) break;
                if (board[xx][yy] == '.') break;
                t[k++] = board[xx][yy];
            }
            int idx = 1;
            while (idx < k && t[idx] != t[0]) idx++;
            if (idx < k) {
                boolean flag = true;
                for (int j = 1; j < idx; j++) if (t[j] == t[0]) flag = false;
                if (idx >= 2 && flag) {
                    cnt++;
                }
            }
        }
        return cnt >= 1;
    }
}

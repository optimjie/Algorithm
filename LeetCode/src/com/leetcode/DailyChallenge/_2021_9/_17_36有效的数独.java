package com.leetcode.DailyChallenge._2021_9;

public class _17_36有效的数独 {
    boolean[][] r = new boolean[9][9];
    boolean[][] c = new boolean[9][9];
    boolean[][] k = new boolean[9][9];
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0' - 1;
                if (r[i][num]) return false;
                r[i][num] = true;
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                int num = board[j][i] - '0' - 1;
                if (c[i][num]) return false;
                c[i][num] = true;
            }
        }
        int idx = -1;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) { // i j 代表左上角的点
                idx++;
                int cnt = 9;
                int u = i, v = j;
                while (cnt-- > 0) {
                    if (board[u][v] != '.') {
                        int num = board[u][v] - '0' - 1;
                        if (k[idx][num]) return false;
                        k[idx][num] = true;
                    }
                    v++;
                    if (v - j == 3) {
                        u++;
                        v = j;
                    }
                }
            }
        }
        return true;
    }
}

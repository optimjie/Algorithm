package com.leetcode.DailyChallenge._2021_12;

import java.util.ArrayList;
import java.util.List;

public class _09_794有效的井字游戏 {

    List<int[]> l = new ArrayList<>();
    int len = 0;
    boolean[] st;
    char[][] b = new char[3][3];
    String[] board;
    boolean ans = false;

    public boolean validTicTacToe(String[] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) != ' ') {
                    l.add(new int[]{i, j});
                }
            }
        }
        len = l.size();
        st = new boolean[len + 1];
        this.board = board;
        dfs(1);
        return ans;
    }

    public void dfs(int u) {
        if (u > len) {
            ans = true;
            return;
        }
        char choose = 'X';
        if (u % 2 == 0) choose = 'O';

        for (int i = 0; i < len; i++) {
            int ii = l.get(i)[0], jj = l.get(i)[1];
            if (board[ii].charAt(jj) == choose && !st[i]) {
                b[ii][jj] = choose;
                if (check() && u < len) {
                    b[ii][jj] = ' ';
                    continue;
                }
                st[i] = true;
                dfs(u + 1);
                b[ii][jj] = ' ';
                st[i] = false;
            }
        }
    }

    public boolean check() {
        for (int i = 0; i < 3; i++) {
            int x1 = 0, o1 = 0;
            int x2 = 0, o2 = 0;
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == 'X') x1++;
                if (b[i][j] == 'O') o1++;
                if (b[j][i] == 'X') x2++;
                if (b[j][i] == 'O') o2++;
            }
            if (x1 == 3 || x2 == 3 || o1 == 3 || o2 == 3) {
                return true;
            }
        }
        int x = 0, o = 0;
        for (int i = 0; i < 3; i++) {
            if (b[i][i] == 'X') x++;
            if (b[i][i] == 'O') o++;
        }
        if (x == 3 || o == 3) return true;
        x = 0;
        o = 0;
        for (int i = 0; i < 3; i++) {
            int j = 2 - i;
            if (b[i][j] == 'X') x++;
            if (b[i][j] == 'O') o++;
        }
        if (x == 3 || o == 3) return true;
        return false;
    }
}

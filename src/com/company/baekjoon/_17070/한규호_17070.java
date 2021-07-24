package com.company.baekjoon._17070;

import java.io.*;

public class 한규호_17070 {
    static int result = 0;
    static int[][] map;
    static int n;

    static final int vertical = 1; // 수직
    static final int horizontal = 2; // 수평
    static final int diagonal = 3; // 대각선
    static int position;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        dfs(0, 0, 0, 1);
        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }

    public static void dfs(int rearX, int rearY, int frontX, int frontY) {
        if (frontX == n - 1 && frontY == n - 1) {
            result++;
            return;
        }
        position = getPosition(rearX, rearY, frontX, frontY);
        switch (position) {
            case horizontal:
                if (checkHorizontal(frontX, frontY)) {
                    dfs(frontX, frontY, frontX, frontY + 1);
                }
                if (checkDiagonal(frontX, frontY)) {
                    dfs(frontX, frontY, frontX + 1, frontY + 1);
                }
                break;
            case vertical:
                if (checkVertical(frontX, frontY)) {
                    dfs(frontX, frontY, frontX + 1, frontY);
                }
                if (checkDiagonal(frontX, frontY)) {
                    dfs(frontX, frontY, frontX + 1, frontY + 1);
                }
                break;
            case diagonal:
                if (checkHorizontal(frontX, frontY)) {
                    dfs(frontX, frontY, frontX, frontY + 1);
                }
                if (checkVertical(frontX, frontY)) {
                    dfs(frontX, frontY, frontX + 1, frontY);
                }
                if (checkDiagonal(frontX, frontY)) {
                    dfs(frontX, frontY, frontX + 1, frontY + 1);
                }
                break;
            default:
                break;
        }
    }

    public static int getPosition(int rearX, int rearY, int frontX, int frontY) {
        if (frontX == rearX && frontY - 1 == rearY) {
            return horizontal;
        }
        else if (frontY == rearY && frontX - 1 == rearX) {
            return vertical;
        }
        else {
            return diagonal;
        }
    }

    public static boolean checkHorizontal(int frontX, int frontY) {
        if (frontY + 1 < n) {
            return map[frontX][frontY + 1] != 1;
        }
        return false;
    }

    public static boolean checkVertical(int frontX, int frontY) {
        if (frontX + 1 < n) {
            return map[frontX + 1][frontY] != 1;
        }
        return false;
    }

    public static boolean checkDiagonal(int frontX, int frontY) {
        if (frontY + 1 < n && frontX + 1 < n) {
            return map[frontX][frontY + 1] != 1 && map[frontX + 1][frontY + 1] != 1 && map[frontX + 1][frontY] != 1;
        }
        return false;
    }
}

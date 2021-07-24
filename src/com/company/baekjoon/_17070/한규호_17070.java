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

    public static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Pipe {
        Location front; // 파이프 앞쪽 좌표
        Location rear; // 파이프 뒷쪽 좌표

        public Pipe(Location rear, Location front) {
            this.front = front;
            this.rear = rear;
        }
    }

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
        Pipe p = new Pipe(new Location(0, 0), new Location(0, 1));
        dfs(p);

        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }

    public static void dfs(Pipe p) {
        if (p.front.x == n - 1 && p.front.y == n - 1) {
            result++;
            return;
        }
        position = getPosition(p);
        switch (position) {
            case horizontal:
                if (checkHorizontal(p)) {
                    dfs(new Pipe(new Location(p.front.x, p.front.y), new Location(p.front.x, p.front.y + 1)));
                }
                if (checkDiagonal(p)) {
                    dfs(new Pipe(new Location(p.front.x, p.front.y), new Location(p.front.x + 1, p.front.y + 1)));
                }
                break;
            case vertical:
                if (checkVertical(p)) {
                    dfs(new Pipe(new Location(p.front.x, p.front.y), new Location(p.front.x + 1, p.front.y)));
                }
                if (checkDiagonal(p)) {
                    dfs(new Pipe(new Location(p.front.x, p.front.y), new Location(p.front.x + 1, p.front.y + 1)));
                }
                break;
            case diagonal:
                if (checkHorizontal(p)) {
                    dfs(new Pipe(new Location(p.front.x, p.front.y), new Location(p.front.x, p.front.y + 1)));
                }
                if (checkVertical(p)) {
                    dfs(new Pipe(new Location(p.front.x, p.front.y), new Location(p.front.x + 1, p.front.y)));
                }
                if (checkDiagonal(p)) {
                    dfs(new Pipe(new Location(p.front.x, p.front.y), new Location(p.front.x + 1, p.front.y + 1)));
                }
                break;
            default:
                break;
        }
    }

    public static int getPosition(Pipe p) {
        if (p.front.x == p.rear.x && p.front.y - 1 == p.rear.y) {
            return horizontal;
        }
        else if (p.front.y == p.rear.y && p.front.x - 1 == p.rear.x) {
            return vertical;
        }
        else {
            return diagonal;
        }
    }

    public static boolean checkHorizontal(Pipe p) {
        if (p.front.y + 1 <= n - 1) {
            return map[p.front.x][p.front.y + 1] != 1;
        }
        return false;
    }

    public static boolean checkVertical(Pipe p) {
        if (p.front.x + 1 <= n - 1) {
            return map[p.front.x + 1][p.front.y] != 1;
        }
        return false;
    }

    public static boolean checkDiagonal(Pipe p) {
        if (p.front.y + 1 <= n - 1
                && p.front.x + 1 <= n - 1
        ) {
            return map[p.front.x][p.front.y + 1] != 1
                    && map[p.front.x + 1][p.front.y + 1] != 1
                    && map[p.front.x + 1][p.front.y] != 1;
        }
        return false;
    }
}

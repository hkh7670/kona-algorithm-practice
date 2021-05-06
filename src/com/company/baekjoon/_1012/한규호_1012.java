package com.company.baekjoon._1012;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 한규호_1012 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int order = 0;
    static int m;
    static int n;
    static List<Integer> answers = new ArrayList<>();
    static List<int[][]> tables = new ArrayList<>();
    static List<boolean[][]> visitedList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] table = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                int y = scanner.nextInt();
                int x = scanner.nextInt();
                table[x][y] = 1;
            }
            tables.add(table);
            visitedList.add(visited);
        }


        for (int i = 0; i < testCase; i++) {
            int answer = 0;
            m = tables.get(order)[0].length;
            n = tables.get(order).length;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (tables.get(order)[x][y] == 1 && !visitedList.get(order)[x][y]) {
                        dfs(x, y);
                        answer++;
                    }
                }
            }
            answers.add(answer);
            order++;
        }
        for (int answer : answers) {
            System.out.println(answer);
        }
        scanner.close();
    }

    static void dfs(int x, int y) {
        visitedList.get(order)[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
                if (tables.get(order)[nx][ny] == 1 && !visitedList.get(order)[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}

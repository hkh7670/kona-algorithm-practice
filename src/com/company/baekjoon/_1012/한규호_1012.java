package com.company.baekjoon._1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 한규호_1012 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m;
    static int n;
    static int idx;
    static List<int[][]> tables = new ArrayList<>();
    static List<boolean[][]> visitedList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String space = " ";
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] mnk = br.readLine().split(space);
            int m = Integer.parseInt(mnk[0]);
            int n = Integer.parseInt(mnk[1]);
            int k = Integer.parseInt(mnk[2]);
            int[][] table = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                String[] yx = br.readLine().split(space);
                int y = Integer.parseInt(yx[0]);
                int x = Integer.parseInt(yx[1]);
                table[x][y] = 1; // 배추는 1로 표시
            }
            tables.add(table);
            visitedList.add(visited);
        }

        for (idx = 0; idx < testCase; idx++) {
            int answer = 0;
            m = tables.get(idx)[0].length; // 테스트 케이스 농장의 가로길이
            n = tables.get(idx).length; // 테스트 케이스 농장의 세로길이
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (tables.get(idx)[x][y] == 1 && !visitedList.get(idx)[x][y]) { // 배추가 있으면서 방문한 적 없는 위치인 경우?
                        dfs(x, y); // 재귀함수로 인접 배추들을 전부 방문
                        answer++; // 인접 배추들을 전부 방문했으면 (= 재귀함수가 종료됐으면) 카운트 상승
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void dfs(int x, int y) {
        visitedList.get(idx)[x][y] = true; // 방문 흔적 남기기
        for (int i = 0; i < 4; i++) { // 상, 하, 좌, 우의 인접한 부분에 방문한 적 없는 배추가 있는지 확인
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ny >= 0 && ny < m && nx >= 0 && nx < n) { // 농장의 범위를 벗어나지 않으면서
                if (tables.get(idx)[nx][ny] == 1 && !visitedList.get(idx)[nx][ny]) { // 배추가 있고, 방문한 적 없으면?
                    dfs(nx, ny); // 재귀함수로 인접 배추들을 전부 방문
                }
            }
        }
    }
}

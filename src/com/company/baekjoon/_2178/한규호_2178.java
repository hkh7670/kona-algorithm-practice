package com.company.baekjoon._2178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 한규호_2178 {

    public static class Location {
        int x;
        int y;
        int cost;

        public Location(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int n, m;
        int result = -1;
        int[][] map;
        int[][] visitMap;
        Queue<Location> q = new LinkedList<>();

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        map = new int[n][m];
        visitMap = new int[n][m];

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < n; i++) {
            line.append(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
            line.setLength(0); // 스트링빌더 값 초기화
        }

        visitMap[0][0] = 1;
        q.offer(new Location(0, 0, 1));
        while (!q.isEmpty()) {
            Location location = q.poll();
            int c = location.cost;
            if (location.x == n - 1 && location.y == m - 1) {
                result = c;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = location.x + dx[i];
                int ny = location.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (visitMap[nx][ny] == 0 && map[nx][ny] == 1) {
                        visitMap[nx][ny] = 1;
                        q.offer(new Location(nx, ny, c + 1));
                    }
                }
            }
        }
        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }
}

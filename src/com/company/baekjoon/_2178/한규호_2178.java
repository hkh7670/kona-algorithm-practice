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

        Queue<Location> q = new LinkedList<>();
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int result = -1;
        StringBuilder line = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] map = new int[n][m];
        int[][] visitMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            line.append(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
                // map[i][j] = line.charAt(j) - '0';
            }
            line.setLength(0); // 스트링빌더 값 초기화
        }
        visitMap[0][0] = 1;
        q.offer(new Location(0, 0, 1));
        while (!q.isEmpty()) {
            Location location = q.poll();
            if (location.x == n - 1 && location.y == m - 1) { // 최종 목적지에 도착 시 해당 위치의 cost값(최솟값)을 결과값으로 초기화 후 루프 탈출
                result = location.cost;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = location.x + dx[i];
                int ny = location.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) { // 배열의 범위를 벗어나지 않으면서
                    if (visitMap[nx][ny] == 0 && map[nx][ny] == 1) { // 방문한 적이 없고 이동 가능한 칸이면 큐에 저장
                        visitMap[nx][ny] = 1;
                        q.offer(new Location(nx, ny, location.cost + 1)); // 한칸 전진했으므로 cost는 1 증가
                    }
                }
            }
        }
        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }
}

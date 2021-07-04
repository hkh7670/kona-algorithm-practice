package com.company.baekjoon._18430;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class 서승환_18430 {
    static int n, m;
    static int[][] map;
    static int[][] dir = {{-1, 0, 0, 1}, {-1, 0, 0, -1}, {1, 0, 0, -1}, {1, 0, 0, 1}};

    static class Location {
        int x;
        int y;
        int point;

        public Location(int y, int x, int point) {
            this.x = x;
            this.y = y;
            this.point = point;
        }

        public String toString() {
            return "y: " + y + " x : " + x + "  " + (point + 1) + "사분면";
        }

    }

    ;
    static int answer = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception, IOException {

        int[] mapSize = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        n = mapSize[0];
        m = mapSize[1];

        map = new int[n][m];
        boolean[][] chk = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = numbers[j];
            }
        }
//        print2DArr(map);

        if (!(n == 1 || m == 1)) {
            bw.write("시작 n:" + n + " " + "m:" + m + "\n");
            dfs(0, 0, new ArrayList(), chk);
        }
        bw.write("마지막 정답" + String.valueOf(answer));
        bw.flush();
    }

    static void dfs(int y, int x, ArrayList<Location> arr, boolean[][] chk) throws Exception {
        bw.write("dfs y:" + y + " " +"x:" + x + "\n");
        bw.flush();
        if (y == n && x == m) {
            bw.write("한바퀴 돌았다.\n");
            bw.flush();
            arr.forEach(item -> System.out.println("item: " + item));
            int len = arr.size();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                int now_y = arr.get(i).y;
                int now_x = arr.get(i).x;
                int now_point = arr.get(i).point;
                bw.write("now_y:" + now_y + " " +"now_x:" + now_x + " " +"now_point:" + now_point +  "\n");
                bw.flush();
                sum += map[now_y][now_x] * 2 +
                        map[now_y + dir[now_point][0]][now_x + dir[now_point][1]] +
                        map[now_y + dir[now_point][2]][now_x + dir[now_point][3]];
                bw.write(String.valueOf(sum) + "\n");
                bw.flush();
            }
            answer = Math.max(answer, sum);
            bw.write("한바퀴 정답: "+ String.valueOf(answer) + "\n");
            bw.flush();
            return;
        }

        int now_y = y;
        int now_x = x;
        boolean pass = true;
        bw.write("now_y:" + now_y + " " + "now_x:" + now_x + "\n");
        bw.flush();
        // 1사분면 ~ 4사분면
        for (int k = 0; k < 4; k++) {
            // 범위 안
            if (now_y + dir[k][0] >= 0 && now_y + dir[k][0] < n
                    && now_y >= 0 && now_y < n
                    && now_x >= 0 && now_x < m
                    && now_x + dir[k][3] >= 0 && now_x + dir[k][3] < m) {
                bw.write(k+1 + "사분면"+ "범위 안\n");
                bw.flush();
                // 중복체크
                if (!chk[now_y][now_x] && !chk[now_y + dir[k][0]][now_x + dir[k][1]] && !chk[now_y + dir[k][2]][now_x + dir[k][3]]) {
                    bw.write("중복체크 완료\n");
                    bw.flush();
                    chk[now_y][now_x] = true;
                    chk[now_y + dir[k][0]][now_x + dir[k][1]] = true;
                    chk[now_y + dir[k][2]][now_x + dir[k][3]] = true;
                    arr.add(new Location(now_y, now_x, k));
                    if (now_x == m - 1 && now_y == n - 1) {
                        dfs(now_y + 1, now_x + 1, arr, chk);
                        pass = false;
                    } else if (now_x == m - 1) {
                        dfs(now_y + 1, 0, arr, chk);
                    } else {
                        dfs(now_y, now_x + 1, arr, chk);
                    }
                    bw.write("arr.size():" + arr.size() + "\n");
                    bw.flush();
                    arr.forEach(item -> System.out.println("item: " + item));
                    arr.remove(arr.size() - 1);
                    bw.write("remove_arr.size():" + arr.size() + "\n");
                    bw.flush();

                    chk[now_y][now_x] = false;
                    chk[now_y + dir[k][0]][now_x + dir[k][1]] = false;
                    chk[now_y + dir[k][2]][now_x + dir[k][3]] = false;
                }else{
                    bw.write("중복!\n");
                    bw.flush();
                }
            }

        }

        if (pass) {
            if (now_x == m - 1 && now_y == n - 1) {
                dfs(now_y + 1, now_x + 1, arr, chk);
            } else if (now_x == m - 1) {
                dfs(now_y + 1, 0, arr, chk);
            } else {
                dfs(now_y, now_x + 1, arr, chk);
            }
        }
    }

    static void print2DArr(int[][] arr) throws IOException {
        int rowLength = arr.length;
        int colLength = arr[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                bw.write(arr[i][j] + " ");
                bw.flush();
            }
            bw.write("\n");
            bw.flush();
        }
    }
}

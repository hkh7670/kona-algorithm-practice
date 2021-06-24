package com.company.baekjoon._1002;

import java.io.*;

public class 한규호_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x1, y1, r1, x2, y2, r2, cnt, t;

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] xyr = br.readLine().split(" ");
            x1 = Integer.parseInt(xyr[0]);
            y1 = Integer.parseInt(xyr[1]);
            r1 = Integer.parseInt(xyr[2]);
            x2 = Integer.parseInt(xyr[3]);
            y2 = Integer.parseInt(xyr[4]);
            r2 = Integer.parseInt(xyr[5]);
            cnt = getCoordinatesCnt(x1, y1, r1, x2, y2, r2); // 좌표의 갯수를 구하는 함수
            bw.write(cnt + "\n");
        }
        bw.close();
        br.close();
    }

    public static int getCoordinatesCnt(int x1, int y1, int r1, int x2, int y2, int r2) {
        if (x1 == x2 && y1 == y2 && r1 == r2) { // 접점이 무수히 많은 경우 (두 원이 같은 원)
            return -1;
        }
        int radiusDiff = r1 > r2 ? r1 - r2 : r2 - r1; // 두 원의 반지름의 차 (양수)
        int radiusSum = r1 + r2; // 두 원의 반지름의 합
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // 두 원의 중심 사이의 거리
        if (distance < radiusSum && distance > radiusDiff) { // 두 원의 접점이 2개인 경우
            return 2;
        }
        else if (distance == radiusSum || distance == radiusDiff) { // 두 원의 접점이 1개인 경우
            return 1;
        }
        else { // 접점이 없는 경우
            return 0;
        }
    }
}

package com.company.baekjoon._1002;

import java.io.*;

public class 한규호_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int x1, y1, r1, x2, y2, r2;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] xyr = br.readLine().split(" ");
            x1 = Integer.parseInt(xyr[0]);
            y1 = Integer.parseInt(xyr[1]);
            r1 = Integer.parseInt(xyr[2]);
            x2 = Integer.parseInt(xyr[3]);
            y2 = Integer.parseInt(xyr[4]);
            r2 = Integer.parseInt(xyr[5]);
            sb.append(getCoordinatesCnt(x1, y1, r1, x2, y2, r2)).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static int getCoordinatesCnt(int x1, int y1, int r1, int x2, int y2, int r2) {
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }
        int cnt;
        int radiusDiff = r1 > r2 ? r1 - r2 : r2 - r1;
        int radiusSum = r1 + r2;
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        if (distance < radiusSum && distance > radiusDiff) {
            cnt = 2;
        }
        else if (distance == radiusSum || distance == radiusDiff) {
            cnt = 1;
        }
        else {
            cnt = 0;
        }
        return cnt;
    }
}

package com.company.baekjoon._2178;

import java.io.*;

public class 한규호_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;
        int[][] map;
        int[][] visitMap;
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

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/

        bw.close();
        br.close();
    }
}

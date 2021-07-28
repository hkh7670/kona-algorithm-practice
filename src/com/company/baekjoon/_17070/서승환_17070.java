package com.company.baekjoon._17070;

import java.io.*;
import java.util.Arrays;

public class 서승환_17070 {
    static int n;
    static int[][][] pipe;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        pipe = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = numbers[j];
            }
        }

        pipe[0][1][0] = 1;

        bw.write(String.valueOf(answer()));
        bw.close();
        br.close();
    }

    static int answer(){
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if(map[i][j] == 1 ) continue;
                pipe[i][j][0] = pipe[i][j -1][0] + pipe[i][j-1][1];
                if(i == 0 ) continue;
                pipe[i][j][2] = pipe[i-1][j][1] + pipe[i-1][j][2];
                if(map[i-1][j]==1 || map[i][j-1] ==1) continue;
                pipe[i][j][1] = pipe[i-1][j-1][0] + pipe[i-1][j-1][1] + pipe[i-1][j-1][2];
            }
        }
        return pipe[n -1][n-1][0] + pipe[n-1][n-1][1] + pipe[n-1][n-1][2];
    }
}

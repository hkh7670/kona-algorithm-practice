package com.company.baekjoon._18430;

import java.io.*;

public class 한규호_18430 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n, m;
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        int[][] strengthMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] strengthArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                strengthMap[i][j] = Integer.parseInt(strengthArr[j]);
            }
        }
//        print2ndArr(strengthMap);
        bw.close();
        br.close();
    }

    public static void print2ndArr(int[][] arr) throws IOException {
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write("\n");
    }
}

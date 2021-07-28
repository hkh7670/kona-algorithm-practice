package com.company.baekjoon._14719;

import java.io.*;

public class 한규호_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] map;
        int row, col, result;
        String[] rowAndCol = br.readLine().split(" ");
        row = Integer.parseInt(rowAndCol[0]);
        col = Integer.parseInt(rowAndCol[1]);
        result = 0;
        map = new int[row][col];

        String[] heightArr = br.readLine().split(" ");
        for (int i = 0; i < col; i++) {
            int height = Integer.parseInt(heightArr[i]);
            for (int j = row - 1; j > row - 1 - height; j--) {
                map[j][i] = 1;
            }
        }

        for (int i = 0; i < row; i++) {
            int startIdx = -1; // 각 row 의 가장 왼쪽 끝(startIdx)에 있는 블록의 위치를 지정
            int endIdx = -1; // 각 row 의 가장 오른쪽 끝(endIdx)에 있는 블록의 위치를 지정
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1 && startIdx == -1 && j + 1 <= col - 1 && map[i][j + 1] != 1) {
                    startIdx = j;
                }
                if (map[i][j] == 1 && startIdx != -1) {
                    endIdx = j;
                }
            }
            for (int r = i; r < row; r++) { // startIdx와 endIdx 블록 사이에 있는 빈 공간을 물로 채운 후 카운트 증가
                for (int c = startIdx + 1; c < endIdx; c++) {
                    if (map[r][c] == 0) {
                        result++;
                        map[r][c] = 1;
                    }
                }
            }
        }
        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }
}

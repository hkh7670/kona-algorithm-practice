/*

Test Case

==================================
Case 1 :

10000 76
992 3508 6427 8970 1683 2114 3762 5945 8251 8349 2672 1813 2294 4623 1089 1724 5577 2362 5035 5028 3344 9321 3104 8877 2534 5864 9791 3221 5571 8763 773 6687 4909 3330 1427 8554 9688 6293 1899 3573 8597 5976 2772 1410 5182 888 4671 8106 782 6735 2832 9642 9824 1203 858 2643 2024 3798 5114 4253 72 2427 7137 1488 7324 4837 3656 6194 2600 8530 2413 5892 6404 7682 6775 7467

Result : 316105
==================================
Case 2 :

100 18
28 100 43 33 37 100 87 15 52 35 54 86 60 24 99 56 4 40

Result : 602
==================================
*/

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
            if (endIdx != -1) {
                for (int r = i; r < row; r++) { // startIdx와 endIdx 블록 사이에 있는 빈 공간을 물로 채운 후 카운트 증가
                    for (int c = startIdx + 1; c < endIdx; c++) {
                        if (map[r][c] == 0) {
                            result++;
                            map[r][c] = 1;
                        }
                    }
                }
            }
        }
        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }
}

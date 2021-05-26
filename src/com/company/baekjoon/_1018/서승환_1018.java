package com.company.baekjoon._1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서승환_1018 {

    /**
     * 
     * @param args
     * @throws IOException
     * 
     *                     brute force algorithm(노가다)
     */

    static char[][] board;
    static char[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        check = new char[2][8];
        check[0] = "WBWBWBWB".toCharArray();
        check[1] = "BWBWBWBW".toCharArray();

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        board = new char[height][width];

        for (int i = 0; i < height; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= height - 8; i++) {
            for (int j = 0; j <= width - 8; j++) {
                min = Math.min(min, solution(i, j));
            }
        }

        System.out.println(min);
    }

    private static int solution(int y, int x) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int cnt = 0;
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if (board[y + j][x + k] != check[(i + j) % 2][k]) {
                        cnt++;
                    }
                }
            }
            min = Math.min(min, cnt);
        }
        return min;
    }
}
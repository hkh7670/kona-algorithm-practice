package com.company.baekjoon._1018;

import java.io.*;

public class 한규호_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String startWithBlack = "BWBWBWBW";
        char[] startWithBlackToChar = startWithBlack.toCharArray();
        String startWithWhite = "WBWBWBWB";
        char[] startWithWhiteToChar = startWithWhite.toCharArray();

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int minCnt = 2500; // 다시 칠해야 하는 정사각형의 최수 개수

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int j = 0;
            for (int lineIdx = 0; lineIdx < line.length(); lineIdx++) {
                board[i][j++] = line.charAt(lineIdx);
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int row = i + 8;
                int col = j + 8;
                int blackCaseCnt = 0;
                int whiteCaseCnt = 0;

                // 첫번째 칸 : black
                boolean blackToggle = true;
                boolean whiteToggle = false;

                for (int r = i; r < row; r++) {
                    for (int c = j; c < col; c++) {
                        if (blackToggle) {
                            if (board[r][c] != startWithBlackToChar[c - j]) blackCaseCnt++;
                        } else if (whiteToggle) {
                            if (board[r][c] != startWithWhiteToChar[c - j]) blackCaseCnt++;
                        }
                    }
                    blackToggle = !blackToggle;
                    whiteToggle = !whiteToggle;
                }

                blackToggle = false;
                whiteToggle = true;
                // 첫번째 칸 : white
                for (int r = i; r < row; r++) {
                    for (int c = j; c < col; c++) {
                        if (blackToggle) {
                            if (board[r][c] != startWithBlackToChar[c - j]) whiteCaseCnt++;
                        } else if (whiteToggle) {
                            if (board[r][c] != startWithWhiteToChar[c - j]) whiteCaseCnt++;
                        }
                    }
                    blackToggle = !blackToggle;
                    whiteToggle = !whiteToggle;
                }
                if (blackCaseCnt < whiteCaseCnt) {
                    if (minCnt > blackCaseCnt) {
                        minCnt = blackCaseCnt;
                    }
                } else {
                    if (minCnt > whiteCaseCnt) {
                        minCnt = whiteCaseCnt;
                    }
                }
            }

        }
        bw.write(String.valueOf(minCnt));
        bw.flush();
        bw.close();
        br.close();
    }
}

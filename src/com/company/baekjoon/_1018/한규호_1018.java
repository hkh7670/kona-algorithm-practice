package com.company.baekjoon._1018;

import java.io.*;

public class 한규호_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String startWithBlackPattern = "BWBWBWBW";
        char[] startWithBlackArr = startWithBlackPattern.toCharArray();
        String startWithWhitePattern = "WBWBWBWB";
        char[] startWithWhiteArr = startWithWhitePattern.toCharArray();

        int minCnt = 2500; // 다시 칠해야 하는 정사각형의 최소 개수
        int chessWidth = 8; // 체스판의 가로 길이
        int chessHeight = 8; // 체스판의 세로 길이

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int lineLength = line.length();
            for (int lineIdx = 0; lineIdx < lineLength; lineIdx++) {
                board[i][lineIdx] = line.charAt(lineIdx);
            }
        }

        for (int i = 0; i <= n - chessHeight; i++) {
            for (int j = 0; j <= m - chessWidth; j++) {
                int row = i + chessHeight;
                int col = j + chessWidth;
                int blackCaseCnt = 0; // 좌측 최상단의 칸이 검정색으로 시작하는 체스판일 경우의 다시 칠해야하는 정사각형의 갯수
                int whiteCaseCnt = 0; // 좌측 최상단의 칸이 하얀색으로 시작하는 체스판일 경우의 다시 칠해야하는 정사각형의 갯수
                boolean blackAndWhiteToggle = true;

                // 좌측 최상단의 칸이 검정색으로 시작하는 체스판일 경우와 하얀색으로 시작하는 체스판일 경우의
                // 다시 칠해야하는 정사각형의 갯수 (blackCaseCnt, whiteCaseCnt) 를 따로 구해서 둘 중 작은 값을 최솟값으로 취한다.
                // 각 케이스에서 구한 값 중 가장 작은 값이 답

                for (int r = i; r < row; r++) {
                    for (int c = j; c < col; c++) {
                        int patternArrIdx = c - j;
                        if (blackAndWhiteToggle) {
                            if (board[r][c] != startWithBlackArr[patternArrIdx]) blackCaseCnt++;
                            if (board[r][c] != startWithWhiteArr[patternArrIdx]) whiteCaseCnt++;
                        }
                        else {
                            if (board[r][c] != startWithWhiteArr[patternArrIdx]) blackCaseCnt++;
                            if (board[r][c] != startWithBlackArr[patternArrIdx]) whiteCaseCnt++;
                        }
                    }
                    blackAndWhiteToggle = !blackAndWhiteToggle;
                }
                minCnt = Math.min((Math.min(blackCaseCnt, whiteCaseCnt)), minCnt);
            }
        }

        bw.write(String.valueOf(minCnt));
        bw.flush();
        bw.close();
        br.close();
    }
}

package com.company.baekjoon._9663;

import java.io.*;

public class 한규호_9663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] arr;
    static int cnt = 0;
    static int n;
    static boolean isPossible = true; // 퀸 배치 가능 유무

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        nQueen(0);
        bw.write(Integer.toString(cnt));
        bw.close();
        br.close();
    }

    public static void nQueen(int row) {
        if (row == n) { // 퀸을 서로 공격할 수 없는 위치에 n개 만큼 배치된 경우? -> 조건을 만족하므로 카운트 증가
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            isPossible = true;
            arr[row] = i;
            for (int j = 0; j < row; j++) {
                if (arr[j] == arr[row] || (Math.abs(arr[row] - arr[j]) == Math.abs(row - j))) { // 퀸이 같은 직선상에 위치하거나 대각선에 위치하는 경우? -> 진행 불가
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) { // 위 for문 에서 퀸을 배치할 수 없는 경우가 발견되지 않은 경우? -> 다음 행에 퀸 배치 진행
                nQueen(row + 1);
            }
        }
    }
}
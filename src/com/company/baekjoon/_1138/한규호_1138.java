package com.company.baekjoon._1138;

import java.io.*;
import java.util.Arrays;

public class 한규호_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] leftCntArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] line = new int[n];

        for (int leftIdx = 0; leftIdx < n; leftIdx++) {
            for (int lineIdx = 0; lineIdx < n; lineIdx++) {
                if (leftCntArr[leftIdx] == 0) {
                    if (line[lineIdx] == 0) {
                        line[lineIdx] = leftIdx + 1;
                        break;
                    }
                    else continue;
                }
                if (line[lineIdx] == 0) { // leftCntArr[leftIdx] 보다 작은 값이 자리를 잡지 않은 경우에만 차감
                    leftCntArr[leftIdx]--;
                }
            }
        }
        for (int val : line) {
            bw.write(val + " ");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}

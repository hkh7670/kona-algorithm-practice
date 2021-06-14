package com.company.baekjoon._14501;

import java.io.*;
import java.util.Arrays;

public class 한규호_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] maxIncomeArr = new int[n + 1]; // 특정일(i)의 최대 수익
        int maxIncome = 0; // 최대 수익

        for (int i = 0; i < n; i++) {
            String[] tp = br.readLine().split(" ");
            t[i] = Integer.parseInt(tp[0]);
            p[i] = Integer.parseInt(tp[1]);
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                maxIncomeArr[i] = Math.max(maxIncomeArr[i], maxIncomeArr[j]);
                if (j + t[j] == i) {
                    maxIncomeArr[i] = Math.max(maxIncomeArr[i], maxIncomeArr[j] + p[j]);
                }
            }
            maxIncome = Math.max(maxIncome, maxIncomeArr[i]);
        }
        bw.write("t[i] : " + Arrays.toString(t) + "\n");
        bw.write("p[i] : " + Arrays.toString(p) + "\n");
        bw.write("max[i] : " + Arrays.toString(maxIncomeArr) + "\n");
        bw.write(Integer.toString(maxIncome));
        br.close();
        bw.close();
    }
}

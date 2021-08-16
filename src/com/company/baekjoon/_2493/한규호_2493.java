package com.company.baekjoon._2493;

import java.io.*;
import java.util.Stack;

public class 한규호_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> heightStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        int[] topHeight = new int[n];
        String[] heights = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            topHeight[i] = Integer.parseInt(heights[i]);
        }
        heightStack.push(topHeight[0]);
        indexStack.push(0);
        bw.write(0 + " ");

        for (int i = 1; i < n; i++) {
            while (!heightStack.isEmpty()) {
                if (heightStack.peek() > topHeight[i]) {
                    bw.write(indexStack.peek() + 1 + " ");
                    break;
                }
                heightStack.pop();
                indexStack.pop();
            }
            if (heightStack.isEmpty()) {
                bw.write(0 + " ");
            }
            heightStack.push(topHeight[i]);
            indexStack.push(i);
        }

        bw.close();
        br.close();

//        for (int i = n - 1; i >= 0; i--) {
//            int targetTopHeight = topHeight[i];
//            for (int j = i - 1; j >= 0; j--) {
//                if (targetTopHeight <= topHeight[j]) {
////                    bw.write((j + 1) + " ");
//                    sb.append(j + 1).append(" ");
//                    break;
//                }
//                if (j == 0) sb.append(0).append(" ");
//            }
//        }
//        sb.append(0);
//        sb.reverse();
//        bw.write(sb.toString());
//        bw.close();
//        br.close();
    }
}

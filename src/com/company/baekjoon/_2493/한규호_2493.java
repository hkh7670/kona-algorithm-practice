package com.company.baekjoon._2493;

import java.io.*;
import java.util.Stack;

public class 한규호_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> heightStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] topHeight = new int[n];
        String[] heights = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            topHeight[i] = Integer.parseInt(heights[i]);
        }
        heightStack.add(topHeight[0]);
        indexStack.add(0);
        sb.append(0).append(" ");
        int heightArrIdx = 0;
        int stackIdx = 0;

        while (stackIdx < n) {
            while (!heightStack.isEmpty()) {
                if (heightStack.peek() > topHeight[heightArrIdx]) {
                    sb.append(indexStack.peek() + 1).append(" ");
                    break;
//                heightStack.pop();
//                heightStack.add(topHeight[heightArrIdx]);
//                indexStack.add(stackIdx);
//                sb.append(stackIdx + 1).append(" ");
                }
                heightStack.pop();
                indexStack.pop();
            }
            heightStack.push(topHeight[heightArrIdx]);
            indexStack.push(stackIdx);
            heightArrIdx++;
            stackIdx++;
        }

        bw.write(sb.toString());
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

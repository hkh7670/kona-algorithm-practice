package com.company.baekjoon._2504;

import java.io.*;
import java.util.Stack;

public class 한규호_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int temp = 1;
        char prevChar = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(str.charAt(i));
                temp *= 2;
            }

            else if (c == '[') {
                stack.push(str.charAt(i));
                temp *= 3;
            }

            else if (c == ')') {
                if (stack.isEmpty()) {
                    result = 0;
                    break;
                }
                if (stack.peek() == '(') {
                    if (prevChar == '(') {
                        result += temp;
                    }
                    stack.pop();
                }
                else {
                    result = 0;
                    break;
                }
                temp /= 2;
            }

            else {
                if (stack.isEmpty()) {
                    result = 0;
                    break;
                }
                if (stack.peek() == '[') {
                    if (prevChar == '[') {
                        result += temp;
                    }
                    stack.pop();
                }
                else {
                    result = 0;
                    break;
                }
                temp /= 3;
            }
            prevChar = c;
        }
        if (!stack.isEmpty()) {
            result = 0;
        }
        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }
}

package com.company.baekjoon._2504;

import java.io.*;
import java.util.Stack;

public class 한규호_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0; // 최종 결과
        int temp = 1; // 계산값을 임시로 저장하기위한 변수
        char prevChar = 0; // 이전 loop의 기호
        int strLength = str.length();

        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);

            // Case 1: 여는 괄호가 나올 때? -> 각 케이스에 맞게 계산 후 여는 괄호는 스택에 push
            if (c == '(') {
                stack.push(c);
                temp *= 2;
            }

            else if (c == '[') {
                stack.push(c);
                temp *= 3;
            }

            // Case 2: 닫는 괄호가 나올 때

            else if (c == ')') {
                if (stack.isEmpty()) { // 스택이 비어있는 경우? -> 입력이 올바르지 못한 경우
                    result = 0;
                    break;
                }
                if (stack.peek() == '(') {
                    if (prevChar == '(') {
                        result += temp; // 직전 기호(prevChar)가 c와 반대 이면서 스택에 있는 기호도 반대인 경우 -> result에 더함
                    }
                    stack.pop(); // 닫는 괄호가 나오면 스택에 있는 여는 괄호를 하나씩 제거
                }
                else {
                    result = 0;
                    break;
                }
                temp /= 2; // 닫는 괄호가 나오는 경우 기존에 temp에 누적하여 계산했던 값을 원래대로(1) 돌림
            }

            else {
                if (stack.isEmpty()) { // 스택이 비어있는 경우? -> 입력이 올바르지 못한 경우
                    result = 0;
                    break;
                }
                if (stack.peek() == '[') {
                    if (prevChar == '[') {
                        result += temp; // 직전 기호(prevChar)가 c와 반대 이면서 스택에 있는 기호도 반대인 경우 -> result에 더함
                    }
                    stack.pop(); // 닫는 괄호가 나오면 스택에 있는 여는 괄호를 하나씩 제거
                }
                else {
                    result = 0; // 스택 최상단에 있는 여는 괄호와 현재 괄호 c가 매치가 되지 않는 경우 (ex. (], [) ) -> 입력이 올바르지 못한 경우
                    break;
                }
                temp /= 3; // 닫는 괄호가 나오는 경우 기존에 temp에 누적하여 계산했던 값을 원래대로(1) 돌림
            }
            prevChar = c;
        }
        if (temp != 1) { // 여는괄호와 닫는괄호의 갯수가 다르거나 매치가 되지 않는 경우 -> 입력이 올바르지 못한 경우
            result = 0;
        }
        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }
}

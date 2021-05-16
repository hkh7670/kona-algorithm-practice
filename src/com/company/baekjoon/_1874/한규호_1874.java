package com.company.baekjoon._1874;

import java.io.*;
import java.util.Stack;

public class 한규호_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String lineBreak = "\n";
        String plus = '+' + lineBreak;
        String minus = '-' + lineBreak;

        int popIdx = 0; // pop할 때 사용할 배열 인덱스
        int pushNum = 1; // 오름차순으로 스택에 넣을 숫자 변수
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[i] = number;
        }
        br.close();

        while (popIdx < n) {
            if (pushNum == n + 1 && !stack.peek().equals(numbers[popIdx])) { // 더 이상 push할 숫자가 없으면서 (= pop밖에 할 수 없으면서) 스택의 Top에 있는 값이 요구되는 숫자와 다를경우 -> 수열 생성 불가능
                bw.write("NO");
                bw.flush();
                bw.close();
                return;
            }
            if (!stack.empty()) { // 스택에 비어있지 않으면서
                if (stack.peek().equals(numbers[popIdx])) { // 스택의 Top에 있는 값이 요구되는 숫자와 같을 경우 -> pop 하면서 '-' 연산자 추가
                    stack.pop();
                    popIdx++;
                    sb.append(minus);
                    continue;
                }
            }
            stack.push(pushNum++); // 위 두 조건에 해당 안되는 경우엔 stack에 오름차순으로 push
            sb.append(plus); // push 후 '+' 연산자 추가
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

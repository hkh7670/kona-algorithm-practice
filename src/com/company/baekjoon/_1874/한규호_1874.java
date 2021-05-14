package com.company.baekjoon._1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class 한규호_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        String plus = "+";
        String minus = "-";
        boolean isPossible = true;
        int popIdx = 0; // pop할 때 사용할 배열 인덱스
        int pushIdx = 0; // 오름차순으로 push할 때 사용할 배열 인덱스
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers.add(number);
        }

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList()); // 오름차순으로 정렬된 숫자 리스트

        while (popIdx < n) {
            if (pushIdx == n && !stack.peek().equals(numbers.get(popIdx))) { // 더 이상 push할 숫자가 없으면서 (= pop밖에 할 수 없으면서) 스택의 Top에 있는 값이 요구되는 숫자와 다를경우 -> 수열 생성 불가능
                isPossible = false;
                break;
            }
            if (!stack.empty()) { // 스택에 비어있지 않으면서
                if (stack.peek().equals(numbers.get(popIdx))) { // 스택의 Top에 있는 값이 요구되는 숫자와 같을 경우 -> pop 하면서 '-' 연산자 추가
                    stack.pop();
                    popIdx++;
                    operators.add(minus);
                    continue;
                }
            }
            stack.push(sortedNumbers.get(pushIdx++)); // 위 두 조건에 해당 안되는 경우엔 stack에 오름차순으로 push
            operators.add(plus); // push 후 '+' 연산자 추가
        }

        if (isPossible) {
            for (String operator : operators) {
                System.out.println(operator);
            }
        } else {
            System.out.println("NO");
        }

    }
}

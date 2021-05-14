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

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers.add(number);
        }
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList()); // 오름차순으로 정렬된 숫자 리스트

        int popIdx = 0;
        int pushIdx = 0;
        do {
            if (pushIdx == sortedNumbers.size() && !stack.peek().equals(numbers.get(popIdx))) {
                isPossible = false;
                break;
            }

            if (!stack.empty() && stack.peek().equals(numbers.get(popIdx))) {
                stack.pop();
                popIdx++;
                operators.add(minus);
                continue;
            }
            stack.push(sortedNumbers.get(pushIdx++));
            operators.add(plus);
        } while (popIdx < sortedNumbers.size());


        if (isPossible) {
            for (String operator : operators) {
                System.out.println(operator);
            }
        } else {
            System.out.println("NO");
        }
    }
}

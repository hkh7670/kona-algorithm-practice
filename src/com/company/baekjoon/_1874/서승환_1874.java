package com.company.baekjoon._1874;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 서승환_1874 {
    public static void main(String[] args) throws Exception{
        /**
         *스택: 한 쪽 끝에서만 자료를 넣고 뺄 수 있는 LIFO(Last In First Out) 형식의 자료 구조 
         * pop(): 스택에서 가장 위에 있는 항목을 제거한다.
         * push(item): item 하나를 스택의 가장 윗 부분에 추가한다.
         * peek(): 스택의 가장 위에 있는 항목을 반환한다.
         * isEmpty(): 스택이 비어 있을 때에 true를 반환한다.
         * 
         * 재귀 알고리즘을 사용할 때 스택이 유용
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 일정크기 초과 시 버퍼를 비우는데 스택 수열이 불가능할 때 새로운 퍼버 생성 시 에러발생
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int target;
        int number = 1;
        boolean flag = false;

        for(int i=0; i<n; i++){
            target = Integer.parseInt(br.readLine());

            while(!flag){
                if(!stack.isEmpty() && stack.peek() == target){
                    stack.pop();
                    sb.append("-\n");
                    break;
                }

                if(target >= number){
                    stack.push(number);
                    sb.append("+\n");
                    number++;
                    continue;
                }

                if(target < number){
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        if(flag){
            System.out.println("NO");
        }{
            System.out.println(sb.toString());
        }
    }
}

package com.company.baekjoon._17503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 서승환_17503 {
    /**
     * 
     * @param args
     * @throws Exception
     * 
     * PriorityQueue: 우선순위를 먼저 결정하고 그 우선순위가 높은 엘리먼트가 먼저 나가는 자료구조
     * 특징
     * 1.내부 요소는 힙으로 구성되어 이진트리 구조로 이루어져 있음   
     * 2.내부구조가 힙으로 구성되어 있기에 시간 복잡도는 O(NLogN)
     * 
     * import java.util.PriorityQueue;
     * int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
     * PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
     * 
     * int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
     * PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
     * 
     * String형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
     * PriorityQueue<String> priorityQueue = new PriorityQueue<>(); 
     * 
     * String형 priorityQueue 선언 (우선순위가 높은 숫자 순)
     * PriorityQueue<String> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
     * 
     * priorityQueue.add();        priorityQueue에 값 넣기 
     * priorityQueue.poll();       priorityQueue에 첫번째 값을 반환하고 제거 비어있다면 null
     * priorityQueue.peek();       priorityQueue에 첫번째 값을 반환만 하고 제거는 안 하고 비어있다면 null
     * priorityQueue.remove();     priorityQueue에 첫번째 값 제거
     * priorityQueue.clear();      priorityQueue에 초기화
     */

    static int n,m,k, p, abv ; // n 축제기간 m 선호도 합 k 맥주 종류 수 p 선호도 abv 도수
    static int sum = 0;
    static int answer = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] fLine = br.readLine().split(" ");
        n = Integer.parseInt(fLine[0]);
        m = Integer.parseInt(fLine[1]);
        k = Integer.parseInt(fLine[2]);
        
        int[][] pAbv = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] content = br.readLine().split(" ");
            pAbv[i][0] = Integer.parseInt(content[0]);
            pAbv[i][1] = Integer.parseInt(content[1]);
        }

        Arrays.sort(pAbv, Comparator.comparingInt(item -> item[1]));

        PriorityQueue pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(pAbv[i][0]);
            sum += pAbv[i][0];
            if(pq.size() > n){
                sum -= (int) (pq.peek() == null ? 0 : pq.poll());
            }
            if(pq.size() ==n && sum >=m){
                answer = pAbv[i][1];
                break;
            }
        }
        System.out.println(answer);
    }
}

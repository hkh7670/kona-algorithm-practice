package com.company.baekjoon._17503;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 한규호_17503 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // int형 변수를 담는 우선순위 큐 변수 pq 선언

        int preferenceIdx = 0; // 선호도 index
        int alcoholIdx = 1; // 도수 레벨 index
        int minLiverLevel = -1; // 간 레벨의 최솟값
        int preferenceSum = 0; // 선호도 합계

        String[] nmk = br.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        int[][] beerInfoArr = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] vc = br.readLine().split(" ");
            beerInfoArr[i][preferenceIdx] = Integer.parseInt(vc[preferenceIdx]);
            beerInfoArr[i][alcoholIdx] = Integer.parseInt(vc[alcoholIdx]);
        }

        Arrays.sort(beerInfoArr, Comparator.comparingInt(item -> item[alcoholIdx])); // 맥주의 도수 레벨 순으로 배열 정렬


        bw.write("\n--------맥주의 도수 레벨 순 정렬--------\n");
        bw.flush();
        print2DArr(beerInfoArr);

        for (int i = 0; i < k; i++) {
            pq.add(beerInfoArr[i][preferenceIdx]); // 우선순위 큐에 맥주의 선호도 값을 추가 (추가하면 선호도가 작은 순으로 정렬됨)
            preferenceSum += beerInfoArr[i][preferenceIdx]; // 선호도를 누적해서 합산

            if (pq.size() > n) { // pq의 갯수가 맥주의 갯수(n) 보다 크면?
                int minPreference = pq.peek() == null ? 0 : pq.poll(); // 선호도가 가장 작은 값 (= pq에서 우선순위가 가장 높은 값) 을 우선순위 큐에서 제거한 후 총 합에서 차감
                preferenceSum -= minPreference;
            }

            if (pq.size() == n && preferenceSum >= m) { // 우선순위 큐의 사이즈가 맥주의 갯수(n)과 같으면서 선호도의 총 합이 m 이상인 경우
                minLiverLevel = beerInfoArr[i][alcoholIdx]; // 간 레벨의 최솟값을 해당 루프의 맥주 도수레벨로 초기화한 후 break
                break;
            }
        }
        bw.write("\n간 레벨 최솟값 : ");
        bw.write(Integer.toString(minLiverLevel));
        bw.flush();
        bw.close();
        br.close();

        /*int refLevel = 0;
        for (int i = 0; i < maxAlcohol; i++) {
            int beerCnt = 0;
            int sum = 0;
            for (int j = 0; j < k; j++) {
                if (beerCnt == n) break;
                if (beerInfoArr[j][1] <= refLevel) {
                    sum += beerInfoArr[j][0];
                    beerCnt++;
                }
            }
            if (sum >= m) {
                minLiverLevel = refLevel;
                break;
            }
            refLevel++;
        }*/
    }

    static void print2DArr(int[][] arr) throws IOException {
        int rowLength = arr.length;
        int colLength = arr[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                bw.write(arr[i][j] + " ");
                bw.flush();
            }
            bw.write("\n");
            bw.flush();
        }
    }
}

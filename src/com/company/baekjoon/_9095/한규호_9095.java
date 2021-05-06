package com.company.baekjoon._9095;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 한규호_9095 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        List<Integer> testCases = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int testCase = s.nextInt();
            testCases.add(testCase);
        }

        for (int testCase : testCases) {
            int result = 1;
            int twoCnt = 0;
            int threeCnt = 0;

            // 1과 2만 사용하는 경우
            for (int i = 0; i < testCase / 2; i++) {
                twoCnt++;
                int oneCnt = testCase - (twoCnt * 2);
                int totalFac = getFactorial(twoCnt + oneCnt);
                int oneFac = getFactorial(oneCnt);
                int twoFac = getFactorial(twoCnt);
                result += totalFac / (oneFac * twoFac);
            }

            // 1과 3만 사용하는 경우
            for (int i = 0; i < testCase / 3; i++) {
                threeCnt++;
                int oneCnt = testCase - (threeCnt * 3);
                int totalFac = getFactorial(threeCnt + oneCnt);
                int oneFac = getFactorial(oneCnt);
                int threeFac = getFactorial(threeCnt);
                result += totalFac / (oneFac * threeFac);
            }


            // 1, 2, 3을 전부 사용하는 경우
            twoCnt = 1;
            threeCnt = 1;
            while (twoCnt * 2 + threeCnt * 3 <= testCase) {
                int oneCnt = testCase - (twoCnt * 2 + threeCnt * 3);
                int totalCnt = oneCnt + twoCnt + threeCnt;
                int totalFac = getFactorial(totalCnt);
                int oneFac = getFactorial(oneCnt);
                int twoFac = getFactorial(twoCnt);
                int threeFac = getFactorial(threeCnt);
                result += totalFac / (oneFac * twoFac * threeFac);

                twoCnt++;
                if (twoCnt * 2 + threeCnt * 3 > testCase) {
                    twoCnt = 1;
                    threeCnt++;
                }
            }
            results.add(result);
        }

        for (int result : results) {
            System.out.println(result);
        }
    }

    public static int getFactorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}


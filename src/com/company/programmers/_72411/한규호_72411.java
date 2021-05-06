package com.company.programmers._72411;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;

public class 한규호_72411 {


    static List<String> combinationList = new ArrayList<>();
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String[] orders =
                {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        {"XYZ", "XWY", "WXA"};
        int[] course =
                {2, 3, 4};
//        {2,3,5};
//        {2,3,4};

        for (int i = 0; i < orders.length; i++) {
            char[] stringToChar = orders[i].toCharArray();
            sort(stringToChar);
            orders[i] = new String(stringToChar);
        }

        for (String order : orders) {
            int orderLength = order.length();
            for (int c : course) {
                if (orderLength < c) {
                    break;
                }
                boolean[] visited = new boolean[orderLength];
                combination(order, visited, 0, orderLength, c);
            }
        }

        for (int c : course) {
            Long maxCnt = 0L;
            List<String> maxCntCombinationList = new ArrayList<>();
            List<String> combinationListPerCourse = combinationList.stream() // 각 코스에 해당하는 케이스들만 추출
                    .filter(item -> item.length() == c)
                    .collect(Collectors.toList());
            System.out.println("combinationListPerCourse (" + c + ") : " + combinationListPerCourse);
            Map<String, Long> countMap = combinationListPerCourse.stream() // 각 케이스별로 count
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
            System.out.println("countMap : " + countMap);
            for (String s : combinationListPerCourse) {
                if (maxCnt < countMap.get(s) && countMap.get(s) >= 2) {
                    maxCnt = countMap.get(s); // 각 코스 별 최대 count 구하기
                }
            }
            for (String key : countMap.keySet()) {
                if (maxCnt.equals(countMap.get(key))) {
                    maxCntCombinationList.add(key); // 최대 count와 같은 조합만 add
                }
            }
            result.addAll(maxCntCombinationList); // 위에서 구한 조합을 최종결과 list에 add
            System.out.println("result : " + result + "\n");
        }
        System.out.println(result.stream()
                .sorted()
                .collect(Collectors.toList())); // 오름차순 출력
    }

    static void combination(String arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            appendToList(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void appendToList(String arr, boolean[] visited, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                result.append(arr.charAt(i));
            }
        }
        combinationList.add(result.toString());
    }
}
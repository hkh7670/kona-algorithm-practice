package com.company.programmers._72410;

import java.util.Scanner;

public class 한규호_72410 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String new_id = scanner.nextLine();
        new_id = new_id.toLowerCase(); // 소문자 치환
        new_id = new_id.replaceAll("[^a-z0-9-_.]+", ""); // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        new_id = new_id.replaceAll("(\\.)+", "."); // new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        if (new_id.charAt(0) == '.') new_id = new_id.substring(1); // 맨 앞 마침표 제거
        if (new_id.length() > 0) { //맨 뒤 마침표 제거
            if (new_id.charAt(new_id.length() - 1) == '.') {
                if (new_id.length() - 1 == 0) {
                    new_id = "";
                } else {
                    new_id = new_id.substring(0, new_id.length() - 1);
                }
            }
        }
        if (new_id.length() == 0) new_id = "a";
        if (new_id.length() >= 16) new_id = new_id.substring(0, 15);
        if (new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);
        if (new_id.length() <= 2) {
            char lastChar = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3) {
                new_id += lastChar;
            }
        }
        scanner.close();
        System.out.println(new_id);
    }
}
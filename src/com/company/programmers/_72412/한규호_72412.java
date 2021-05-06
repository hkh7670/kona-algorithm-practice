package com.company.programmers._72412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 한규호_72412 {
    public static void main(String[] args) {
        String[] infos = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] querys = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        List<Integer> answer = new ArrayList<>();
        List<List<String>> queryList = new ArrayList<>();
        for (String queryOne : querys) {
            List<String> querySplit = new ArrayList<>(Arrays.asList(queryOne.split(" and ")));
            String last = querySplit.get(querySplit.size() - 1);
            querySplit.set(querySplit.size() - 1, last.split(" ")[0]);
            querySplit.add(last.split(" ")[1]);
            queryList.add(querySplit);
        }

        for (List<String> queryOne : queryList) {
            int matchCnt = 0;
            String lang = queryOne.get(0);
            String job = queryOne.get(1);
            String career = queryOne.get(2);
            String food = queryOne.get(3);

            for (String infoOne : infos) {
                String[] infoSplit = infoOne.split(" ");

                if (!infoSplit[0].equals(lang) && !lang.equals("-")) continue;
                if (!infoSplit[1].equals(job) && !job.equals("-")) continue;
                if (!infoSplit[2].equals(career) && !career.equals("-")) continue;
                if (!infoSplit[3].equals(food) && !food.equals("-")) continue;

                int infoSplitScore = Integer.parseInt(infoSplit[4]);
                int score = Integer.parseInt(queryOne.get(4));
                if (infoSplitScore >= score) {
                    matchCnt++;
                }
            }
            answer.add(matchCnt);
        }
        System.out.println(answer);
    }
}
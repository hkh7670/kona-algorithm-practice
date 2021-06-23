package com.company.baekjoon._1002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 서승환_1002 {
    public static void main(String[] args) throws Exception, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
           int[] numbers = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
           int x1 = numbers[0];
           int y1 = numbers[1];
           int r1 = numbers[2];
           int x2 = numbers[3];
           int y2 = numbers[4];
           int r2 = numbers[5];

           double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

           if(d == 0 && r1== r2){
               System.out.println("-1");
           }else if(d > Math.abs(r2 -r1) && d< r1+ r2) {
            System.out.println("2");
           }else if(Math.abs(r2- r1) == d || r2+ r1== d) {
               System.out.println("1");
           }else if(r1+ r2 < d || Math.abs(r2 - r1) > d || d == 0) {
            System.out.println("0");
           }
           bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}

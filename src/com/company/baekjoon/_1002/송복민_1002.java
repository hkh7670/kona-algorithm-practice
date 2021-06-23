package com.company.baekjoon._1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 송복민_1002 {

	static int T;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for (int t = 1; t <=T ; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int r1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int r2=Integer.parseInt(st.nextToken());
			
			int answer=2;
			double distance=Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2));
			if(x1==x2 && y1==y2 && r1!=r2) {
				answer=-1;
			}else if((x1==x2 && y1==y2 && r1==r2) ||distance>r1+r2 || distance<Math.abs(r1-r2)) {
				answer=0;
			}else if(distance==r1+r2 || distance==Math.abs(r1-r2)) {
				answer=1;
			}
			System.out.println(answer);
		}
	}
}

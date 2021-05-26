package com.company.baekjoon._1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 송복민_1018 {

	static int M,N;
	static char[][] map;
	static int min=Integer.MAX_VALUE;
	static char start;
	static int diff=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new char[M][N];
		
		for (int i = 0; i < M; i++) {
			String s=br.readLine();
			map[i]=s.toCharArray();
		}

		for (int i = 0; i < M-7; i++) {
			for (int j = 0; j < N-7; j++) {
				start=map[i][j];
				diff=0;
				check(i,j,start);//시작점
				
				if(start=='B') start='W';
				else if(start=='W') start='B';
				diff=1;
				check(i,j,start);
			}
		}
		System.out.println(min);
	}
	
	private static void check(int i, int j, char start) {
		int line=1;
		for (int m = i; m < i+8; m++) {
			if(line%2!=0) {
				//홀수줄 첫번째 줄 제외하고 그전 start와 홀수줄 첫번째가 같아야 함
				if(m!=i) {
					if(start!=map[m][j]) {
						diff++;
					}
				}
				for (int n = j; n < (j+8)-1; n++) {
					//다음 것과 같으면 +1
					if(start==map[m][n+1]) {
						diff++;
					}
					if(start=='B') start='W';
					else if(start=='W') start='B';
				}
			}
			else if(line%2==0){
				
				//짝수줄이면 start와 짝수 줄 첫번째가 같아야 함
				if(start!=map[m][j]) {
					diff++;
				}
				
				for (int n = j; n < (j+8)-1; n++) {
					//다음 것과 같으면 +1
					if(start==map[m][n+1]) {
						diff++;
					}
					if(start=='B') start='W';
					else if(start=='W') start='B';
				}
			}
			line++;
		}
		min=Math.min(diff, min);
	}
}

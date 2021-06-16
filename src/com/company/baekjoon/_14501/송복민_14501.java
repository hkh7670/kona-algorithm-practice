package com.company.baekjoon._14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//DP인 것을 눈치 못 챔
//구글링 많이 함
public class 송복민_14501 {

	static int N;
	static int[][] data;
	static int[] DP;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		data=new int[N][3];
		DP=new int[N+1];//일하는 날:0~N-1, 퇴사날:N
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int time=Integer.parseInt(st.nextToken());
			int price=Integer.parseInt(st.nextToken());
			data[i][0]=time;
			data[i][1]=price;
		}
				
		for (int i = 0; i < N; i++) {
			int selectDay=i;
			int selectTime=data[i][0];
			int selectPrice=data[i][1];
			
			if(selectDay+selectTime<=N) {//당일 + 일할 수 있는 날이 N을 넘기면 안됨
				DP[selectDay+selectTime]=Math.max(DP[selectDay+selectTime], DP[selectDay]+selectPrice);
				//(당일+일할 수 있는 날=해당 상담을 하는 마지막 날)에 다 일 하고 난 후의 최대 이익구하기
				//지금 현재 DP[한 상담을 하는 마지막 날]에 저장되어 있는 이익과 DP[당일]+이 상담을 하게 되면 얻는 이익 중 큰 수 저장
			}
			
			DP[i+1]=Math.max(DP[i+1], DP[i]); //해당 날짜에서 일한 최대이익 넣기
			
		}
		
		System.out.println(DP[N]);
	}
}

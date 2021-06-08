package com.company.baekjoon._1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 송복민_1138 {

	static int N;
	static int[] data;
	static ArrayList<Integer> list=new ArrayList<>();//인덱스가 큰 수부터 집어넣어서 확장시킬 것이기 때문에 가변적인 ArrayList선언
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		data=new int[N+1];//1~N
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = N; i >=1; i--) {//인덱스가 큰 수부터
			int leftNum=data[i];//값을 꺼내서
			list.add(leftNum, i);//ArrayList에 끼워넣음 
								//-> 인덱스가 작은 수들(키 작은 사람들)이 사이에 껴도 인덱스가 큰 것(키 큰 사람)들은 상관 없음
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}

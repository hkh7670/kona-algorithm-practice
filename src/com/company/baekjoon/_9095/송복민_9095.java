package com.company.baekjoon._9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 송복민_9095 {

	static int T;
	static int[] data;
	static int num;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data=new int[11];
		data[1]=1;
		data[2]=2;
		data[3]=4;
		for (int i = 4; i < data.length; i++) {
			data[i]=data[i-1]+data[i-2]+data[i-3];
		}
		
		T=Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			num=Integer.parseInt(br.readLine());
			System.out.println(data[num]);
		}
	}
}

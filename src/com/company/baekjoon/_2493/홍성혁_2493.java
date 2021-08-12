package com.company.baekjoon._2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍성혁_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String[] inputList = new String[N];
		
		int[] topList = new int[N];
		int[] topReceiveList = new int[N];
		int[] result = new int[N];
		
		inputList = input.split(" ");
		for(int i = 0 ; i < N ; i++) {
			topList[i] = Integer.parseInt(inputList[i]);
			topReceiveList[i] = topList[i];
		}
		/*
		 * 탑 갯수 : 5
		 * 배열순서 0 1 2 3 4
		 * 탑의순서 6 9 5 7 4
		 */
		for(int i = N - 1 ; i >= 0 ; i--) {
			for(int j = i - 1 ; j >= 0 ; j--) {				
				if(topList[i] < topReceiveList[j]) {
					result[i] = j + 1;
					topReceiveList[j] = 0;
					break;
				}
			}
		}
		
		for(int i = 0 ; i < N ; i ++) {
			System.out.print(result[i] + " ");
		}
		
	}

}

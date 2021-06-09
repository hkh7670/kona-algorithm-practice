package com.company.baekjoon._1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍성혁_1138 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 4
		 * 2 1 1 0
		 * 왼쪽부터 0의 개수를 새서 자리 판단
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		String temp[] = br.readLine().split(" ");
		int player[] = new int[count + 1];
		int result[] = new int[count + 1];
		
		for(int i = 1 ; i <= count ; i++) {
			player[i] = Integer.parseInt(temp[i - 1]);
			
		}
		
		for(int i = 1 ; i <= count ; i++) {

			int cnt = 0;
			
			for(int j = 1 ; j <= count ; j++) {
				if(player[i] == cnt) {
					if(result[j] == 0) {
						result[j] = i;
						
					}
					//다른값이 이미 들어가 있는 경우 다음 빈칸에 입력
					else {
						for(int k = j+1 ; k <= count ; k++) {
							if(result[k] == 0) {
								result[k] = i;
								break;
							}
						}
					}
					break;
					
				}
				if(result[j] == 0) {
					cnt ++;
				}
				
				
			}
		}
		
		System.out.println("###result");
		for(int i=1;i<=count;i++) {
			System.out.println(result[i]);
		}
		
	}

}
/*
 *  ans[0] 4
 *  ans[3] 3
 *  ans[1] 2
 *  ans[2] 1
 *  4 2 1 3 
 */

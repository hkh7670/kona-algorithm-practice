package com.company.baekjoon._1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ȫ����_1138 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 4
		 * 2 1 1 0
		 * ���ʺ��� 0�� ������ ���� �ڸ� �Ǵ�
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
					//�ٸ����� �̹� �� �ִ� ��� ���� ��ĭ�� �Է�
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

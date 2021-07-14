package com.company.baekjoon._9663;

import java.util.Scanner;

public class 홍성혁_9663 {
	
	static int N;
	static int count;
	static int map[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N]; 
		System.out.println(N);
		dfs(0);
		
		System.out.println("count : " + count);
	}
	
	public static void dfs(int row) {
		if(row == N) {
			count ++;
			return;
		}
		
		for(int i = 0 ; i < N ; i ++) {
			map[row] = i;
			if(checkMap(row)) {
				dfs(row + 1);
			}
			
		}
	}
	
	public static boolean checkMap(int row) {
		for(int i = 0 ; i < row ; i++) {
			if(map[row] == map[i]) {
				return false;
			}
			/*
			 * OXXX
			 * XXOX
			 * 
			 */
			
			if(Math.abs(row - i ) == Math.abs(map[row] - map[i])) {
				return false;
			}
			
		}
		return true;
	}

}

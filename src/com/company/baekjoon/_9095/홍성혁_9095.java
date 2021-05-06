package com.company.baekjoon._9095;

import java.util.Scanner;

public class 홍성혁_9095 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();		
		int arr[] = new int [11];
		
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		arr[4] = 7;

		for(int i=5 ; i<=10 ; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
		for(int i=0 ; i<num; i++) {
			int n = scan.nextInt();
			System.out.println(arr[n]);
		}
	}

}
/*
https://jyami.tistory.com/15
arr[1] == 1
arr[2] == 1,1 / 2
arr[3] = 1,1,1/ 1,2 / 2,1 / 3
arr[4] = 1,1,1,1 / 1,1,2 / 1,2,1 / 2,1,1 / 2,2 / 1,3 / 3,1


*/
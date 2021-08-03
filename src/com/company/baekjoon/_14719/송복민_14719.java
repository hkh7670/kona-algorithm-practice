package com.company.baekjoon._14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 송복민_14719 {

	static int H, W;
	static int[] map;
	static int rain = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		map = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < W-1; i++) {
			int now = map[i];
			int highestLeft=0;
			int highestRight=0;
			
			for (int l = i; l >=0; l--) {//왼쪽 끝 ~ now 중 가장 높은 것
				highestLeft = Math.max(highestLeft, map[l]);
			}
			for (int r = i; r < W; r++) {//now ~ 오른쪽 끝 중 가장 높은 것
				highestRight = Math.max(highestRight, map[r]);
			}
			
			int min = Math.min(highestLeft, highestRight);//둘 중 작은 거 구하기
			rain += min - now;
		}
		
		System.out.println(rain);
	}
}

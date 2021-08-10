package com.company.baekjoon._8911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 송복민_8911 {

	static int T;
	static char[] order;
	static int area;
	static int[] di = {-1,0,1,0}; //->R, <-L
	static int[] dj = {0,1,0,-1}; //
	static int maxi,maxj,mini,minj,d,nowi,nowj;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String s=br.readLine();
			order = s.toCharArray();
			area = 0;
			maxi = 0;
			maxj = 0;
			mini = 0;
			minj = 0;
			d = 0;
			nowi = 0;
			nowj = 0;
			
			for (int i = 0; i < order.length; i++) {
				char o = order[i];
				
				if(o == 'F') {
					go(nowi,nowj,d);			
				}
				if(o == 'B') {
					int dBack = d;
					dBack -= 2; //방향 바꿔서
					if(dBack<0) {
						dBack += 4;
					}
					go(nowi,nowj,dBack);			
				}
				if(o == 'R') {
					d += 1;
					if(d==4) {
						d=0;
					}
				}
				if(o == 'L') {
					d -= 1;
					if(d==-1) {
						d=3;
					}
				}
//				System.out.println("nowi : "+nowi+", nowj : "+nowj);
//				System.out.println("maxi : "+maxi+", maxj : "+maxj+", mini : "+mini+", minj : "+minj);
			}
			
			int width=Math.abs(maxj-minj);
			int height=Math.abs(maxi-mini);
			area = width * height;
			System.out.println(area);
		}
	}
	private static void go(int i, int j, int d) {
		//이동
		nowi = i + di[d];
		nowj = j + dj[d];
		
		//비교
		maxi=Math.max(maxi, nowi);
		maxj=Math.max(maxj, nowj);
		mini=Math.min(mini, nowi);
		minj=Math.min(minj, nowj);
		
	}
}

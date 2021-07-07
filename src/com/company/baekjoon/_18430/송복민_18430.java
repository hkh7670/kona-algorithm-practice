package com.company.baekjoon._18430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 송복민_18430 {

	static int N,M;
	static int[][] data;
	static boolean[][] visit;
	static int[][] by= {{0,0,1},{-1,0,0},{-1,0,0},{0,0,1}};
	static int[][] bx= {{-1,0,0},{0,0,-1},{0,0,1},{1,0,0}};
	static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		//부메랑을 만들 수 없는 경우
		if(N==1 || M==1) {
			System.out.println(max);
			return;
		}
		
		data=new int[N][M];
		visit=new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bt(0,0,0);
		System.out.println(max);
	}
	
	private static void bt(int y, int x, int sum) {
		
		if(x==M) {
			x=0;
			y++;
		}
		if(y==N) {
			max=Math.max(sum, max);
			return;
		}
		
		if(!visit[y][x]) {
			for (int b = 0; b < 4; b++) {
				int one_y=y+by[b][0];
				int one_x=x+bx[b][0];
				int two_y=y+by[b][2];
				int two_x=x+bx[b][2];
				if(!safe(one_y,one_x) || !safe(two_y,two_x)) continue;
				if(visit[one_y][one_x] || visit[two_y][two_x]) continue;
				
				visit[y][x]=true;
				visit[one_y][one_x]=true;
				visit[two_y][two_x]=true;
				int bsum=sum+(data[one_y][one_x]+data[two_y][two_x]+(2*data[y][x]));
				bt(y, x+1, bsum);
				visit[y][x]=false;
				visit[one_y][one_x]=false;
				visit[two_y][two_x]=false;
				
			}
		}
		bt(y,x+1,sum);
	}

	private static boolean safe(int y, int x) {
		if(y>=0&&y<N&&x>=0&&x<M)
			return true;
		else
			return false;
	}
}

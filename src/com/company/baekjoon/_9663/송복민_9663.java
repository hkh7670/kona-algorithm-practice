package com.company.baekjoon._9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 송복민_9663 {

	static int N;
	static int answer;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
	}
	
	/*
	 메모리 초과
	static int N;
	static int[] num;
	static boolean[] visit;
	static int[][] map;
	static int answer;
	static int[] dy= {-1,-1,-1,0,1,1,1,0};
	static int[] dx= {-1,0,1,1,1,0,-1,-1};
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		num=new int[N*N];
		visit=new boolean[N*N];
		
		//N*N개중 N개 선택
		bt(0,0);
		
		System.out.println(answer);
		
	}
	private static void bt(int start, int cnt) {

		if(cnt==N) {
			map=new int[N][N];
			//퀸이 있을 수 있는 자리 map에 표현
			for (int i = 0; i < N; i++) {
				int select=num[i];
				int y=select/N;
				int x=select%N;
				map[y][x]=1;
				System.out.print(select+" ");
			}
			System.out.println();
			//8방으로 공격할 수 있는지 확인
			for (int i = 0; i < N; i++) {
				for (int d = 0; d < 8; d++) {
					int select=num[i];
					int y=select/N;
					int x=select%N;
					
					//8방향중 한방향으로 쭉 이동
					while(true) {
						int ny=y+dy[d];
						int nx=x+dx[d];
						if(!safe(ny,nx)) break;//벽 찍으면 탈출
						if(map[ny][nx]==1) return;//공격가능
						y=ny;
						x=nx;
					}
				}
			}
			answer++;
			return;
		}
		for (int i = start; i < N*N; i++) {
			if(!visit[i]) {
				visit[i]=true;
				num[cnt]=i;
				bt(i,cnt+1);
				visit[i]=false;
			}
		}
	}
	private static boolean safe(int y, int x) {
		if(y>=0&&y<N&&x>=0&&x<N)
			return true;
		else
			return false;
	}
	*/
}

package com.company.baekjoon._1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 송복민_Main_1012_유기농배추 {

	static int T;
	static int M, N, K;
	static int X, Y;
	static int[][] map;
	static int earthworm=0;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for (int t = 1; t <=T; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			map=new int[N][M];
			
			for (int k = 0; k < K; k++) {
				st=new StringTokenizer(br.readLine());
				X=Integer.parseInt(st.nextToken());
				Y=Integer.parseInt(st.nextToken());
				map[Y][X]=-1;
			}
//			print(map);
			
			earthworm=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==-1) {
						earthworm++;
						dfs(i,j,earthworm);
					}
				}
			}
			System.out.println(earthworm);
		}
	}
	private static void dfs(int i, int j, int earthworm) {
		if(map[i][j]==-1) {
			map[i][j]=earthworm;
		}
		for (int d = 0; d < 4; d++) {
			int ny=i+dy[d];
			int nx=j+dx[d];
			if(!safe(ny,nx)||map[ny][nx]>=0) continue;
			dfs(ny,nx,earthworm);
		}
		return;
	}
	private static boolean safe(int y, int x) {
		if(y>=0&&y<N&&x>=0&&x<M)
			return true;
		else
			return false;
	}
	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
				
			}
			System.out.println();
		}
		
	}
}

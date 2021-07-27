package com.company.baekjoon._17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 송복민_17070 {

	static int N;
	static int[][] map;
	static int move=0; //이동시킬 수 없는 경우 0
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//방향 : 0가로, 1세로, 2대각선
		//(1,2)에 0가로 파이프가 놓여있음
		dfs(1,2,0);
		
		System.out.println(move);
	}
	
	private static void dfs(int i, int j, int d) {
		if(i==N && j==N &&map[i][j]!=1) {//N*N에 도착하면서 그 위치에 파이프가 없으면 +1
			move++;
			return;
		}
		
		if(d==0) {//방향 가로일때
			//가로방향으로 갈 수 있음
			if(safe(i,j+1)&&map[i][j+1]==0) {
				dfs(i,j+1,0);
			}
			//대각선방향으로 갈 수 있음
			if(safe(i+1,j+1)&&map[i][j+1]==0&&map[i+1][j]==0&&map[i+1][j+1]==0) {
				dfs(i+1,j+1,2);
			}
			
		} else if(d==1) {//방향 세로일때
			//세로방향으로 갈 수 있음
			if(safe(i+1,j)&&map[i+1][j]==0) {
				dfs(i+1,j,1);
			}
			//대각선방향으로 갈 수 있음
			if(safe(i+1,j+1)&&map[i][j+1]==0&&map[i+1][j]==0&&map[i+1][j+1]==0) {
				dfs(i+1,j+1,2);
			}
			
		} else if(d==2) {//방향 대각선일때
			//가로방향으로 갈 수 있음
			if(safe(i,j+1)&&map[i][j+1]==0) {
				dfs(i,j+1,0);
			}
			//세로방향으로 갈 수 있음
			if(safe(i+1,j)&&map[i+1][j]==0) {
				dfs(i+1,j,1);
			}
			//대각선방향으로 갈 수 있음
			if(safe(i+1,j+1)&&map[i][j+1]==0&&map[i+1][j]==0&&map[i+1][j+1]==0) {
				dfs(i+1,j+1,2);
			}
		}
		
	}

	private static boolean safe(int i, int j) {
		if(i>=1&&i<=N&&j>=1&&j<=N)
			return true;
		else
			return false;
	}
}

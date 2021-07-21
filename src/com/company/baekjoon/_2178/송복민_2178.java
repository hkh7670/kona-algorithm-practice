package com.company.baekjoon._2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 송복민_2178 {

	static int N, M;
	static int[][] map;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		for (int i = 1; i < N+1; i++) {
			String s= br.readLine();
			for (int j = 1; j < M+1; j++) {
				if(s.charAt(j-1)=='1') {
					map[i][j]=-1;
				}else {
					map[i][j]=0;
				}
			}
		}
//		print(map);
		
		Queue<Point> que=new LinkedList<>();
		map[1][1]=1;
		que.offer(new Point(1,1,1));
		
		while(!que.isEmpty()) {
			Point p=que.poll();
			for (int d = 0; d < 4; d++) {
				int ny=p.y+dy[d];
				int nx=p.x+dx[d];
				int nd=p.d+1;
				if(!safe(ny,nx)) continue;
				if(map[ny][nx]==0||map[ny][nx]!=-1) continue;
				map[ny][nx]=nd;
				que.offer(new Point(ny,nx,nd));
			}
		}
		
		System.out.println(map[N][M]);
	}
	
	private static void print(int[][] map) {
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean safe(int y, int x) {
		if(x>=1&&x<=M&&y>=1&&y<=N)
			return true;
		else
			return false;
	}

	static class Point{
		int y;
		int x;
		int d;
		
		public Point(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
	}
}

package com.company.baekjoon._11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 송복민_11559 {

	static char[][] map;
	static boolean[][] visit;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {1,-1,0,0};
	static int boom;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		map=new char[12][6];
		for (int i = 0; i < 12; i++) {
			String s=br.readLine();
			map[i]=s.toCharArray();
		}
//		print(map);
		
		boom=0;
		Queue<Point> que=new LinkedList<>();//BFS
		Queue<Point> boomQue=new LinkedList<>();//터질 뿌요 담는 큐
		
		while(true) {
			visit=new boolean[12][6];
			boolean boomcheck=false;
			
			//터지기
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					char puyo=map[i][j];
					if(puyo=='.') continue;
					que.offer(new Point(i,j));
					boomQue.offer(new Point(i,j));
					visit[i][j]=true;
					
					while(!que.isEmpty()) {
						Point p=que.poll();
						for (int d = 0; d < 4; d++) {
							int ny=p.y+dy[d];
							int nx=p.x+dx[d];
							if(!safe(ny,nx) || map[ny][nx]=='.') continue;
							if(visit[ny][nx]) continue;
							if(map[ny][nx]==puyo) {
								que.offer(new Point(ny,nx));
								boomQue.offer(new Point(ny,nx));
								visit[ny][nx]=true;
							}
						}
					}
					//4개 이상인지 확인
					int size=boomQue.size();
					//4개 이상이면 터짐
					if(size>=4) {
						for (int k = 0; k < size; k++) {
							Point bq=boomQue.poll();
							map[bq.y][bq.x]='.';
							boomcheck=true;
						}
					}else {//4개이상 아니면 터질 뿌요 담는 큐 리셋
						boomQue.clear();
					}
				}
			}
			if(boomcheck) {
				//연쇄+1
				boom++;
			}else {
				break;
			}
			
			//중력
			for (int j = 0; j < 6; j++) {
				for (int i = 10; i >=0; i--) {//i=11은 바닥
					char puyo=map[i][j];
					if(puyo=='.') continue;
					//다른 뿌요 or 바닥까지 내려옴
					int floor=i;
					while(floor!=11) {
						if(map[floor+1][j]=='.') {
							map[floor][j]='.';
							map[floor+1][j]=puyo;
						}else {
							break;
						}
						floor++;
					}
				}
			}
		}
		System.out.print(boom);
	}

	
	private static void print(char[][] map) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean safe(int y, int x) {
		if(y>=0&&y<12&&x>=0&&x<6) return true;
		else return false;
	}

	static class Point{
		int y;
		int x;
		
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
package com.company.baekjoon._1012;

public class 홍성혁_1012 {

	static int T = 2;
	static int M = 10;
	static int N = 8;
	static int K = 17;
	static int[][] map; 
	static boolean[][] visit;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {		
		
		
		for(int i=0 ; i<T ; i++) {
			int count = 0;
			map = new int[M][N];
			visit = new boolean[M][N];
			
			
			map = inputMap(map);
			
			for(int j=0 ; j<M ; j++) {
				for(int k=0 ; k<N ; k++) {
					if(map[j][k]==1 && !visit[j][k]) {
						dfs(j,k);
						count ++;
					}
				}
			}
			
			System.out.println(count);
			
		}
		
	}
	
	public static void dfs(int r, int c) {
		visit[r][c] = true;
		
		for(int i=0 ; i<4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nc>=0 && nr<M && nc<N) {
				if(map[nr][nc] == 1 && !visit[nr][nc]) {
					dfs(nr,nc);
				}
			}
			
		}
	}
	
	public static int[][] inputMap(int[][]map){
		int[][]result = new int[M][N];
		
		result[0][0] = 1;
		result[1][0] = 1;
		result[1][1] = 1;
		result[4][2] = 1;
		result[4][3] = 1;
		result[4][5] = 1;
		result[2][4] = 1;
		result[3][4] = 1;
		result[7][4] = 1;
		result[8][4] = 1;
		result[9][4] = 1;
		result[7][5] = 1;
		result[8][5] = 1;
		result[9][5] = 1;
		result[7][6] = 1;
		result[8][6] = 1;
		result[9][6] = 1;
		
		
		return result;
	}

}

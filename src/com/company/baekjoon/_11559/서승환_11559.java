package com.company.baekjoon._11559;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class 서승환_11559 {
    static char[][] map = new char[12][6];
    static boolean[][] check = new boolean[12][6];
    static int[][] dXY = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean boom;
    static int chain;
    public static void main(String[] args) throws Exception, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}

        do {
			boom = false;
			for (int i = 0; i < check.length; i++) {
				Arrays.fill(check[i], false);
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(!check[i][j] && map[i][j] != '.') {
						bfs(new Location(i,j));
					}
				}
			}
			
			if(boom) {
				chain++;
				gravity();
			}
		} while (boom);
		
		bw.write(String.valueOf(chain));
        bw.flush();
    }

    static void bfs(Location loc) {
		Queue<Location> save = new LinkedList<Location>();
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(loc);
		save.add(loc);
		check[loc.x][loc.y] = true;
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.poll().y;

			for (int i = 0; i < dXY.length; i++) {
				int nr = x + dXY[i][0];
				int nc = y + dXY[i][1];
				
				if(dXYCheck(nr, nc) && !check[nr][nc] && map[nr][nc] == map[x][y]) {
					cnt++;
					check[nr][nc] = true;
					queue.add(new Location(nr,nc));
					save.add(new Location(nr,nc));
				}
			}
		}
		
		if(cnt >= 4) {
			boom = true;
			while (!save.isEmpty()) {
				map[save.peek().x][save.poll().y] = '.';
			}
		} 
	}
	
	static void gravity() {
		char[][] tmp = new char[12][6];
		for (int i = 0; i < tmp.length; i++) {
			Arrays.fill(tmp[i], '.');
		}
		
		for (int i = 0; i < map[0].length; i++) {
			int row = map.length-1;
			for (int j = map.length-1; j >= 0; j--) {
				if(map[j][i] != '.') {
					tmp[row--][i] = map[j][i];
				}
			}
		}
		map = tmp;
	}
	
	static boolean dXYCheck(int x, int y) {
		return x >= 0 && x < 12 && y >= 0 && y < 6;
	}

    protected static class Location{
        int x;
        int y;
        Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }; 
};

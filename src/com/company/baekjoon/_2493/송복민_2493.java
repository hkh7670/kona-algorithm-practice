package com.company.baekjoon._2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 송복민_2493 {

	static int N;
	static Stack<Point> stack = new Stack<>();
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek().height < n) 
					stack.pop();
				else { 
					System.out.print(stack.peek().index + " ");
					break;
				}
			}
			
			if(stack.isEmpty()) { 
				System.out.print("0 ");
			}
			stack.push(new Point(i+1,n)); 
		}
	}
	public static class Point {
		int index;
		int height;
		
		public Point(int index, int height) {
			super();
			this.index = index;
			this.height = height;
		}
		
	}
}

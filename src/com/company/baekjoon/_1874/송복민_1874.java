package com.company.baekjoon._1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 송복민_1874 {

	static int N;
	static int[] data;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		data=new int[N+1];
		Stack<Integer> st=new Stack<>();
		
		for (int i = 1; i <= N; i++) {
			data[i]=Integer.parseInt(br.readLine());
		}
		
		int num=1;
		for (int i = 1; i <= N; i++) {
			st.push(i);
			sb.append("+").append("\n");
			
			while(!st.isEmpty()&&st.peek()==data[num]) {
				st.pop();
				sb.append("-").append("\n");
				num++;
			}
		}
		if(st.isEmpty()) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
			return;
		}
	}
}

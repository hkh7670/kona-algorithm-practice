package com.company.baekjoon._1874;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 홍성혁_1874 {
	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		int j = 0;	
		int number = 1;
		String result = "";
		for(int i=0 ; i<n ; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		while(j<n) {
			if(number == n+1 && !(stack.peek().equals(list[j]))) {
				bw.write("NO");
                bw.flush();
                bw.close();
				return;
			}
			if(!stack.empty()) {
				if(stack.peek().equals(list[j])) {
					j++;
					stack.pop();
					sb.append("-\n");
					continue;
				}
			}
			stack.push(number++);
			sb.append("+\n");
		}
		bw.write(sb.toString());
        bw.flush();
        bw.close();
	}

}

package com.company.baekjoon._8911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 홍성혁_8911 {
	public enum directionEnum {
		EAST, WEST, NORTH, SOUTH
	}	
	static String direction;
	static int curX, curY, minX, minY, maxX, maxY;
	
	//(가장 큰 X좌표 - 가장 작은 X좌표) * (가장 큰 Y좌표 - 가장 작은 Y좌표)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			
			String input = br.readLine();		
			
			init();
			char[] inputArr = input.toCharArray();
			for(int j = 0 ; j < inputArr.length ; j ++) {
				
				moveDirection(Character.toString(inputArr[j]));
				checkPosition();
				//printPosition();
			}
			System.out.println((maxX - minX) * (maxY - minY));
		}
	}
	public static void init() {
		curX = 0;
		curY = 0;
		minX = 0;
		minY = 0;
		maxX = 0;
		maxY = 0;
		direction = "NORTH";
	}
	public static void printPosition() {
		System.out.println("---------------------");
		System.out.println("minX : " + minX);
		System.out.println("maxX : " + maxX);
		System.out.println("minY : " + minY);
		System.out.println("maxY : " + maxY);
		System.out.println("---------------------");
	}
	public static void checkPosition() {
		minX = Math.min(minX, curX);
        maxX = Math.max(maxX, curX);
        minY = Math.min(minY, curY);
        maxY = Math.max(maxY, curY);
	}
	
	public static void moveDirection(String input) {
		/*
		 * System.out.println("INPUT : " + input); System.out.println("direction : " +
		 * direction);
		 */
		if("F".equals(input)) {
			switch(direction) {
			case "NORTH":
				curY ++;
				break;
			case "SOUTH":
				curY --;
				break;
			case "EAST":
				curX ++;
				break;
			case "WEST":
				curX --;
				break;
			
			}			
		}else if("B".equals(input)){
			switch(direction) {
			case "NORTH":
				curY --;
				break;
			case "SOUTH":
				curY ++;
				break;
			case "EAST":
				curX --;
				break;
			case "WEST":
				curX ++;
				break;
			
			}			
		}else if("L".equals(input)) {
			switch(direction) {
			case "NORTH":
				direction = "WEST";
				break;
			case "SOUTH":
				direction = "EAST";
				break;
			case "EAST":
				direction = "NORTH";
				break;
			case "WEST":
				direction = "SOUTH";
				break;
			}			
		}else if("R".equals(input)) {
			switch(direction) {
			case "NORTH":
				direction = "EAST";
				break;
			case "SOUTH":
				direction = "WEST";
				break;
			case "EAST":
				direction = "SOUTH";
				break;
			case "WEST":
				direction = "NORTH";
				break;
			}
		}
	}

}

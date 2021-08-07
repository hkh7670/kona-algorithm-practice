package com.company.baekjoon._8911;

import java.io.*;

public class 한규호_8911 {

    static final int NORTH = 1;
    static final int SOUTH = 2;
    static final int EAST = 3;
    static final int WEST = 4;

    static final char FORWARD = 'F'; // 전진
    static final char BACKWARD = 'B'; // 후진
    static final char LEFT = 'L'; // 왼쪽 회전
    static final char RIGHT = 'R'; // 오른쪽 회전

    static int minX;
    static int maxX;
    static int minY;
    static int maxY;
    static int curX; // 현재 x 좌표
    static int curY; // 현재 y 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int minArea;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String testCase = br.readLine();
            minArea = getMinimumArea(testCase);
            bw.write(minArea + "\n");
        }
        bw.close();
        br.close();
    }

    public static int getMinimumArea(String testCase) {
        setToZero();
        int direction = NORTH;
        for (char c : testCase.toCharArray()) {
            switch (c) {
                case FORWARD:
                case BACKWARD:
                    setCurrentPosition(direction, c);
                    getMinMaxXY();
                    break;
                case LEFT:
                case RIGHT:
                    direction = getDirection(direction, c);
                    break;
                default:
                    break;
            }
        }
        return (maxX - minX) * (maxY - minY);
    }

    public static void setToZero() {
        minX = 0;
        minY = 0;
        maxX = 0;
        maxY = 0;
        curX = 0;
        curY = 0;
    }

    public static void getMinMaxXY() {
        minX = Math.min(minX, curX);
        maxX = Math.max(maxX, curX);
        minY = Math.min(minY, curY);
        maxY = Math.max(maxY, curY);
    }

    public static void setCurrentPosition(int direction, char moveType) {
        if (moveType == FORWARD) {
            if (direction == NORTH) {
                curY++;
            }
            else if (direction == SOUTH) {
                curY--;
            }
            else if (direction == EAST) {
                curX++;
            }
            else {
                curX--;
            }
        }
        else {
            if (direction == NORTH) {
                curY--;
            }
            else if (direction == SOUTH) {
                curY++;
            }
            else if (direction == EAST) {
                curX--;
            }
            else {
                curX++;
            }
        }
    }

    public static int getDirection(int direction, char rotationDir) {
        if (rotationDir == LEFT) {
            if (direction == NORTH) {
                return WEST;
            }
            else if (direction == SOUTH) {
                return EAST;
            }
            else if (direction == EAST) {
                return NORTH;
            }
            else {
                return SOUTH;
            }
        }
        else {
            if (direction == NORTH) {
                return EAST;
            }
            else if (direction == SOUTH) {
                return WEST;
            }
            else if (direction == EAST) {
                return SOUTH;
            }
            else {
                return NORTH;
            }
        }
    }
}
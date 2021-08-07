package com.company.baekjoon._8911;

import java.io.*;

public class 한규호_8911 {
    static final int north = 1;
    static final int south = 2;
    static final int east = 3;
    static final int west = 4;
    static int minX;
    static int maxX;
    static int minY;
    static int maxY;
    static int curX;
    static int curY;

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
        int direction = north;
        for (char c : testCase.toCharArray()) {
            switch (c) {
                case 'F':
                case 'B':
                    setCurrentPosition(direction, c);
                    getMinMaxXY();
                    break;
                case 'L':
                case 'R':
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
        if (moveType == 'F') {
            if (direction == north) {
                curY++;
            }
            else if (direction == south) {
                curY--;
            }
            else if (direction == east) {
                curX++;
            }
            else {
                curX--;
            }
        }
        else {
            if (direction == north) {
                curY--;
            }
            else if (direction == south) {
                curY++;
            }
            else if (direction == east) {
                curX--;
            }
            else {
                curX++;
            }
        }
    }

    public static int getDirection(int direction, char rotationDir) {
        if (rotationDir == 'L') {
            if (direction == north) {
                return west;
            }
            else if (direction == south) {
                return east;
            }
            else if (direction == east) {
                return north;
            }
            else {
                return south;
            }
        }
        else {
            if (direction == north) {
                return east;
            }
            else if (direction == south) {
                return west;
            }
            else if (direction == east) {
                return south;
            }
            else {
                return north;
            }
        }
    }
}
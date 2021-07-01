package com.company.baekjoon._11559;

import java.io.*;

/*

-- Test Case --

Y...YR
B.RGGY
R.GGYY
G.RYGR
YGYGRR
YBRYGY
RRYYGY
YYRBRB
YRBGBB
GBRBGR
GBRBGR
GBRBGR

answer: 14

*/


public class 한규호_11559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int row = 12;
    static int col = 6;
    static char[][] field = new char[row][col]; // 뿌요 필드
    static int[][] visit = new int[row][col]; // 뿌요 방문 맵
    static int puyoCnt = 0; // 인접 뿌요 수
    static int result = 0; // 최종 결과
    static boolean isExplode = false; // 뿌요 터짐 발생유무

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                field[i][j] = line.charAt(j);
            }
        }
        while (true) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (visit[i][j] == 0 && field[i][j] != '.') {
                        char item = field[i][j];
                        dfs(i, j, item);
                        if (puyoCnt >= 4) { // 인접 뿌요가 4개 이상 잡히면 뿌요 터짐 발생 -> 점으로 치환
                            explode();
                            bw.write("\n---visit(explode) map---\n");
                            print2ndArr(visit);
                            bw.write("\n---explode---\n");
                            print2ndArr(field);
                            isExplode = true;
                        }
                    }
                    visit = new int[row][col];
                    puyoCnt = 0;
                }
            }

            if (isExplode) { // 뿌요 터짐 발생 시 공중에 떠있는 뿌요들을 밑으로 내려주고 연쇄카운트 증가
                toGround();
                bw.write("\n---toGround---\n");
                print2ndArr(field);
                result++;
                isExplode = false;
            }
            else break;
        }

        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }

    public static void toGround() {
        for (int y = 0; y < col; y++) {
            char[] verticalLine = new char[row];
            int idx = 0;
            for (int x = row - 1; x >= 0; x--) {
                if (field[x][y] != '.') {
                    verticalLine[idx++] = field[x][y];
                }
            }
            for (int x = idx; x < row; x++) {
                verticalLine[x] = '.';
            }
            idx = 0;
            for (int x = row - 1; x >= 0; x--) {
                field[x][y] = verticalLine[idx++];
            }
        }
    }

    public static void explode() {
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (visit[x][y] == 1) {
                    field[x][y] = '.';
                }
            }
        }
    }

    public static void dfs(int x, int y, char item) {
        visit[x][y] = 1;
        puyoCnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ny >= 0 && ny < col && nx >= 0 && nx < row) {
                if (field[nx][ny] == item && visit[nx][ny] == 0) {
                    dfs(nx, ny, item);
                }
            }
        }
    }

    public static void print2ndArr(char[][] arr) throws IOException {
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.write("\n");
    }

    public static void print2ndArr(int[][] arr) throws IOException {
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                bw.write(Integer.toString(arr[i][j]));
            }
            bw.write("\n");
        }
        bw.write("\n");
    }
}

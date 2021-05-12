import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    static int[] dx = {1, -1, 0, 0}, dy={0,0,1,-1};
    static int CABBAGE = 1;
    static int answer, map[][], m, n;
    public static void main(String[] args) throws IOException {
        /**
         * 깊이 우선 탐색(DFS, Depth-First Search)
         * 
         * 특징 1. 순환 알고리즘 2. 트리 순회 3. 노드 방문 여부 반드시 검사
         * 
         * 방법 1. 순환 호출 2. 명시적인 스택
         * 
         */
        solution(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static void solution(BufferedReader br) throws IOException{
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i< T; i++){
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[n][m];

            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = CABBAGE;
            }

            for(int y=0; y<n; y++){
                for(int x=0; x<m; x++){
                    if(map[y][x] == CABBAGE){
                        answer++;
                        dfs(x,y);
                    }
            }
        }
        System.out.println(answer);
    }
    br.close();
}

    private static void dfs(int x, int y){
        map[y][x] = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isInArea(nx, ny , m, n)){
                if(map[ny][nx] == CABBAGE){
                    dfs(nx, ny);
                }
            }
        }
    }

    private static boolean isInArea(int x, int y, int m, int n){
        return x>=0 && x<m && y>=0 && y<n;
    }
}
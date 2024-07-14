package 신종신.주차4.w04_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] arr;
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                cnt = 0;
                if(!visited[i][j] && arr[i][j] == 1){
                    bfs(i, j);
                    ans.add(cnt);
                }
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for(int i : ans){
            System.out.println(i);
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            cnt++;
            int cur[] = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

package 최도혁.주차3.BOJ_1388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N,M,cnt=0;
    private static final String[][] tile = new String[50][50];
    private static final boolean[][] vis = new boolean[50][50];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int n=0; n<N; n++){
            tile[n] = br.readLine().split("");
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!vis[i][j]){
                    String t = tile[i][j];
                    cnt++;
                    dfs(i, j, t);
                }
            }
        }
        System.out.print(cnt);
    }

    static void dfs(int x, int y, String t){
        if(Objects.equals(t, tile[x][y])) {
            vis[x][y] = true;

            int nx = x+1;
            int ny = y+1;

            if(t.equals("-") && ny<M){
                dfs(x, ny, t);
            }
            if(t.equals("|") && nx<N) {
                dfs(nx, y, t);
            }
        }
    }
}

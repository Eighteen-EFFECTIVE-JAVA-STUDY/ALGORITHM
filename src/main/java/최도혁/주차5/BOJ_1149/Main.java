package 최도혁.주차5.BOJ_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] house = new int[3];
        int[][] DP = new int[N+1][3];
        DP[0][0] = 0;
        DP[0][1] = 0;
        DP[0][2] = 0;


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            house[0] = Integer.parseInt(st.nextToken());
            house[1] = Integer.parseInt(st.nextToken());
            house[2] = Integer.parseInt(st.nextToken());

            DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2])+house[0];
            DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2])+house[1];
            DP[i][2] = Math.min(DP[i-1][1], DP[i-1][0])+house[2];
        }
        System.out.print(Math.min(DP[N][0], Math.min(DP[N][1], DP[N][2])));
    }
}

package 신종신.주차1.w01_2559;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        dp = new int[N+1];

        token = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(token.nextToken());
            dp[i] = dp[i - 1] + num;
        }
        int st = 0;
        int ans = -10000001;
        for(int i = K; i <= N; i++){
            ans = Math.max(ans, dp[i] - dp[st]);
            st++;
        }
        System.out.println(ans);
    }
}

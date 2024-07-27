package 신종신.주차8.w08_1351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Long, Long> memo = new HashMap<>();
    static int p, q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        System.out.println(dp(n));

    }
    static long dp(long target){

        if(target==0) return 1;
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        memo.put(target, dp(target / p) + dp(target / q));
        return memo.get(target);
    }
}

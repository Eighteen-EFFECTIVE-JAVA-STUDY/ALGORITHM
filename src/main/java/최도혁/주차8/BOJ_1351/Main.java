package 최도혁.주차8.BOJ_1351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static int P;
    public static int Q;
    public static Map<Long,Long> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        dp.put(0L,1L);

        System.out.print(DP(N));
    }

    private static long DP(long n){
        if(dp.containsKey(n))
            return dp.get(n);
        else
            dp.put(n,DP(n/P) + DP(n/Q));

        return dp.get(n);
    }
}

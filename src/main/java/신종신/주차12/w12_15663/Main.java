package 신종신.주차12.w12_15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] ans;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        back(0);
    }

    static void back(int row){
        if(row == M){
            StringBuilder sb = new StringBuilder();
            for(int i : ans){
                sb.append(i).append(' ');
            }
            System.out.println(sb);
            return;
        }

        int x = 0;
        for(int i = 0; i < N; i++){
            if(!visit[i] && arr[i] != x){
                visit[i] = true;
                ans[row] = arr[i];
                x = ans[row];
                back(row + 1);
                visit[i] = false;
            }
        }
    }
}

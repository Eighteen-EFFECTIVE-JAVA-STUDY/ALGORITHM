package 신종신.주차3.w03_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int j = 0; j < T; j++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

            int cnt = 1;
            int tmp = arr[0][1];
            for (int i = 1; i < N; i++) {
                if (arr[i][1] < tmp) {
                    cnt++;
                    tmp = arr[i][1];
                }
            }
            System.out.println(cnt);
        }
    }
}

package 최도혁.주차3.BOJ_1946;

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

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for(int n=0; n<N; n++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                arr[n][0] = Integer.parseInt(st.nextToken());
                arr[n][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

            int cnt = 1;
            int temp = arr[0][1];
            for(int i=1; i<N; i++){
                if(arr[i][1] < temp){
                    cnt++;
                    temp = arr[i][1];
                }
            }
            System.out.println(cnt);
        }


    }
}

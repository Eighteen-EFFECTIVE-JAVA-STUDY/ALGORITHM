package eddy.주차11.W11_15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] output;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //bfs
        //입력받은 배열 정렬 후 중복 허용한 순열을 구하면 됨

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine()); // 공백을 기준으로 데이터를 분리

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        output = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        function(0);

    }

    static void function(int cnt){
        if(cnt == M){
            for(int i = 0; i<M; i++){
                System.out.printf(output[i]+" ");
            }
            System.out.println();
        }else{
            int before = 0;
            for(int i = 0; i<N; i++){
                if(visited[i]){
                    continue;
                }if(before != arr[i]){
                    visited[i] = true;
                    output[cnt] = arr[i];
                    before = arr[i];
                    function(cnt+1);
                    visited[i] = false ;

                }
            }
        }
    }

}











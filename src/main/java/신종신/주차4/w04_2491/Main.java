package 신종신.주차4.w04_2491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int Max = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cur = Integer.parseInt(st.nextToken());
        int ic = 1;
        int de = 1;

        for(int i = 1; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(cur < num){
                ic++;
                de = 1;
                cur = num;
            }
            else if(cur == num){
                ic++;
                de++;
            }
            else{
                de++;
                ic = 1;
                cur = num;
            }

            Max = Math.max(Math.max(ic, de), Max);
        }

        System.out.println(Max);
    }
}

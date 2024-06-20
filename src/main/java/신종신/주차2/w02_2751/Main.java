package 신종신.주차2.w02_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < N; i++) {

            int num = Integer.parseInt(br.readLine());
            arr.add(num);
        }

        Collections.sort(arr);

        for(int i : arr){
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}

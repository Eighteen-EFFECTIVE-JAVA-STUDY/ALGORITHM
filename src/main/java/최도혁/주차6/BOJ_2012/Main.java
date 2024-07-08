package 최도혁.주차6.BOJ_2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        while(N-- > 0){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        int rank = 1;
        long result = 0;
        for (Integer num : list) {
            result += Math.abs(num-rank);
            rank++;
        }
        System.out.print(result);
    }
}

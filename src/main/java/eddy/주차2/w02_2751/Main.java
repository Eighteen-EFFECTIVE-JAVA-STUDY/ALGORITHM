package eddy.주차2.w02_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int inputNo = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for ( int i = 0; i < inputNo; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for ( int i = 0; i < inputNo; i++){
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);

    }
}

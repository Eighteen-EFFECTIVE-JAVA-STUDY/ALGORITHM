package 최도혁.주차7.BOJ_1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> booksSoldToday = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String book = br.readLine();

            booksSoldToday.put(book, booksSoldToday.getOrDefault(book, 1)+1);
        }

        List<Map.Entry<String, Integer>> bestSeller = new LinkedList<>(booksSoldToday.entrySet());
        bestSeller.sort(Map.Entry.<String, Integer>comparingByValue(Collections.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()));

        System.out.print(bestSeller.get(0).getKey());
    }
}

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

            if(booksSoldToday.containsKey(book)){
                booksSoldToday.put(book,booksSoldToday.get(book)+1);
            } else {
                booksSoldToday.put(book,1);
            }
        }

        List<Map.Entry<String, Integer>> bestSeller = new LinkedList<>(booksSoldToday.entrySet());
        bestSeller.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue()))
                return o1.getKey().compareTo(o2.getKey());
            return o2.getValue() - o1.getValue();
        });

        System.out.print(bestSeller.get(0).getKey());
    }
}

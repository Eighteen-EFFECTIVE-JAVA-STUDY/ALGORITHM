package eddy.주차7.w7_1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>(); // Map  선언

        int max = 0;
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
            //map 안에 값 넣기
            //getORDefault(찾는 키값 , 찾는 키의 value 값이 없거나 null일때 반환하는 값)
            // : null 대신 기본 값을 반환하는 메소드
            max = Math.max(max, map.get(book));
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {  //entrySet() 이용해 Map의 전체 키와 value를 꺼냄
            if (entry.getValue() == max)list.add(entry.getKey());
        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }

}

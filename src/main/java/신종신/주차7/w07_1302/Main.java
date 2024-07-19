package 신종신.주차7.w07_1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int Max = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(!map.containsKey(str)){
                map.put(str, 1);
            }
            else{
                map.put(str, map.get(str)+1);
            }

            Max = Math.max(Max, map.get(str));
        }

        List<String> ans = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == Max) ans.add(entry.getKey());
        }

        Collections.sort(ans);

        System.out.println(ans.get(0));
    }
}

package 신종신.주차5.w05_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> map;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        arr = new String[N + 1];

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            arr[i] = str;
            map.put(str, i);
        }

        for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(str.chars().allMatch(Character::isDigit)){
                System.out.println(arr[Integer.parseInt(str)]);
            }
            else{
                System.out.println(map.get(str));
            }
        }
    }
}

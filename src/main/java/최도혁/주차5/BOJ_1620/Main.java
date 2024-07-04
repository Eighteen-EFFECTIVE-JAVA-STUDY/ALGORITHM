package 최도혁.주차5.BOJ_1620;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,String> map = new HashMap<>();
        for(int n=1; n<=N; n++){
            String name = br.readLine();
            map.put(name, String.valueOf(n));
            map.put(String.valueOf(n),name);
        }

        for(int m=0; m<M; m++){
            bw.write(map.get(br.readLine()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}

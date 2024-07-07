package 신종신.주차6.w06_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            Deque<Integer> dq = new ArrayDeque<>();

            String commend = br.readLine();
            int len = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            for(int j = 0; j < len; j++){
                dq.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean isrv = false;
            boolean isError = false;

            for(char cmd : commend.toCharArray()){
                if(cmd == 'R'){
                    isrv = !isrv;
                    continue;
                }

                if(dq.isEmpty()){
                    isError = true;
                    break;
                }
                else{
                    if(isrv){
                        dq.pollLast();
                    }
                    else{
                        dq.pollFirst();
                    }
                }
            }

            if(!dq.isEmpty()){
                sb.append('[');
                if(isrv){
                    sb.append(dq.pollLast());
                    while (!dq.isEmpty()){
                        sb.append(',').append(dq.pollLast());
                    }
                }
                else{
                    sb.append(dq.pollFirst());
                    while (!dq.isEmpty()){
                        sb.append(',').append(dq.pollFirst());
                    }
                }
                sb.append(']').append('\n');
            }
            else{
                if(isError) sb.append("error\n");
                else{
                    sb.append("[]\n");
                }
            }
        }

        System.out.println(sb);
    }
}

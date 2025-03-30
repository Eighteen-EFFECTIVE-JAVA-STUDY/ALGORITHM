package 박상준.연습.거짓말1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 사람의 수
        final int N = Integer.parseInt(st.nextToken());
        // 파티의 수
        final int M = Integer.parseInt(st.nextToken());
        
        // 이야기의 진실을 아는 사람의 수
        final int truthPeopleCount = Integer.parseInt(br.readLine());
        
        boolean[] truthPeople = new boolean[N + 1];
        
        for (int i = 0; i < truthPeopleCount; i++) {
            int person = Integer.parseInt(br.readLine());
            truthPeople[person] = true;
        }
        
        // 인접 리스트
        List<Integer>[] adj = new ArrayList[N + 1];
        
        // M 개의 줄에 각 파티마다 오는 사람의 수와 번호
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        List[] parties = new ArrayList[M + 1];
        
        for (int i = 1; i <= M; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int peopleCount = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < peopleCount; j++) {
                int person = Integer.parseInt(st.nextToken());
                parties[i].add(person);
                
                //그래프 연결 ( 사람들이 같은 파티에 있으면 연결한다 )
                for (int k = 0; k < j; k++) {
                    int other = parties[i].get(k);
                }
            }
        }
    }
}

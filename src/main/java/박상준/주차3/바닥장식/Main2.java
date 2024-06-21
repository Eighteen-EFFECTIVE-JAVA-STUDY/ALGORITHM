package 박상준.주차3.바닥장식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName    : 박상준.주차3.바닥장식
 * fileName       : Main2
 * author         : sjunpark
 * date           : 24. 6. 21.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 21.        sjunpark       최초 생성
 */
public class Main2 {
    private static char[][] GRAPH;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        GRAPH = new char[N][M];
        
        // 그래프 그리기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                GRAPH[i][j] = line.charAt(j);
            }
        }
        
        // 그래프 dfs 순회
        
    }
    
    private static void dfs(int x, int y, int way) {
    
    }
    
}
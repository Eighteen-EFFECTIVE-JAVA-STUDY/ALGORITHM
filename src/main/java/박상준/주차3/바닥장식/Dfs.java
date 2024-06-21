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
public class Dfs {
    private static char[][] GRAPH;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        
        GRAPH = new char[N + 1][M + 1];
        
        // 그래프 그리기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                GRAPH[i][j] = line.charAt(j);
            }
        }
        
        visited = new boolean[N][M];
        
        // 그래프 dfs 순회
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
    }
    
    private static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= GRAPH.length || y >= GRAPH[0].length) {
            return;
        }
        
        char current = GRAPH[x][y];
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= GRAPH.length || ny >= GRAPH[0].length) {
                continue;
            }
            
            char next = GRAPH[nx][ny];
            
            boolean isSame = next == current;
            if (isSame && !visited[nx][ny] && (isHorizon(current, i) || isVertical(current, i))) {
                dfs(nx, ny);
            }
        }
    }
    
    private static boolean isHorizon(char currentType, int index) {
        return (currentType == '-') && (index == 0 || index == 1);
    }
    
    private static boolean isVertical(char currentType, int index) {
        return (currentType == '|') && (index == 2 || index == 3);
    }
}
package 박상준.주차4.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * packageName    : 박상준.주차4.단지번호붙이기
 * fileName       : M먀ㅜ
 * author         : ipeac
 * date           : 24. 6. 23.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 23.        ipeac       최초 생성
 */
public class Main {
    private static int[] DX = {0, 0, -1, 1};
    private static int[] DY = {1, -1, 0, 0};
    private static int[][] graph;
    
    private static int N;
    private static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        Queue<Integer> answers = new PriorityQueue<>();
        
        graph = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(""))
                               .mapToInt(Integer::parseInt)
                               .toArray();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && graph[i][j] == 1) {
                    answers.add(bfs(i, j));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(answers.size()).append("\n");
        
        while (!answers.isEmpty()) {
            sb.append(answers.poll()).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static int bfs(int x, int y) {
        int count = 1;
        visited[x][y] = true;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int currentX = current.x;
            int currentY = current.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = currentX + DX[i];
                int ny = currentY + DY[i];
                
                if (0 > nx || 0 > ny || nx >= N || ny >= N) {
                    continue;
                }
                
                if (graph[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                
                q.add(new Pair(nx, ny));
                visited[nx][ny] = true;
                count++;
            }
        }
        
        return count;
    }
    
    static class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}